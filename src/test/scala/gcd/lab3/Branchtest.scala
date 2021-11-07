package lab3
import org.scalatest._
import chisel3._
import chiseltest._

class Branchtest extends FreeSpec with ChiselScalatestTester{
    "Branch " in {
        test(new Branch()){c=>
        c.io.input_a.poke(1.S)
        c.io.input_b.poke(2.S)
        c.io.fuc.poke("b101".U)
        c.io.op.poke(1.B)
        c.clock.step(1)
        c.io.output.expect(1.B)
        }
    }
}