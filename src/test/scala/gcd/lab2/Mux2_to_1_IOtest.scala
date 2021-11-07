package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class Mux2_to_1_IOtest extends FreeSpec with ChiselScalatestTester{
    "Mux 2 to 1 IO test" in {
        test(new Mux_2to_1()){c=>
            c.io.in_A.poke(12.U)
            c.io.in_B.poke(23.U)
            c.io.select.poke(1.B)
            c.clock.step(20)
            // c.io.out.expect(25.U)
         
           
        }
    }
}
