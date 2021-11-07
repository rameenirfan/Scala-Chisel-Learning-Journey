package lab4
import chisel3._
import chisel3.util._

class Immediate extends Module{
    val io = IO (new Bundle{
        val ins = Input (UInt(32.W))
        val pc = Input (UInt(32.W))
        val out = Output (SInt(32.W))
    })
    // Itype -13 -3 - 67 jalr
    when (io.ins(6,0) === 19.U | io.ins(6,0) === 13.U || io.ins(6,0) === 103.U) {
        io.out := io.ins(31,20).asSInt

    }

    //Stype - 23
     .elsewhen (io.ins(6,0) === 35.U){
        io.out:= Cat(io.ins(31,25),io.ins(11,7)).asSInt
    }


    // SBtye -63
    .elsewhen (io.ins(6,0) === 99.U){
        io.out:= ((Cat(io.ins(31),io.ins(7),io.ins(30,25),io.ins(11,8),0.U)) + io.pc).asSInt
    }

    // Utype -37 lui 17 auipc
    .elsewhen (io.ins(6,0) === 55.U | io.ins(6,0) === 23.U){
        io.out := io.ins(31,12).asSInt
    }

    // UJ type 6f 
    .elsewhen (io.ins(6,0) === 111.U){
        io.out := (Cat(io.ins(31),io.ins(30,21),io.ins(20),io.ins(19,12),0.U)+io.pc).asSInt
    }

    .otherwise{
        io.out := 0.S
    }





}