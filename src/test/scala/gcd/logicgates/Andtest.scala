package practice

import org.scalatest._
import chiseltest._
import chisel3._

class Andtest extends FreeSpec with ChiselScalatestTester{
    "And Gate Test" in {
        test(new And()){ c=>
        c.io.a.poke(0.U)
        c.io.b.poke(0.U)
        c.clock.step(1)
        c.io.output.expect(0.U)
        }}
}