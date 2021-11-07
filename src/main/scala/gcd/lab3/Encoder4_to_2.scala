package lab3
import chisel3._
import chisel3 . util . _

class Encoder4_to_2 extends Module{
    val io = IO(new Bundle{
        val input_en = Input(UInt(4.W))
        val output_en = Output(UInt(2.W))
    })
    io.output_en :=0.U
    switch(io.input_en){
        is(1.U){
            io.output_en:= 0.U
        }
        is (2.U){
            io.output_en := 1.U
        }
        is(3.U){
            io.output_en := 2.U
        }
        is(4.U){
            io.output_en := 3.U
        }
    }
}