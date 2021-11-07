// package lab5
// import org.scalatest._
// import chisel3._
// import chiseltest._

// class emuxtest extends FreeSpec with ChiselScalatestTester{
//     "EMux" in {
//         test(new emux(SInt(7.W))){c=>
//         c.io.input.poke(4.S)
//         c.io.input2.poke(2.S)
//         c.io.select.poke(1.B)
//         c.clock.step(1)
//         c.io.output.expect(2.U)
         
           
//         }
//     }   
// }