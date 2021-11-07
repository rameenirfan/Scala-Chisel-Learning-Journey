package lab8
import org.scalatest._
import chiseltest._
import chisel3._

class Forwardingtest extends FreeSpec with ChiselScalatestTester{
    "Forwarding task" in  {
        test (new Forwarding){c=>
        // c.io.enable.poke(1.B)
        c.io.write.poke(1.B)
        c.io.Radd.poke(101.U)
        c.io.Wadd.poke(101.U)

       
        c.io.dataIn.poke(554.U)

        c.clock.step(50)
        }
    }}