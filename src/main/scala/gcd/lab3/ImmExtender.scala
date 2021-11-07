package lab3
import chisel3._
import chisel3.util._

class ImmExtender extends Module{
    val io = IO (new Bundle{
        val ins = Input (SInt(32.W))
        val pc = Input (SInt(32.W))
        val opcode = Input (UInt(7.W))
        val out = Output (SInt(32.W))
    })
    // Itype -13 -3 - 67 jalr
    when (io.opcode === 19.U | io.opcode === 13.U || io.opcode === 103.U) {
        io.out := io.ins(31,20).asSInt

    }

    //Stype - 23
     .elsewhen (io.opcode === 99.U){
        io.out:= Cat(io.ins(31,25),io.ins(11,7)).asSInt
    }


    // SBtye -63
    .elsewhen (io.opcode === 99.U){
        io.out:= (Cat(io.ins(31),io.ins(7),io.ins(30,25),io.ins(11,8),0.U).asSInt) + io.pc
    }

    // Utype -37 lui 17 auipc
    .elsewhen (io.opcode === 55.U | io.opcode === 23.U){
        io.out := io.ins(31,12).asSInt
    }

    // UJ type 6f 
    .elsewhen (io.opcode === 111.U){
        io.out := Cat(io.ins(31),io.ins(30,21),io.ins(20),io.ins(19,12),0.U).asSInt
    }

    .otherwise{
        io.out := 0.S
    }





}