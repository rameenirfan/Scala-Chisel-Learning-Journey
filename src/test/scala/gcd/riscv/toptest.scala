package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class toptest extends FreeSpec with ChiselScalatestTester{
    "TopFile"  in {
     test (new top()){ c =>
 
        c.clock.step(10)

        }
    }
}
