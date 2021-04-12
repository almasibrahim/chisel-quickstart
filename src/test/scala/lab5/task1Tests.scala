package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class AdderTests extends FreeSpec with ChiselScalatestTester {

  "Adder" in {
    test(new Adder(4)) { c =>
      c.io.in0.poke(6.U)
      c.io.in1.poke(6.U)
      c.io.sum.expect(12.U)
    }
  }
}
