package lab6
import org.scalatest._
import chisel3._
import chiseltest._

class up_down_countertest extends FreeSpec with ChiselScalatestTester{
    "up_down_counter test" in {
        test(new up_down_counter()){c=>
            c.io.up_down.poke(1.B)
            c.clock.step(5)
            
         
           
        }
    }
}