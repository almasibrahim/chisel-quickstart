package lab6

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class counter_with_xorTests extends FreeSpec with ChiselScalatestTester {

  "counter_with_xor" in {
    test(new counter_with_xor(4)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      //c.io.in.valid.poke(1.B)
      //c.io.in.bits.poke(12.U)
      c.clock.step(30)
      //c.io.out.expect("b10".U)
    }
 
    }
  }


