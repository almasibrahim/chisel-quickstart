package lab2

import org.scalatest._
import chiseltest._
import chisel3._

class ex3Tests extends FreeSpec with ChiselScalatestTester {

  "Exercise 3 Lab 2" in {
    test(new ex3()) { c =>
      c.io.sel.poke(4.U)
      c.clock.step(1)
      c.io.out1.expect(2.U)
    }
    
  }
}
