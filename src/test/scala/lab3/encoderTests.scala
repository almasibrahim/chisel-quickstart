package lab3

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class Encoder4to2Tests extends FreeSpec with ChiselScalatestTester {

  "encoder" in {
    test(new Encoder4to2).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in.poke("b0101".U)
      c.clock.step(10)
      c.io.out.expect("b10".U)
    }
 
    }
  }
