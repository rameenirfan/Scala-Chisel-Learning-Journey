package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class muxlookuptest extends FreeSpec with ChiselScalatestTester{
    "Mux test" in {
        test(new muxlookup()){c=>
        c.io.in0.poke(0.B)
        c.io.in1.poke(0.B)
        c.io.in2.poke(0.B)
        c.io.in3.poke(0.B)
        c.io.in4.poke(0.B)
        c.io.in5.poke(0.B)
        c.io.in6.poke(0.B)
        c.io.in7.poke(1.B)
        c.io.sel1.poke(0.U)
        c.io.sel2.poke(3.U)
        c.io.bit_sel.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(1.B)
         
           
        }
    }
}