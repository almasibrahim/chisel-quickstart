package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class MyQueueTests extends FreeSpec with ChiselScalatestTester {

  "MyQueue" in {
    test(new MyQueue).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in.valid.poke(true.B)
      c.io.in.bits.poke(12.U)
      //c.clock.step(2)
      c.io.out.ready.poke(true.B)
      c.clock.step(2)
    }
 
    }
  }


