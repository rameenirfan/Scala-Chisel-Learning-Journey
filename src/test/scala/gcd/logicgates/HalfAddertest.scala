package practice

import org.scalatest._
import chiseltest._
import chisel3._

class HalfAddertest extends FreeSpec with ChiselScalatestTester{
    "Half Adder Test for sum" in {
        test(new HalfAdder()){ c=>
        c.io.a.poke(32.U)
        c.io.b.poke(12.U)
        c.clock.step(1)
        // c.io.output.expect(4.U)
        }}

    

}