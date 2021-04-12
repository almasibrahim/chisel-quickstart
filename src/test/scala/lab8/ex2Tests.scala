package lab8

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class ex2Tests extends FreeSpec with ChiselScalatestTester {

  "Lab 8 Ex 2" in {
  test(new ex2).withAnnotations(Seq(VerilatorBackendAnnotation)) { c =>
      c.io.enable.poke(1.B)
      c.io.write.poke(1.B)
      c.io.addr.poke(5.U)
      //c.io.mask(0).poke(1.B)
      c.io.mask(1).poke(1.B)
      //c.io.dataIn(0).poke(2.U)
      c.io.dataIn(1).poke(8.U)
      c.clock.step(20)
      // c.io.out.expect(0.B)
    }
  }
}
