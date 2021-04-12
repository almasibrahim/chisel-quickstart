package lab5

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class task3Tests extends FreeSpec with ChiselScalatestTester{
    "task3" in {
        test(new task3(UInt(16.W),UInt(16.W))){c =>
            c.io.in1.poke(4.U)
            c.io.in2.poke(5.U)
            c.io.sel.poke(0.B)
            c.clock.step(500)
            c.io.out.expect(5.U)
            
    }
    }
	
	
}
