package lab7
import org.scalatest._
import chiseltest._
import chisel3._
class ManchesterEncodingtest extends FreeSpec with ChiselScalatestTester{
    "manchester wave" in  {
        test (new ManchesterEncoding){c=>
        c.io.in.poke(1.U)
        c.io.start.poke(1.B)
         c.clock.step(4)
        c.io.in.poke(0.U)
        c.io.start.poke(1.B)
         c.clock.step(5)
        // c.io.in.poke(0.B)

        
        // c.io.out.expect(0.B)
        c.clock.step(200)}}}