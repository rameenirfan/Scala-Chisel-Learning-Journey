package riscv
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random
import BALUOP._

class Branchtest extends FreeSpec with ChiselScalatestTester {
    "ALUTest" in {
        test ( new Branch ) { c =>
        // ALU operations
            val array_op = Array ( ALU_BEQ,ALU_BNE,ALU_BGE,ALU_BLT )
            for ( i <- 0 until 100) {
                // println(s"i=>$i")
                val src_a = Random.nextLong()&0xFFFFFFFFL
                val src_b = Random.nextLong()&0xFFFFFFFFL
                val opr = Random.nextInt(4)
                val aluop = array_op ( opr )
                //println(s"aluop=>$aluop")
                // println(s"srcA=>$src_a*")
                
                // println(s"srcB=>$src_b")
                val result:Int = aluop match {
                    case ALU_BEQ => if(src_a.toInt == src_b.toInt) 1 else 0
                    
                    case ALU_BNE =>if(src_a.toInt != src_b.toInt) 1 else 0
                    case ALU_BGE => if(src_a.toInt >= src_b.toInt) 1 else  0
                    case ALU_BLT => if(src_a.toInt < src_b.toInt) 1 else  0
                    // case _=> 0
                }
            
            
                    println(s"aluop=>$result")
                    c.io.in_1.poke(src_a.S)
                    c.io.in_2.poke(src_b.S)
                    c.io.select.poke(aluop)
                    c . clock . step (1)
                    c . io . output.expect (result.B)
                }
            
            c . clock . step (200)}
        }
    }