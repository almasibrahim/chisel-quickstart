package lab6
import chisel3._
import chisel3.util._

class timer ( val max : Int ) extends Module {
    val io = IO ( new Bundle {
    val in = Input (UInt(4.W))
    val clock_High = Output (Bool())
    })
  
    val timer = RegInit (max.U (4.W))
    val re = RegInit (max.U (4.W))
    io.clock_High:=0.B
    //re:=0.U
    when(timer===0.U && re===0.U){
		io.clock_High:=1.B
		
    }.otherwise{
		io.clock_High:=0.B
		timer:=timer-1.U
		re:=re-1.U
    }
}
