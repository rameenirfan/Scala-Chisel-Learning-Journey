package practice

import org.scalatest._
import chiseltest._
import chisel3._

class NORtest extends FreeSpec with ChiselScalatestTester{
    "NOR  Test" in {
        test(new NOR()){ c=>
        c.io.a.poke(1.U)
        c.io.b.poke(0.U)
        c.clock.step(1)
        c.io.output.expect(0.U)
        }}
}