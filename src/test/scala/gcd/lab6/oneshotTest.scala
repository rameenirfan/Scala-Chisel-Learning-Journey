package lab6

import org.scalatest._
import chiseltest._
import chisel3._

class oneshotTest extends FreeSpec with ChiselScalatestTester{
    "One Shot Timer" in {
        test(new oneshot(7)){ c=>
        c.clock.step(25)
        
        }
    }
}