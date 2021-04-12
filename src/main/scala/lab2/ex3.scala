package lab2

import chisel3._
import chisel3.util._

class ex3 extends Module{
    val io = IO(new Bundle {

    val sel = Input(UInt(4.W))
    val out1 = Output(UInt(2.W))
    })

    io.out1 := Mux1H(io.sel, Seq(0.U, 1.U, 2.U, 3.U))

}




