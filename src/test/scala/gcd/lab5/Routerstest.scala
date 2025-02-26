package lab5
import org.scalatest._
import chisel3._
import chiseltest._

class Routertest extends FreeSpec with ChiselScalatestTester{
    "Router test" in {
        test(new Router(5.U)){c=>

        c.io.in.databits.poke(2.U)
        c.io.in.addressbits.poke(3.U)
        c.clock.step(1)
        c.io.out.databits.expect(2.U)
        c.io.out.addressbits.expect(3.U)
        
      

        }
    }
}                  