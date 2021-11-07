package lab6
import chisel3 . _
import chisel3 . util . _
class counter_with_xor (val max : Int = 32) extends Module{
    val io = IO(new Bundle{
        val output = Output(UInt(5 . W))
        })
    val reg = RegInit(0.U(5.W))
    val xor = reg(4) ^ 1.B
    
   
    
    when (xor === 0.B){
        reg := 0.U
    }
    .otherwise{
        reg := reg + 1.U
    }
    io.output := reg
    

}