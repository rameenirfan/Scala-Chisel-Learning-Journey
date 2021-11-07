package lab6
import chisel3._
import chisel3.util._

class up_down_counter (val max: Int = 32) extends Module{
    val io = IO (new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
        val up_down = Input(Bool())

    })
    val counter = RegInit (0.U(4.W))
    when (counter =/= max.U && io.up_down ===1.B) {
        counter := counter +1.U
    } .otherwise{
        counter := counter-1.U
    }
    
    io.out :=counter
}