package lab2
import org.scalatest._
import chisel3._
import chiseltest._

class barrel_shittest extends FreeSpec with ChiselScalatestTester{
    "Barrel Shifter" in {
        test(new barrel_shift()){c=>
          c.io.in(0).poke(0.B)
          c.io.in(1).poke(0.B)
          c.io.in(2).poke(1.B)
          c.io.in(3).poke(0.B)
          c.io.sel(0).poke(0.B)
          c.io.sel(1).poke(0.B)
          c.io.shift_type.poke(0.B)
          c.clock.step(20)
         
           
        }
    }
}