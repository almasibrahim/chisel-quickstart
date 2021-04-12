package lab6
import chisel3._
import chisel3.util._

class MyQueue extends Module {
	val io = IO ( new Bundle {
	val in = Flipped ( Decoupled ( UInt (8.W) ) ) // valid = Input , ready =Output , bits = Input
	val out = Decoupled ( UInt (8.W) )
	// valid = Output , ready =Input , bits = Output
	})
	io.out.valid:=0.U
	io.out.bits:=0.U
	val queue = Queue ( io.in , 5)
	val queue1 = Queue (queue , 5)
	// 5 - element queue
	queue.nodeq()
	queue1.nodeq()
	when(queue1.valid===true.B && io.out.ready===true.B){
		io.out.enq(queue1.deq())
	}
	
}
