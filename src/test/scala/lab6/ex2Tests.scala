package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class counterTests extends FreeSpec with ChiselScalatestTester {

  "counter" in {
    test(new counter(4)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      //c.io.in.poke(1.B)
      c.clock.step(20)
      //c.io.out.expect("b10".U)
    }
 
    }
  }
