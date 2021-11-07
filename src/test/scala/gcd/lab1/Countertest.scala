package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class Countertest extends FreeSpec with ChiselScalatestTester{
    "Counter task test" in {
        test(new Counter(3.U)){ c=>
        c.clock.step(20)
        
        }
    }
}