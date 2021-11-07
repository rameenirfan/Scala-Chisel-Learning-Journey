package lab4
import chisel3 . _
import chisel3 . util . _

object BALUOP {
    val ALU_BEQ = 0.U(2.W)
    val ALU_BNE = 1.U(2.W)
    val ALU_BGE = 2.U(2.W)
    val ALU_BLT =3.U(2.W)
    //val ALU_BLTU = 4.U(2.W)
    //val 
}


class Branch extends Module{
    val io = IO(new Bundle{
        val in_1 = Input(SInt(32.W))
        val in_2 = Input(SInt(32.W))
        val select = Input(UInt(2.W))
        val output = Output(Bool())
        })

            io.output := 0.B
            switch(io.select){
                is("b00".U){
                    when(io.in_1 === io.in_2){
                        io.output := 1.B}
                        .otherwise{
                            io.output := 0.B
                            
                        }
                }
                is("b01".U){
                    when(io.in_1 =/= io.in_2){
                        io.output := 1.B
                } .otherwise{
                            io.output := 0.B
                            
                        }
                }
                is("b10".U){
                    when(io.in_1 >= io.in_2){
                        io.output := 1.B
                } .otherwise{
                            io.output := 0.B
                            
                        }
                }
                is("b11".U){
                    when(io.in_1 < io.in_2){
                        io.output := 1.B
                } .otherwise{
                            io.output := 0.B
                            
                        }
                }
                

            
        }
        
        
        
        
        
        }