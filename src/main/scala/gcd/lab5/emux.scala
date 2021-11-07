// package lab5
// import chisel3 . _
// import chisel3 . util . _
// import scala.language.postfixOps;
// class interface_mux [T <: Data , Y <: Data](general : T , general1 : Y) extends Bundle{
//     val input = Input(general)
//     val input2= Input(general1)
//     val select = Input(Bool())
//     val output = Output(UInt(7.W)) 
// }
// class emux(size : SInt) extends Module {
//     val io = IO(new interface_mux(size))
//     io.output := Mux(io.select , io.input , io.input2)  
// }