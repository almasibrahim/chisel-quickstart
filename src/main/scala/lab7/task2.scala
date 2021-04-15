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
    val s0 :: s1 :: Nil = Enum(2)
    val state = RegInit(s0)
    val register = RegInit(0.U(8.W))
    io.out:=0.U
    io.flag:=0.U
    switch (state){
        is (s0){
            when (io.start===1.U){
		when(io.in === 1.U){
		        register:= register << 1.U | io.in
		        io.out:=register
			io.flag:=1.U

		}.otherwise{
		        register:= register << 1.U
		        io.out := register
			io.flag:=1.U
		}
	    }
        }
        is (s1){
            io.out:=register
            io.flag:=0.U
        }
    }
}
