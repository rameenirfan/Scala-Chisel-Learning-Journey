package lab6

import org.scalatest._
import chiseltest._
import chisel3._

class countertest extends FreeSpec with ChiselScalatestTester{
    "Counter Test" in {
        test(new counter(4)){ c=>            //if max count = 13 or 4
        
        c.clock.step(25)
        
        }
    }
}