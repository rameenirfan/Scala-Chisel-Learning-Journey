package lab7
import org.scalatest._
import chiseltest._
import chisel3._
class State_Machinetest extends FreeSpec with ChiselScalatestTester{
    "lab7 state machine" in  {
        test (new State_Machine){c=>
        c.io.f1.poke(1.B)
        c.io.f2.poke(0.B)
        c.io.r1.poke(0.B)
        c.io.r2.poke(0.B)


        c.clock.step(200)}}}