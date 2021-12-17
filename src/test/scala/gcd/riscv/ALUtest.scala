package riscv
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random
import ALUOP._

class ALUtest extends FreeSpec with ChiselScalatestTester {
    "ALU apnawala Test" in {
        test(new ALU){c =>
// ALU operations
            val array_op = Array ( ALU_ADD, ALU_SLL,ALU_SLT , ALU_XOR ,ALU_SRL , ALU_OR ,ALU_AND ,ALU_SUB)

            for ( i <- 0 until 100) {
                println (i)
                val src_a = Random . nextLong () & 0xFFFFFFFFL
                val src_b = Random . nextLong () & 0xFFFFFFFFL
                val opr = Random . nextInt (8)
                val aluop = array_op ( opr )
                val result = aluop match {
                    case ALU_ADD => src_a + src_b
                    case ALU_SLL => src_a << ( src_b & 0x1F )
                    case ALU_SLT => 0 //
                    case ALU_XOR => src_a ^ src_b
                    case ALU_SRL => src_a >> ( src_b & 0x1F )
                    case ALU_OR => src_a | src_b
                    case ALU_AND => src_a & src_b
                    case ALU_SUB => src_a - src_b 
                    case _ => 0
                }

                val result1 : BigInt = if ( result < 0)
                    ( BigInt (0xFFFFFFFFL ) + result +1) & 0xFFFFFFFFL
                else (result & 0xFFFFFFFFL)


                c . io . in_1 . poke ( src_a . U )
                c . io . in_2 . poke ( src_b . U )
                c . io . select . poke ( aluop )
                c . clock . step (100)
                // c . io . output . expect ( result1 . U )
            }
            // c . clock . step (200)
        }
}
}