package riscv
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class main_memtest extends FreeSpec with ChiselScalatestTester{
    "mm"  in {
     test (new DataMem()){ c =>
        c.io.datastore.poke(45.S)
        c.io.addr.poke(10.U)
        c.io.load.poke(1.U) 
        c.io.store.poke(1.U)
        // c.io.data_Out.expect(45.S)       
        c.clock.step(100)
        }
    }
}