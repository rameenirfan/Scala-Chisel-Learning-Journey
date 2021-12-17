package riscv
import chisel3._
import chisel3.util._
import chisel3.core

class Regfile extends Module {
	val  io = IO(new Bundle {
		
		val rs1_inp = Input(UInt(5.W))
		val rs2_inp = Input(UInt(5.W))
		val rd = Input(UInt(5.W))
		val write_data = Input(SInt(32.W))
		val reg_write = Input(UInt(1.W))

		val rs1_out= Output(SInt(32.W))
		val rs2_out= Output(SInt(32.W))
})

	val reg = Reg(Vec(32,SInt(32.W)))
	reg(0) := 0.S
	
	io.rs1_out := reg(io.rs1_inp)
	io.rs2_out := reg(io.rs2_inp)


	when (io.reg_write ===1.U){
		when(io.rd==="b00000".U){
			reg(io.rd):=0.S
		}.otherwise{
			reg(io.rd) := io.write_data
		}
	}
	
}


