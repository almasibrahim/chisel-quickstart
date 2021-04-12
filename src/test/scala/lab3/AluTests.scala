package lab3

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class AluTests extends FreeSpec with ChiselScalatestTester {

  "Alu" in {
    test(new Alu("b10001".U)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.io.in1.poke(3.S)
      c.io.in2.poke(4.S)
      c.clock.step(10)
      c.io.out.expect(1.S)
    }
 
    }
  }
