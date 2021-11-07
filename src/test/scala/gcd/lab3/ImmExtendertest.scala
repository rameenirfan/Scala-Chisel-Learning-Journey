package lab3
import org.scalatest._
import chisel3._
import chiseltest._

class ImmExtendertest extends FreeSpec with ChiselScalatestTester{
    "ImmExtender" in {
        test(new ImmExtender){c=>
            c.io.ins.poke(3020000.S)
            c.io.pc.poke(3.S)
            c.io.opcode.poke(103.U)
        
            c.clock.step(100)
         
         
           
        }
    }
}