package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Regfiletest extends FreeSpec with ChiselScalatestTester{
    "Register File"  in {
     test (new Regfile()){c =>
    c.io.rs1_inp.poke(1.U)
	c.io.rs2_inp.poke(3.U)
	c.io.rd.poke(3.U)
    c.io.write_data.poke(58.S)
    c.io.reg_write.poke(1.U)

    c.clock.step(20)
    c.io.rs1_out.expect(0.S)
	c.io.rs2_out.expect(58.S)
        }
    }
}