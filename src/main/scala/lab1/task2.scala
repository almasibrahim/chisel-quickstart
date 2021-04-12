package lab1

import chisel3._
import chisel3.util._
import java.io.File

class task2 ( n : Int ) extends Module {
    val io = IO ( new Bundle {
        val data_in = Input ( UInt ( n . W ) )
        val reload = Input ( Bool () )
        val out = Output ( Bool () )
    })
    val counter = RegInit (0. U ( n . W ) )
    val max_count = RegInit (6. U ( n . W ) )
    val flag = RegInit (0. U ( n . W ) )
    // Your code
    when (io.reload === 1.B){counter := 0.U}
    .otherwise{
	when(counter === max_count){
		counter:=counter - 1.U
		flag:=1.U
	}.elsewhen(counter===0.U){
		flag:=0.U
		counter:=counter + 1.U
	}.elsewhen(flag===1.U){counter:=counter - 1.U}

	.otherwise{
		flag:=0.U
		counter:=counter + 1.U
		
	}
     }

    io.out := Mux( counter === 0.U || counter === max_count, 1.B, 0.B)

}
