package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class encodertest extends FreeSpec with ChiselScalatestTester{
    "Encoder" in {
        test(new encoder()){c=>
        c.io.in0.poke(0.U)
        c.io.in1.poke(1 .U)
        c.io.in2.poke(0.U)
        c.io.in3.poke(0.U)
        c.io.sel_1.poke(2.U)

        c.clock.step(1)
        c.io.out_1.expect(1.U)
        c.io.out_2.expect(0.U)
         
           
        }
    }
}