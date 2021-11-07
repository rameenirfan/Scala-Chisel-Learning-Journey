package lab3
import chisel3._
import chisel3.util._

class ALU extends Module{
    val io = IO (new Bundle{
        val in_1 = Input (UInt(32.W))
        val in_2 = Input (UInt(32.W))
        val select = Input(UInt(5.W))
        val output = Output(UInt(32.W))
       
    })
    io.output := 0.U
    switch(io.select){
        is (0.U){
            io.output := io.in_1 + io.in_2
        }
        //sll
        is (1.U){
            io.output := io.in_1 << io.in_2(4,0)
        }
        //SLT
        is (2.U){
            when(io.in_1 < io.in_2){
                io.output:= 1.U
            }.otherwise{
                io.output:=0.U
            }
        
        }

        //xor
        is(4.U){
            io.output:=io.in_1^io.in_2
        }
        //slr
        is(5.U){
            io.output:=io.in_1 >> io.in_2(4,0)
        }
        //or
        is(6.U){
            io.output:=io.in_1 | io.in_2
            
        }
        //ANd
        is(7.U){
            io.output:=io.in_1 & io.in_2
        }
        //sub
         is(8.U){
            io.output:=io.in_1 - io.in_2
        }

    }    

}

