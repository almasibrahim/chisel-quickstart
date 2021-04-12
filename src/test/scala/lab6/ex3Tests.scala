package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class timerTests extends FreeSpec with ChiselScalatestTester {

  "timer" in {
    test(new timer(8)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in.poke(12.U)
      c.clock.step(30)
      //c.io.out.expect("b10".U)
    }
 
    }
  }


