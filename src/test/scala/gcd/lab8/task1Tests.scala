package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class task1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 task 1" in {
  test(new task1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.requestor(0).bits.poke("b0001".U)
      c.io.requestor(1).bits.poke("b0010".U)
      c.io.requestor(2).bits.poke("b0011".U)
      c.io.requestor(3).bits.poke("b0100".U)
      c.io.requestor(0).valid.poke(0.B)
      c.io.requestor(1).valid.poke(1.B)
      c.io.requestor(2).valid.poke(0.B)
      c.io.requestor(3).valid.poke(0.B)
      c.io.Readaddr.poke(4.U)
      c.io.Writeaddr.poke(4.U)
      c.clock.step(10)
      
      // c.io.out.expect(0.B)
    }
  }
}
