package lab1

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 2" in {
    test(new ex2(4.U)).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
      c.clock.step(10)}
 
    }
  }
