package lab3
import chisel3._
import chisel3.util._

object ALUOP {
    val ALU_ADD = 0.U(4.W)
    val ALU_SUB = 1.U(4.W)
    val ALU_AND = 2.U(4.W)
    val ALU_OR  = 3.U(4.W)
    val ALU_XOR = 4.U(4.W)
    val ALU_SLT = 5.U(4.W)
    val ALU_SLL = 6.U(4.W)
    val ALU_SLTU= 7.U(4.W)
    val ALU_SRL = 8.U(4.W)
    val ALU_SRA = 9.U(4.W)
    val ALU_COPY_A = 10.U(4.W)
    val ALU_COPY_B = 11.U(4.W)
    val ALU_XXX = 12.U(4.W) 
}