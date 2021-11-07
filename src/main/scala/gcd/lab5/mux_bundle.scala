package lab5
import chisel3 . _
import chisel3 . util . _
class Interface[T <: Data](gen : T) extends Bundle{
    val input_1 = Input(gen)
    val input_2 = Input(gen)
    val out_put = Output(gen)
    val select_1= Input(Bool())
}
class mux_bundle(size : SInt) extends Module{
    val io = IO(new Interface(size))
    io.out_put := Mux(io.select_1 , io.input_2 , io.input_1)
}