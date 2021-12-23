package riscv
import chisel3._
import chisel3.util._
//import chisel3.util.Fill
import chisel3.util.experimental.loadMemoryFromFile


class InstMemory extends Module{
	val io = IO(new Bundle{

		val addr = Input(UInt(10.W)) 
		val inst = Output(UInt(32.W))

})
		val mem =Mem(1024,UInt(32.W))

		io.inst:= mem(io.addr)
		loadMemoryFromFile(mem,"/home/rameen/Documents/doc.txt")
	
}
