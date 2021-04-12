package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex1Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 ex 1" in {
  test(new ex1).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.dataIn(0).poke(5.U)
      c.io.dataIn(1).poke(4.U)
      c.io.enable.poke(1.B)
      c.io.write.poke(1.B)
      c.io.addr.poke(5.U)
      c.io.mask(0).poke(1.B)
      c.io.mask(1).poke(1.B)
      c.clock.step(10)
      // c.io.out.expect(0.B)
    }
  }
}
