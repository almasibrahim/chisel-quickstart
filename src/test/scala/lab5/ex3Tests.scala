package lab5

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class OperatorTests extends FreeSpec with ChiselScalatestTester {

  "Operator" in {
    test(new Operator(2,UInt(16.W))(_+_)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
     c.io.in1(0).poke(1.U)
     c.io.in1(1).poke(2.U)
     c.io.in2(0).poke(3.U)
     c.io.in2(1).poke(4.U)
     c.clock.step(10)
     c.io.out(0).expect(3.U)
     c.io.out(1).expect(7.U)
    }
 
    }
  }
