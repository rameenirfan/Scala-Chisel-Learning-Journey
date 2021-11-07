package practice

import org.scalatest._
import chiseltest._
import chisel3._

class XNORtest extends FreeSpec with ChiselScalatestTester{
    "XNOR Test" in {
        test(new XNOR()){ c=>
        c.io.a.poke(0.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.output.expect(0.U)
        }}
}