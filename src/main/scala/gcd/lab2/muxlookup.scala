package lab2
import chisel3._
import chisel3.util._
class muxlookup extends Module{
    val io  = IO(new Bundle{
        val in0 = Input ( Bool () )
        val in1 = Input ( Bool () )
        val in2 = Input ( Bool () )
        val in3 = Input ( Bool () )
        val in4 = Input ( Bool () )
        val in5 = Input ( Bool () )
        val in6 = Input ( Bool () )
        val in7 = Input ( Bool () )
        var sel1 = Input ( UInt (3. W ) )
        var sel2 = Input ( UInt (3. W ) )
        val out = Output ( Bool () )
        val bit_sel = Input(Bool())})
val mux1 = MuxLookup ( io.sel1 , false .B , Array (
    (0. U ) ->  io . in0 ,
    (1. U ) ->  io . in1 ,
    (2. U ) ->  io . in2 ,
    (3. U ) ->  io . in3 ,
    ));
val mux2 = MuxLookup ( io.sel2 , false .B , Array (
    (0. U ) ->  io . in4 ,
    (1. U ) ->  io . in5 ,
    (2. U ) -> io . in6 ,
    (3. U ) -> io . in7,
    ));
val mux = MuxLookup ( io.bit_sel , true .B , Array (
    io.sel1  -> (0 . B)  ,
    io.sel2  -> (1 .  B),
    ))
    
    

io.out := mux
}