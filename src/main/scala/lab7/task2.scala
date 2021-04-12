package lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class task2 extends Module {
    val io = IO (new Bundle {
        val in = Input ( UInt (1. W ) )
        val start = Input ( Bool () )
        val out = Output ( UInt (8. W ) )
        val flag = Output ( UInt (1. W ) )
    })

    val register = RegInit(0.U(8.W))
    io.out:=0.U
    io.flag:=0.U
    switch (io.start){
        is (1.B){
            when (io.in === 1.U){
                register:= register << 1.U | io.in
                io.out:=register
		io.flag:=1.U

            }.otherwise{
                register:= register << 1.U
                io.out := register
		io.flag:=1.U
            }
        }
        is (0.B){
            io.out:=register
            io.flag:=0.U
        }
    }
}
