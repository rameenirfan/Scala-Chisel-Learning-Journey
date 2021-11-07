package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class LM_IO_Interfacetest extends FreeSpec with ChiselScalatestTester{
    "Mux 8 to 1 test" in {
        test(new Mux_8to1()){c=>
            c.io.in.poke(6.U)
            c.io.s0.poke(1.B)
            c.io.s1.poke(0.B)
            c.io.s2.poke(0.B)
            c.clock.step(100)
            c.io.out.expect(1.B)
         
           
        }
    }
}