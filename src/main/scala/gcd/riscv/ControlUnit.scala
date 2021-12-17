package riscv
import chisel3._
import chisel3.util._


class ControlUnit extends Module{
	val io = IO(new Bundle{
		val Opcode = Input(UInt(7.W))


		val Branch = Output(UInt(1.W))
		val RegWrite = Output(UInt(1.W))
		val immediate = Output(UInt(1.W))
		val Load = Output(UInt(1.W))
		val store = Output(UInt(1.W))
		val U_type = Output(UInt(1.W))
		val Auipc = Output(UInt(1.W))
		val jalr = Output(UInt(1.W))
		val jal = Output(UInt(1.W))
	})
    


    val tdeco = Module (new TypeDec())
    val cdec = Module (new ControlDec())
    
    tdeco.io.opcode := io.Opcode


    cdec.io.R := tdeco.io.R
    cdec.io.Load := tdeco.io.Load
    cdec.io.Store := tdeco.io.Store
    cdec.io.SB := tdeco.io.Branch
    cdec.io.I := tdeco.io.I
    cdec.io.Jalr := tdeco.io.Jalr
    cdec.io.Jal := tdeco.io.Jal
    cdec.io.Lui := tdeco.io.Lui
    cdec.io.Auipc := tdeco.io.Auipc


    io.Branch := cdec.io.branch
    io.RegWrite :=cdec.io.RegWrite
    io.immediate := cdec.io.immediate
    io.Load := cdec.io.Load
    io.store := cdec.io.Store
    io.U_type := cdec.io.lui
    io.Auipc := cdec.io.Auipc
    io.jalr :=cdec.io.jalr
    io.jal :=cdec.io.jal
}
