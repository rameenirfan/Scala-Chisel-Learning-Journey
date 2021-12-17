package riscv
import chisel3._
import chisel3.util._


class ControlDec extends Module{
	val io = IO(new Bundle{
		val I = Input(UInt(1.W))
		val R = Input(UInt(1.W))
		val SB = Input(UInt(1.W))
		val Load = Input(UInt(1.W))
		val Store = Input(UInt(1.W))
		val Jalr = Input(UInt(1.W))
		val Jal = Input(UInt(1.W))
		val Lui = Input(UInt(1.W))
		val Auipc = Input(UInt(1.W))

		val branch = Output(UInt(1.W))
		val RegWrite = Output(UInt(1.W))
		val immediate = Output(UInt(1.W))
		val load = Output(UInt(1.W))
		val store = Output(UInt(1.W))
		val lui = Output(UInt(1.W))
		val auipc = Output(UInt(1.W))
		val jalr = Output(UInt(1.W))
		val jal = Output(UInt(1.W))
	})
 

		
		
	
		io.branch := 0.U
        io.RegWrite := 0.U
        io.immediate :=0.U
		io.load := 0.U
        io.store := 0.U
        io.lui :=0.U
        io.auipc := 0.U
        io.jalr := 0.U
        io.jal := 0.U



        when(io.R === 1.U){
			io.RegWrite := 1.U
		}.elsewhen(io.Load === 1.U){
			
			io.RegWrite := 1.U
			io.immediate := 1.U
			io.load := 1.U
		}.elsewhen(io.Store === 1.U){
			io.load := 1.U
			io.store := 1.U

		}.elsewhen(io.SB === 1.U){
			io.branch := 1.U

		}.elsewhen(io.I === 1.U){
			io.RegWrite := 1.U
			io.immediate := 1.U
		
		}.elsewhen(io.Jalr === 1.U){
			io.jalr := 1.U

		}.elsewhen(io.Jal === 1.U){
			io.RegWrite := 1.U
			io.jal := 1.U
			
		}.elsewhen(io.Lui === 1.U){
			io.RegWrite := 1.U
			io.immediate:= 1.U
		}
        .elsewhen(io.Auipc === 1.U){
            io.RegWrite := 1.U
            io.auipc := 1.U
        }
}