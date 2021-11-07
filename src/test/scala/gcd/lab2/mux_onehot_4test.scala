package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class mux_onehot_4test extends FreeSpec with ChiselScalatestTester{
    "Mux one hot 4 to 1" in {
        test(new mux_onehot_4_to_1()){c=>
            c.io.in0.poke(1.U)
            c.io.in1.poke(1.U)
            c.io.in2.poke(0.U)
            c.io.in3.poke(1.U)
            c.io.sel.poke(1.U)
            
            c.clock.step(100)
            c.io.out.expect(1.U)
         
           
        }
    }
}