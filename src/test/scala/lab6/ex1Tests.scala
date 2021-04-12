package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class shift_registerTests extends FreeSpec with ChiselScalatestTester {

  "shift_register" in {
    test(new shift_register).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in.poke(15.U)
      c.clock.step(10)
      //c.io.out.expect("b10".U)
    }
 
    }
  }
