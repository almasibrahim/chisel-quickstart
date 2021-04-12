package lab5

import chisel3._
import chisel3 . util._
import org.scalatest._
import chiseltest._

class ALUTests extends FreeSpec with ChiselScalatestTester {

  "ALU" in {
    test(new ALU(32)) { c =>
      c.io.arg_x.poke(20.U)
      c.io.arg_y.poke(30.U)
      c.io.alu_oper.poke(2.U)
      c.io.alu_out.expect(50.U)
      println(log2Ceil(32))
    }
  }
}
