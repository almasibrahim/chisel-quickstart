package lab8
import chisel3._
import chisel3.util._

class ex2_IO (width : Int = 16) extends Bundle {
    val enable = Input ( Bool () )
    val write = Input ( Bool () )
    val addr = Input ( UInt (10.W))
    val mask = Input ( Vec (2 , Bool()))
    val dataIn = Input ( Vec (2 , UInt (width.W)))
    val dataOut = Output ( Vec (2 , UInt ( width.W)))
    //val rdAddr = Input ( UInt (10. W ) )
    //val wrAddr = Input ( UInt (10. W ) )
}

class ex2(width : Int = 16) extends Module {
    val io = IO ( new ex2_IO (width))
    val mem = SyncReadMem (1024,Vec (2,UInt (width.W)))
    val wrDataReg = RegNext (io.dataIn)
    //val wrDataReg1 = RegNext (io.dataIn(1))
    val doForwardReg = RegNext ( io.write===1.B && io.enable===1.B )
    val memread =mem.read(io.addr,io.enable)
    
    when(io.write){
    	mem.write ( io.addr , io.dataIn , io.mask )
    }
   
    io.dataOut := Mux ( doForwardReg , wrDataReg ,memread )
   // io.dataOut(1) := Mux ( doForwardReg , wrDataReg1 ,memread )
    
}

