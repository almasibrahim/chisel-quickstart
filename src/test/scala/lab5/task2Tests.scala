package lab5

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class RouterTests extends FreeSpec with ChiselScalatestTester{
    "Router" in {
        test(new Router(UInt(32.W),UInt(32.W))){c =>
            c.io.in.address.poke(2.U)
	    c.io.in.data.poke(32.U)
            c.clock.step(10)
            c.io.out.address.expect(2.U)
            c.io.out.data.expect(32.U)
            
    }
    }
	
	
}
