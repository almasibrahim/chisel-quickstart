package lab6
import chisel3._
import chisel3.util._

class Updown(max: Int ) extends Module {
    val io = IO ( new Bundle {
    val out = Output ( UInt ( max.W ) )
    val up_down = Input ( Bool () )
    })
    io.out:=0.U
    val count_up = RegInit(0.U(max.W))
    val count_down = RegInit(max.U(max.W))
    when(io.up_down === 1.B){
        count_up := count_up+1.U
        io.out:=count_up
    }.elsewhen(io.up_down === 0.B){
        count_down := count_down -1.U
        io.out:=count_down
    }

}
