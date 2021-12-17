package riscv
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class top extends Module{
	val io = IO(new Bundle{
        val output = Output(UInt(32.W))
})
    val alu = Module(new ALU)
    val aluop = Module(new Aluop)
    val conDEC = Module(new ControlDec)
    val Conunit =Module (new ControlUnit)
    val mainmem = Module (new DataMem)
    val immediate = Module (new Immediate)
    val instrucution = Module (new InstMemory)
    val pc = Module (new PC)
    val reg = Module (new Regfile)
    val insDec = Module (new TypeDec)


    conDEC.io.Jal := instrucution.io.r_data(6,0)
    when (instrucution.io.r_data(6,0) === 111.U){
        pc.io.input := immediate.io.out
    }

    .elsewhen(instrucution.io.r_data(6,0) === 99.U){
        pc.io.input := immediate.io.out
    }

    .elsewhen(instrucution.io.r_data(6,0) === 103.U){
        pc.io.input := immediate.io.out
    }
    .otherwise{
        pc.io.input := 0.U
    }
    
    instrucution.io.write_address := pc.io.pc_output
    insDec.io.opCode := instrucution.io.r_data(6,0)
    Conunit.io.opcode := insDec.io.opCode
    reg.io.imm_rs1 := instrucution.io.r_data(19,15)
    reg.io.imm_rs2 := instrucution.io.r_data(24,20)
    reg.io.rd_reg:= instrucution.io.r_data(11,7)
    reg.io.reg_write:=Conunit.io.RegWrite

    conDEC.io.load := instrucution.io.r_data(6,0)
    conDEC.io.Store := instrucution.io.r_data(6,0)

    immediate.io.Instruction:= instrucution.io.r_data
    immediate.io.PC := pc.io.pc_output
    (aluop.io.Inst).asUInt := instrucution.io.r_data
    aluop.io.branch := Conunit.io.Branch

    
    alu.io.in_1 := Mux((Conunit.io.Auipc).asBool,pc.io.pc_output,(reg.io.rs1_output).asUInt)


    val esi = ((Conunit.io.Immediate).asBool | (Conunit.io.U_type).asBool | (Conunit.io.store).asBool)
    alu.io.in_2 := Mux(esi,(immediate.io.out)asUInt,(reg.io.rs2_output).asUInt)
    alu.io.select := Mux(((Conunit.io.store).asBool|(Conunit.io.Load).asBool),0.U,aluop.io.AluOut)
    reg.io.write_data := (alu.io.output).asSInt


    mainmem.io.addr := alu.io.output(7,0)
    mainmem.io.store_data:= (alu.io.output).asSInt
    mainmem.io.load := Conunit.io.Load
    mainmem.io.store := Conunit.io.store
    reg.io.write_data :=  mainmem.io.Data_Out
    io.output :=mainmem.io.Data_Out
    // //rtype
    // condec.io.Rtype := 0.U
    // condec.io.Lui := 0.U
    // condec.io.auipc :=0.U
    // condec.io.Jalr :=0.U
    // condec.io.IType :=0.U
    // condec.io.SBType :=0.U
}