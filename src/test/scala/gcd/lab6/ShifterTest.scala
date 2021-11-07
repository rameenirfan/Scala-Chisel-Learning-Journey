package lab6
import org.scalatest._
import chisel3._
import chiseltest._

class ShifterTest extends FreeSpec with ChiselScalatestTester{
    "Shifter TEST" in {
        test(new Shifter()){c=>
        c.io.input(0).poke(1.U)
        c.io.input(1).poke(1.U)
        c.io.input(2).poke(1.U)
        c.io.input(3).poke(1.U)
        c.clock.step(1)
        c.io.output(0).expect(3.U)
        c.io.output(1).expect(3.U)
        c.io.output(2).expect(3.U)
        c.io.output(3).expect(3.U)
        }
    }
}