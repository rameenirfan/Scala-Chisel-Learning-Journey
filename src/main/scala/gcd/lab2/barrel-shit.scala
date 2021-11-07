package lab2
import chisel3 . _
import chisel3 . util . _
class barrel_shift extends Module {
    val io = IO ( new Bundle {
    val in = Vec (4 , Input ( Bool () ) )
    val sel = Vec (2 , Input ( Bool () ) )
    val shift_type = Input ( Bool () )
    val out = Vec (4 , Output ( Bool () ) )
})
    val input1 = Mux(io.shift_type,io.in(0),0.U)
    val input2 = Mux(io.shift_type,io.in(1),0.U)
    val input3 = Mux(io.shift_type,io.in(2),0.U)

    io.out(0):=Mux(io.sel(1),Mux(io.sel(0),io.in(0),io.in(1)),Mux(io.sel(0),io.in(2),io.in(3))) 
    io.out(1):=Mux(io.sel(1),Mux(io.sel(0),io.in(1),io.in(2)),Mux(io.sel(0),io.in(3),input1))
    io.out(2):=Mux(io.sel(1),Mux(io.sel(0),io.in(2),io.in(3)),Mux(io.sel(0),input2,input1))
    io.out(3):=Mux(io.sel(1),Mux(io.sel(0),io.in(3),input1),Mux(io.sel(0),input2,input3))

}