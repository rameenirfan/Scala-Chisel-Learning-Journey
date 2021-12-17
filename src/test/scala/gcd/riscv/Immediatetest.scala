package riscv
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import scala.util.Random

class Immediatetest extends FreeSpec with ChiselScalatestTester {
    "Imm  Test" in {
        test(new Immediate){c =>

            //val array_op = Array (53478035,5251619,239)
            val array_op = Array(69271699,318575159,12583151)
            for ( i <- 0 until 3) {
                println (i)
                val opr = Random.nextInt(2)
                val src_ins = array_op(opr)
                val result = src_ins match {
                    case 69271699 => 66
                    case 318575159 => 77777
                    case 12583151 =>12
                    // case 53478035 => 51
                    // case 5251619=> 4
                    // case 239 => 0 
                    case _=> 0
                }

                c.io.ins.poke(src_ins.U)
                c.io.pc.poke(0.U)
                c.clock.step(1)
                c.io.out.expect(result.S )
            }
            // c . clock . step (200)
        }
}
}