package riscv
import chisel3._
import chisel3.util._
import chisel3.core
import chisel3.util.experimental.loadMemoryFromFile

class DataMem extends Module{
	val io = IO(new Bundle{
		val load = Input(UInt(1.W))
		val store = Input(UInt(1.W))
		val addr = Input(UInt(8.W)) 
		val datastore = Input(SInt(32.W))
		val data_Out = Output(SInt(32.W))

})
		val memory = Mem(1024,SInt(32.W))
		
		when(io.load === 1.U){
			io.data_Out := memory(io.addr)
		}.otherwise{
			io.data_Out := DontCare
		}
		when(io.store === 1.U){
			memory(io.addr) := io.datastore
		}.otherwise{
			io.data_Out := DontCare
		}
		
}