package lab3

import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._
import chiseltest.experimental.TestOptionBuilder._
import chiseltest.internal.VerilatorBackendAnnotation
import scala.util.Random


class BranchControlTests extends FreeSpec with ChiselScalatestTester {

"branch" in {
    test(new BranchControl).withAnnotations(Seq(VerilatorBackendAnnotation)){ c =>
	val array_func = Array("b000","b001","b100","b101","b110","b111")
	val array_b = Array(0,1)

	for ( i<- 0 until 100) {
		val src_a = Random.nextLong()&0xFFFFFFFFL
		val src_b = Random.nextLong()&0xFFFFFFFFL
		val op1 = Random.nextInt(6)
		val f3 = array_func(op1)
		val op2 = Random.nextInt(2)
		val b = array_b(op2)
		

        	val result = f3 match {
		        case "b000" => src_a == src_b && b==1
		        case "b001" => src_a != src_b && b==1
		        case "b100" => src_a < src_b && b==1
		        case "b101" => src_a >= src_b && b==1
		        case "b110" => src_a < src_b && b==1
		        case "b111" => src_a >= src_b && b==1
		}
		println(f3,src_a,src_b,b,result)
		

	
	

	  
      c.io.fnct3.poke(f3.U)
      c.io.branch.poke(b.B)
      c.io.arg_x.poke(src_a.U)
      c.io.arg_y.poke(src_b.U)
      c.clock.step(10)
      c.io.br_taken.expect(result.asBool)
      }
    }
 
    }
  }
