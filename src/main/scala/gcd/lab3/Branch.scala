package lab3
import chisel3 . _
import chisel3 . util . _
class Branch extends Module{
    val io = IO(new Bundle{
        val input_a = Input(SInt(32.W))
        val input_b = Input(SInt(32.W))
        val op = Input(Bool())
        val fuc = Input(UInt(3.W))
        val output = Output(UInt(32.W))
        })
    io.output := 0.B
    switch(io.op){
        is(1.B){
            switch(io.fuc){
                is("b000".U){
                    when(io.input_a === io.input_b){
                        io.output := 1.B
                }}
                is("b001".U){
                    when(io.input_a =/= io.input_b){
                        io.output := 1.B
                }}
                is("b100".U){
                    when(io.input_a > io.input_b){
                        io.output := 1.B
                }}
                is("b101".U){
                    when(io.input_a < io.input_b){
                        io.output := 1.B
                }}}
                
            
        }
        
        
        
        
        
        }

}