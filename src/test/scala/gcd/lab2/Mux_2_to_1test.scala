package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class Mux_2_to_1test extends FreeSpec with ChiselScalatestTester{
    "Mux 2 to 1 test" in {
        test(new Mux_2to1()){c=>
            c.io.in_A.poke(0.B)
            c.io.in_B.poke(1.B)
            c.io.select.poke(0.B)
            c.clock.step(20)
            c.io.out.expect(0.B)
         
           
        }
    }
}