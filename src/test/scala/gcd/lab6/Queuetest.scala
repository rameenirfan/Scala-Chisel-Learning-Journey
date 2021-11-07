package lab6
import org.scalatest._
import chisel3._
import chiseltest._

class Queuetest extends FreeSpec with ChiselScalatestTester{
    "Queue test" in {
        test(new My_Queue()){c=>
            c.io.in.valid.poke(0.B)
            c.io.in.bits.poke(24.U)
            c.io.out.ready.poke(0.B)
            c.clock.step(5)
            
         
           
        }
    }
}