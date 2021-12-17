package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class InstMemorytest extends FreeSpec with ChiselScalatestTester{
    "instruction" in  {
        test (new InstMemory("/home/Scala-Chisel-Learning-Journey/src/main/scala/riscv/inst.txt")){c=>
        c.io.addr.poke(1.U)
        c.io.inst.expect(47186195.U)
        c.clock.step(50)
        }
    }
}