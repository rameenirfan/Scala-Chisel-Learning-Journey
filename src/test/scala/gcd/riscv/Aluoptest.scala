package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class Aluoptest extends FreeSpec with ChiselScalatestTester{
    "Aluop"  in {
     test (new Aluop()){ c =>
        c.io.inst.poke(0.U)     
        c.io.branch.poke(1.B)    
        c.clock.step(10)
        // c.io.alu_out.expect(7.U)
        }
    }
}   