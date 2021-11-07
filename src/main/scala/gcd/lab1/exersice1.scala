package lab1

import chisel3 . _
class exercise1(counterBits:UInt)extends Module{
    val io =IO(new Bundle{
        val result = Output(Bool())
    })
    val max = (1.U<<counterBits)-1.U
    val maxm =max.asSInt
    val count = RegInit(4.S(16.W))
    when(count === maxm){
        count := 0.S
    } .otherwise{
        count := count + 1.S
    }
    io.result := count (15.U)

}