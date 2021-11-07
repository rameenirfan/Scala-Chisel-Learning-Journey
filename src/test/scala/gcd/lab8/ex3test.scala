package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class memorytest extends FreeSpec with ChiselScalatestTester{
    "instruction" in  {
        test (new InstMem("/home/rameen/Scala-Chisel-Learning-Journey/src/main/scala/lab8/instruction.txt")){c=>
        c.io.addr.poke(1.U)
        c.io.inst.expect(47186195.U)
        c.clock.step(50)
        }
    }
}