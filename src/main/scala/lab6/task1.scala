package lab6
import chisel3._
import chisel3.util._

class counter_with_xor (max:Int) extends Module {
	val io = IO ( new Bundle {
	val out = Output ( UInt(4.W))
})

	val counter = RegInit (0.U (4.W))
	when(counter(3) ^ 0.B){
		counter:=0.U
		io.out:=counter
	}.otherwise{
		counter:=counter+1.U
		io.out:=counter
	}
	 
}
