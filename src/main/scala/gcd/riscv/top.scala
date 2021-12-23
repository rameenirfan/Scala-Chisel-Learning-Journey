package riscv
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class top extends Module{
	val io = IO(new Bundle{
        // val in = Input(UInt(32.W))
        val output = Output(UInt(32.W))
})
    val alu = Module(new ALU)
    val aluop = Module(new Aluop)
    // val  branch = Module(new Branch)//
   
    // val conunit =Module (new ControlUnit)
    val datameme = Module (new DataMem)//
    val immegen = Module (new Immediate)//
    val insmem = Module (new InstMemory)//(
    val pc = Module (new PC)//
    val regfile = Module (new Regfile)
    val tdeco = Module (new TypeDec())
    val cdec = Module (new ControlDec())
    

    //jal
    when (cdec.io.jalr === 1.U){
        pc.io.input := immegen.io.out.asUInt
    }
    //branch
    .elsewhen(cdec.io.branch === 1.U){
        pc.io.input := immegen.io.out.asUInt
    }
    //jalr
    .elsewhen(cdec.io.jalr === 1.U){
        pc.io.input := immegen.io.out.asUInt
    }
    .otherwise{
        pc.io.input := 0.U
    }
    
    insmem.io.addr := pc.io.pc_out
    //Opcode identify
    // typedec.io.opCode := insmem.io.inst(6,0)

    tdeco.io.opcode := insmem.io.inst(6,0)


    cdec.io.R := tdeco.io.R
    cdec.io.Load := tdeco.io.Load
    cdec.io.Store := tdeco.io.Store
    cdec.io.SB := tdeco.io.Branch
    cdec.io.I := tdeco.io.I
    cdec.io.Jalr := tdeco.io.Jalr
    cdec.io.Jal := tdeco.io.Jal
    cdec.io.Lui := tdeco.io.Lui
    cdec.io.Auipc := tdeco.io.Auipc






    //RegisterFile
    regfile.io.rs1_inp := insmem.io.inst(19,15)
    regfile.io.rs2_inp := insmem.io.inst(24,20)
    regfile.io.rd:= insmem.io.inst(11,7)
    regfile.io.reg_write:=cdec.io.RegWrite


    //Immediate Generator
    immegen.io.ins:= insmem.io.inst
    immegen.io.pc := pc.io.pc_out

    //ALUOP 
    (aluop.io.inst).asUInt := insmem.io.inst
    aluop.io.branch := cdec.io.branch

    //alu
    alu.io.in_1 := (Mux((cdec.io.auipc).asBool,(pc.io.pc_out).asSInt,regfile.io.rs1_out)).asUInt


    val esi = ((cdec.io.immediate).asBool | (cdec.io.lui).asBool | (cdec.io.store).asBool)
    alu.io.in_2 := (Mux(esi,(immegen.io.out)asSInt,regfile.io.rs2_out)).asUInt
    alu.io.select := (Mux(((cdec.io.store).asBool|(cdec.io.load).asBool),0.U,aluop.io.alu_out)).asUInt
    regfile.io.write_data := alu.io.output.asSInt

    //DataMemory

    datameme.io.addr := alu.io.output(7,0)
    datameme.io.datastore:= regfile.io.rs2_inp.asSInt
    datameme.io.load := cdec.io.load
    datameme.io.store := cdec.io.store
    regfile.io.write_data :=  datameme.io.data_Out
    io.output := alu.io.output

}
