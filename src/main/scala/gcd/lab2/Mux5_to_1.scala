package lab2
import chisel3 . _
import chisel3.util._
// Mux IO interface class
class Mux5_to_1 extends Module {
    val io  = IO(new Bundle{
        val in_A = Input ( UInt (32.W) )
        val in_B = Input ( UInt (32.W) )
        val in_C = Input(UInt(32.W))
        val in_D = Input(UInt(32.W))
        val in_E = Input(UInt(32.W))
        val sel_1 = Input ( Bool () )
        val sel_2 = Input ( Bool () )
        val sel_3 = Input ( Bool () )
        val out = Output ( UInt (32.W) )
    })
    val mux_1 = Mux(io.sel_1 , io.in_A , io.in_B)
    val mux_2 = Mux(io.sel_1 , io.in_C , io.in_D)
    val mux_3 = Mux(io.sel_2 , mux_2 , mux_1)
    val mux_4 = Mux(io.sel_3 , io.in_E , mux_3)
    io.out := mux_4
}