package lab3
import org.scalatest._
import chisel3._
import chiseltest._

class Encoder4_to_2test extends FreeSpec with ChiselScalatestTester{
    "EncoderSwitch test" in {
        test(new Encoder4_to_2()){c=>
        c.io.input_en.poke(1.U)
        c.clock.step(1)
        c.io.output_en.expect(0.U)
        }
    }
}