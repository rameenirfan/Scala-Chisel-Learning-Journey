package lab2
import chisel3 . _
import chisel3 . util . _
class encoder extends Module {
    val io = IO ( new Bundle {
        val in0 = Input ( UInt(32.W) ) 
        val in1 = Input ( UInt(32.W) )
        val in2 = Input ( UInt(32.W) )
        val in3 = Input ( UInt(32.W) )
        val sel_1 = Input ( UInt(4.W) )
        val sel_2 = Input ( UInt(4.W) )
        val out_1 = Output ( UInt(32.W) )
        val out_2 = Output ( UInt(32.W) )
        
    })
    io . out_1 := Mux1H ( io . sel_1 , Seq ( io . in0 , io . in1 ))
    io . out_2 := Mux1H ( io . sel_2 , Seq ( io . in2 , io . in3 ))
    
}