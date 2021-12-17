package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class TypeDectest extends FreeSpec with ChiselScalatestTester{
    "type Decoder"  in {
     test (new TypeDec()){ c =>
        c.io.opcode.poke("b0110011".U)
        c.io.R.expect(1.U)       
        c.clock.step(100)
        }
    }
}