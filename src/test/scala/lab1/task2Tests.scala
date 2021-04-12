package lab1

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task2Tests extends FreeSpec with ChiselScalatestTester {

  "Task 2" in {
    test(new task2(8)).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      	c.io.data_in.poke(4.U)
	c.io.reload.poke(0.B)
	c.clock.step(20)
    
    }
  }
}
