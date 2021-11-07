package practice

import org.scalatest._
import chiseltest._
import chisel3._

class FullAddertest extends FreeSpec with ChiselScalatestTester{
    "Full Adder Test for sum" in {
        test(new FullAdder()){ c=>
        c.io.a.poke(32.U)
        c.io.b.poke(12.U)
        c.clock.step(1)
        c.io.output.expect(44.U)
        }}

}