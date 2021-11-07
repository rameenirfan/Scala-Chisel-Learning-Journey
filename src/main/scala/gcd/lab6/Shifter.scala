package lab6
import chisel3 . _
class Shifter (val init : Int = 1) extends Module{
    val io = IO(new Bundle{
        val input = Input(Vec(4 , UInt(4.W)))
        val output = Output(Vec(4 , UInt(4.W)))
    })
    val state = RegInit ( init . U (4. W ) )
    val state1 = RegInit ( init . U (4. W ) )
    val state2 = RegInit ( init . U (4. W ) )
    val state3 = RegInit ( init . U (4. W ) )
    val nextState = ( state << 1) | io.input(0)
    val nextState1 = ( state << 1) | io . input(1)
    val nextState2 = ( state << 1) | io . input(2)
    val nextState3 = ( state << 1) | io . input(3)
    state := nextState
    state1 := nextState1
    state2 := nextState2
    state3 := nextState3
    io.output(0) := state
    io.output(1) := state1
    io.output(2) := state2
    io.output(3) := state3
}