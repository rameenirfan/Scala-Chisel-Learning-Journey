package lab2
import chisel3 . _
// Mux IO interface class
class Mux2_to_1_IO extends Bundle {
    val in_A= Input ( UInt (32.W) )
    val in_B= Input ( UInt (32.W) )
    val select = Input ( Bool () )
    val out = Output ( UInt (32.W))
}
// 2 to 1 Mux implementation
class Mux_2to_1 extends Module {
    val io = IO ( new Mux2_to_1_IO )
// update the output
    io . out := Mux ( io . select , io . in_A , io . in_B )
    // io . out := io . in_A & (~io . select) | io . in_B & io . select 
}