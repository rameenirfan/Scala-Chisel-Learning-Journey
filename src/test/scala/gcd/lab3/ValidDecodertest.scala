package lab3
import org.scalatest._
import chisel3._
import chiseltest._

class ValidDecodertest extends FreeSpec with ChiselScalatestTester{
    "ValidDecoder" in {
        test(new Decoder2to4){c=>
            c.io.in.poke(2.U)
            c.io.out.valid.expect (1.B)
        //   c.io.output.poke(4.U)
            c.clock.step(100)
         
         
           
        }
    }
}