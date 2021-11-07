package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class exercise1test extends FreeSpec with ChiselScalatestTester{
    "Counter ex1 test" in {
        test(new exercise1(3.U)){ c=>
        c.clock.step(20)
        
        }
    }
}