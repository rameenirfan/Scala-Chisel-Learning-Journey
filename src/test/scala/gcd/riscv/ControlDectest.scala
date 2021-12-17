package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class ControlDectest extends FreeSpec with ChiselScalatestTester{
    "Control Decoder"  in {
     test (new ControlDec()){ c =>
        c.io.Load.poke(1.U)
        c.io.Store.poke(1.U)         
        c.clock.step(10)
        }
    }
}