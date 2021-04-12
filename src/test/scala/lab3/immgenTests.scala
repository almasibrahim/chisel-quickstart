package lab3

import org.scalatest._
import chiseltest._
import chisel3._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random


class ImmdValGenTests extends FreeSpec with ChiselScalatestTester {

  "immgen" in {
    test(new ImmdValGen).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>

      val array_i = Array("h06310013","h08216013","h03f17013","h05814013")
	

	for ( i<- 0 until 100) {
		val op1 = Random.nextInt(4)
		val itype = array_i(op1)
		val result = itype match {
		        case "h06310013"=> 99
		        case "h08216013" => 130
		        case "h03f17013" => 63
		        case "h05814013" => 88
		       
		}
		println(itype,result)
		

      c.io.instr.poke(itype.U)
      c.io.pc.poke(0.U)
      c.clock.step(10)
      c.io.immd_se.expect(result.U)
      }
    }
 
    }
  }
