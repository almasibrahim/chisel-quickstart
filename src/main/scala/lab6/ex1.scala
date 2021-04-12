package lab6

import chisel3 . _
import chisel3.util._

class shift_register extends Module {
	val io = IO ( new Bundle {
		val in = Input ( UInt (4.W)  )
		val out = Output ( Bool())
	})
	val state = RegInit ( 0.U (4.W) )
	val load = RegInit ( 0.U(4.W) )
	

	io.out:=0.U
	when (load===0.U){
		state:=io.in
		load:=load+1.U
	}.otherwise{
		state := state >> 1 
		io . out := state(0)
	}
}
