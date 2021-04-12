package lab3

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Decoder2to4Tests extends FreeSpec with ChiselScalatestTester {

  "decoder" in {
    test(new Decoder2to4).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in.poke("b11".U)
      c.clock.step(10)
      c.io.out.bits.expect("b1000".U)
      c.io.out.valid.expect(1.B)
    }
 
    }
  }
