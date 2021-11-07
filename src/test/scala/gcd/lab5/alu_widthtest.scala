package lab5
import org.scalatest._
import chisel3._
import chiseltest._

class alu_widthtest extends FreeSpec with ChiselScalatestTester{
    "ALU(parameterized) TEST" in {
        test(new alu_width(10:Int)){c=>
        c.io.arg_x.poke(8.U)
        c.io.arg_y.poke(1.U)
        c.io.alu_op.poke("b0010".U)
        c.clock.step(1)
        c.io.alu_out.expect(9.U)
        }
    }
}