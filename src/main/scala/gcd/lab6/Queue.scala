package lab6
import chisel3 . _
import chisel3 . util . _
// import chisel3 . iotesters .{ ChiselFlatSpec , Driver , PeekPokeTester }
class My_Queue extends Module {
    val io = IO ( new Bundle {
        val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , ready =Output , bits = Input

        val out = Decoupled ( UInt (8. W ) ) // valid = Output , ready =Input , bits = Output
})  
    val queue = Queue ( io . in , 5)
    val queue1 = Queue(queue,5)

    io.out.valid(1.B)

    queue.nodeq()
    queue1.nodeq()
    when ((queue1.valid && io.out.ready)===1.B) {
        io.out.enq(queue1.deq())
     
    }
// 5 - element queue
io.out<>queue1
}