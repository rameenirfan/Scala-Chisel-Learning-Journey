package lab1

import org.scalatest._
import chiseltest._
import chisel3._

class Exercise2test extends FreeSpec with ChiselScalatestTester{
    "Counter task test" in {
        test(new Exercise2(3.U)){ c=>
        c.clock.step(20)
        
    }
    }
}