package lab5
import chisel3 . _
import chisel3 . util . _

// class definition with function as parameter
class Operator [T <: Data](n: Int,generic:T)(op:(T,T)=>T) extends Module {
		require (n > 0) // " reduce only works on non - empty Vecs "
		val io = IO ( new Bundle {
			val in1 = Input (Vec (n , generic))
			val in2 = Input (Vec (n , generic))	
			val out = Output (Vec (2 , generic))
		})
		
		io . out (0):= io.in1. reduce ( op )
		io . out (1):= io.in2. reduce ( op )
}


