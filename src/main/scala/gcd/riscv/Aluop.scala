package riscv
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class Aluop extends Module{
	val io = IO(new Bundle{
		val inst = Input(UInt(32.W))
        val branch = Input(Bool())
        val alu_out = Output(UInt(5.W))
})

     
    when (io.branch){
        io.alu_out := Cat(2.U,io.inst(14,12))
    }.otherwise{
        io.alu_out := Cat(0.U,io.inst(14,12),io.inst(30))
    }
    
}