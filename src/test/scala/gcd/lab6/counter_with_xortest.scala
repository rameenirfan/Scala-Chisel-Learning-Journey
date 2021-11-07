package lab6

import org.scalatest._
import chiseltest._
import chisel3._

class counter_with_xortest extends FreeSpec with ChiselScalatestTester{
    "Counter_Xor" in {
        test(new counter_with_xor()){ c=>
        c.clock.step(25)
        
        }
    }
}