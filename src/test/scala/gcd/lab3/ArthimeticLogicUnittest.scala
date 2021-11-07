package lab3
import org.scalatest._
import chisel3._
import chiseltest._

class ArthimeticLogicUnittest extends FreeSpec with ChiselScalatestTester{
    "ALU" in {
        test(new ALU){c=>
          c.io.in_1.poke(4.U)
          c.io.in_2.poke(2.U)
          c.io.select.poke(2.U)
        //   c.io.output.poke(4.U)
          c.clock.step(100)
         
         
           
        }
    }
}