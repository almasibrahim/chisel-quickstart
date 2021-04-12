package lab5
import chisel3._
import chisel3.util._

class Dpackets[T<:Data](gen:T) extends Bundle{
    val address = UInt(10.W)
    val data= gen
    override def cloneType = (new Dpackets(gen)).asInstanceOf[this.type]
}

class Router[T<:Data](gen:T, gen1:T) extends Module{
    val io = IO(new Bundle{
        val in = Input(new Dpackets(gen))
        val out = Output(new Dpackets(gen1))
    })
    io.out <> io.in
}
