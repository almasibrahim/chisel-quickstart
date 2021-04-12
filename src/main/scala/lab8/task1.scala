package lab8

import chisel3._
import chisel3.util._

class task1 extends Module{
    val io = IO(new task1_IO)
    val q1 = Queue(io.requestor(0))
    val q2 = Queue(io.requestor(1))
    val q3 = Queue(io.requestor(2))
    val q4 = Queue(io.requestor(3))

    val arbiter = Module(new Arbiter(UInt(),4))
    arbiter.io.in(0) <> q1
    arbiter.io.in(1) <> q2
    arbiter.io.in(2) <> q3
    arbiter.io.in(3) <> q4

    //io.out<>arbiter.io.out
    val mem = SyncReadMem (1024,Vec (4,UInt (16.W)))
    arbiter.io.out.ready:=1.B
    val a=Reg(Vec(4,UInt()))
    when(io.requestor(0).valid===1.B){
		a(0):=arbiter.io.out.bits
		a(1):=0.U
		a(2):=0.U
		a(3):=0.U
		mem.write ( io.Writeaddr , a)
    }.elsewhen(io.requestor(1).valid===1.B){
		a(0):=0.U
		a(1):=arbiter.io.out.bits
		a(2):=0.U
		a(3):=0.U
		mem.write ( io.Writeaddr , a)
    }.elsewhen(io.requestor(2).valid===1.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=arbiter.io.out.bits
		a(3):=0.U
		mem.write ( io.Writeaddr , a)
    }.elsewhen(io.requestor(3).valid===1.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=0.U
		a(3):=arbiter.io.out.bits
		mem.write ( io.Writeaddr , a)
    }.otherwise{
		a(0):=0.U
		a(1):=0.U
		a(2):=0.U
		a(3):=0.U
		mem.write ( io.Writeaddr , a)
    }
    
    io.memory_out:=mem.read(io.Readaddr)

}

class task1_IO extends Bundle{
    	val memory_out = Vec (4 , Output ( UInt (32. W ) ) )
	val requestor = Vec (4 , Flipped ( Decoupled ( UInt (32. W ) ) ) )
	val Readaddr = Input ( UInt (5. W ) )
	val Writeaddr = Input ( UInt (5. W ) )
        //val out = Decoupled(UInt(32.W))
}
