package lab8
import chisel3 . _
import chisel3 .util. _
class Forwarding extends Module {
    val width : Int = 32
    val io = IO ( new Bundle {
        val write = Input ( Bool () )
        val Radd = Input ( UInt (10. W ) )
        val Wadd = Input ( UInt (10. W ) )
        val dataIn = Input (UInt ( width . W )) 
        val dataOut = Output (UInt ( width . W )) 
    })
    val memory = SyncReadMem (32 , UInt ( width . W ) )
    val wrDataReg = RegNext ( io .dataIn)
    val doForwardReg = RegNext ( io.Radd === io .Wadd && io .write )
    val memData = memory . read ( io . Radd )
    when ( io .write)
    {
    memory . write ( io . Wadd , io .dataIn)
    }
    io .dataOut := Mux ( doForwardReg , wrDataReg , memData )

}