package lab3
import chisel3 . _
import chisel3.util._
class ValidDecoder extends Bundle {
    val in = Input ( UInt (2. W ) )
    val out = Valid(Output ( UInt (4. W ) ))
}
class Decoder2to4 extends Module {
    val io = IO ( new ValidDecoder )
    when ( io . in === "b00" . U ) {
        io . out.bits := "b0001" . U
        io.out.valid := 0.B
    } .elsewhen ( io . in === "b01" . U ) {
        io . out.bits := "b0010" . U
        io.out.valid := 1.B
    } .elsewhen ( io . in === "b10" . U ) {
        io . out.bits := "b0011" . U
        io.out.valid := 1.B
    } .otherwise {
        io . out.bits := "b100" . U
        io.out.valid := 1.B
    }
}