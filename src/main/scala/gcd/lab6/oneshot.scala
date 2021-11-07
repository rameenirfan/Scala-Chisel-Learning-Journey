package lab6
import chisel3 . _
import chisel3 . util . _
class oneshot (val max : Int , val min :Int = 0) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt ( log2Ceil ( max ) . W))
    })
    val counter = RegInit(min.U( log2Ceil ( max ) . W))
    val result_counter = RegInit(min.U(log2Ceil(max).W))
    val counter_buffer = max.U
    io.out := 0.U
    when (counter === max.U){
        result_counter := result_counter -1.U
        counter_buffer -1.U
        when (counter_buffer === 0.U) {
            counter := 0.U
        }
    }
    .otherwise{
        counter := counter+1.U
        result_counter := result_counter+1.U
    }
    io.out := result_counter
    
}