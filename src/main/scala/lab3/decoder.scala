package lab3
import chisel3._
import chisel3.util._
class DecoderIO extends Bundle {
	val in = Input(UInt(2.W))
	val out = Valid(UInt(4.W))
}
class Decoder2to4 extends Module {
	val io = IO (new DecoderIO)
	io.out.bits := 0. U
	switch (io.in){
		is ("b00".U) {
		io.out.bits := "b0001".U
		}

		is ("b01".U) {
		io.out.bits := "b0010".U}

		is ("b10".U){
		io.out.bits := "b0100".U
		}

		is ("b11".U){
		io.out.bits := "b1000".U
		}
	}
	when(io.out.bits===0.U){io.out.valid:=0.B}
	.otherwise{io.out.valid:=1.B}
}
