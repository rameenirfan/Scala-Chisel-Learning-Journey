package lab5
import chisel3 . _
import chisel3 . util . _
import scala.language.postfixOps;
class alu_width(width_parameter : Int) extends Module{
    val io = IO(new Bundle{
        val alu_op = Input(UInt(width_parameter.W))
        val arg_x = Input(UInt(width_parameter.W))
        val arg_y = Input(UInt(width_parameter.W))
        val alu_out = Output(UInt(width_parameter.W))
    })
    val index = log2Ceil(width_parameter)
    val signed = (io.arg_y) .asSInt
    when(io.alu_op==="b0000".U){
        io.alu_out:= io.arg_x & io.arg_y
    }
    .elsewhen(io.alu_op==="b0001".U){
        io.alu_out := io.arg_x | io.arg_y
    }
    .elsewhen(io.alu_op==="b0010".U){
        io.alu_out := io.arg_x + io.arg_y
    }
    .elsewhen(io.alu_op==="b0110".U){
        io.alu_out := io.arg_x - io.arg_y
    }
    .elsewhen(io.alu_op==="b0011".U){
        io.alu_out := io.arg_x ^ io.arg_y
    }
    .elsewhen(io.alu_op==="b0100".U){
        io.alu_out := io.arg_x << io.arg_y(index , 0)
    }
    .elsewhen(io.alu_op==="b0101".U){
        io.alu_out := io.arg_x >> io.arg_y(index , 0)
    }
    .elsewhen(io.alu_op === "b1000" .U){
        io.alu_out := io.arg_x .asSInt < signed
    }
    .elsewhen(io.alu_op==="b1001".U){
        io.alu_out := io.arg_x < io.arg_y
    }
    .otherwise{
        io.alu_out := 0.U
    }
    
}