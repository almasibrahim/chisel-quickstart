package lab6

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation

class UpdownTests extends FreeSpec with ChiselScalatestTester{
    "Updown" in {
        test(new Updown(5)).withAnnotations(Seq(VerilatorBackendAnnotation)){c =>
            c.io.up_down.poke(1.B)  
            c.clock.step(5)
	    c.io.up_down.poke(0.B)
	    c.clock.step(5)
            //c.io.out.expect(0.U)
            
    }
    }

	
}
