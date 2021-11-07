package lab5
import org.scalatest._
import chisel3._
import chiseltest._

class mux_bundletest extends FreeSpec with ChiselScalatestTester{
    "Muxparameter" in {
        test(new mux_bundle(SInt(5.W))){c=>
        c.io.input_1.poke(4.S)
        c.io.input_2.poke(2.S)
        c.io.select_1.poke(1.B)
        c.clock.step(1)
        c.io.out_put.expect(2.S)
         
           
        }
    }   
}