package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class MaskedReadWriteSmemtest extends FreeSpec with ChiselScalatestTester{
    "exercise 1" in  {
        test (new MaskedReadWriteSmem){c=>
        c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.addr.poke(10.U)
        c.io.mask.poke(0.U)
       
        c.io.dataIn.poke(100.U)

        c.clock.step(100)
        }
    }
}