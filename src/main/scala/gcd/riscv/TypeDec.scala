package riscv
import chisel3._
import chisel3.util._
import chisel3.core

class TypeDec extends Module {
	val  io = IO(new Bundle {
		val opcode = Input(UInt(7.W))
		val R = Output(UInt(1.W))
		val Load = Output(UInt(1.W))
		val Store = Output(UInt(1.W))
		val Branch = Output(UInt(1.W))
		val I = Output(UInt(1.W))
		val Jalr = Output(UInt(1.W))
		val Jal = Output(UInt(1.W))
		val Lui = Output(UInt(1.W))
		val Auipc = Output(UInt(1.W))
	})
	
	io.R := 0.U
	io.Load := 0.U
	io.Store := 0.U
	io.Branch := 0.U
	io.I := 0.U
	io.Jalr := 0.U
	io.Jal := 0.U
	io.Lui := 0.U
	io.Auipc := 0.U

	when(io.opcode === "b0010011".U){
		io.I := 1.U	
    }.elsewhen(io.opcode === "b0110011".U){
		io.R := 1.U
	}.elsewhen(io.opcode === "b0000011".U){
		io.Load := 1.U
	}.elsewhen(io.opcode === "b0100011".U){
		io.Store := 1.U
	}.elsewhen(io.opcode === "b1100011".U){
		io.Branch := 1.U
	}.elsewhen(io.opcode === "b1100111".U){
		io.Jalr := 1.U
	}.elsewhen(io.opcode === "b1101111".U){
		io.Jal := 1.U
	}.elsewhen(io.opcode === "b0110111".U){
		io.Lui := 1.U
	}.elsewhen(io.opcode === "b00010111".U){
		io.Auipc := 1.U
	}
		
}