package lab3

import chisel3._
import chisel3.util._
import chisel3.core


class Alu(AluControl:UInt) extends Module {
  val io = IO (new Bundle {
	//val AluControl = Input(UInt(5.W))
	val in1 = Input(SInt(32.W))
	val in2 = Input(SInt(32.W))
	//val Branch = Output(UInt(1.W))
	val out = Output(SInt(32.W))
  })
	io.out:=0.S
	switch(AluControl){
	//Add Addi
	is ("b00000".U){io.out := io.in1 + io.in2}
	//Sll Slli Sra Srai
	is ("b00001".U){io.out := io.in1 << io.in2(4,0)}
	//Xor Xori
	is ("b00100".U){io.out := io.in1 ^ io.in2}
	//Srl Srli
	is ("b00101".U){io.out := io.in1 >> io.in2(4,0)}
	is ("b01101".U){io.out := io.in1 >> io.in2(4,0)}
	//Or Ori
	is ("b00110".U){io.out := io.in1 | io.in2}
	//And Andi
	is ("b00111".U){io.out := io.in1 & io.in2}
	//Sub
	is ("b01000".U){io.out := io.in1 - io.in2}
	//Jal Jalr
	is ("b11111".U){io.out := io.in1}
	//Bge
	is ("b10101".U){
		when (io.in1 >= io.in2){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	//Bgeu
	is ("b10111".U){
		when (io.in1.asUInt >= io.in2.asUInt){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	//Sltu Sltui Bltu
	is ("b00011".U){
		when (io.in1.asUInt < io.in2.asUInt){io.out := 1.S}
		.otherwise {io.out := 0.S}}
        is ("b10110".U){
		when (io.in1.asUInt < io.in2.asUInt){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	//Beq
	is ("b10000".U){
		when (io.in1 === io.in2){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	//Slt Slti Blt
	is ("b00010".U){
		when (io.in1 < io.in2){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	is ("b10100".U){
		when (io.in1 < io.in2){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	//Bne
	is ("b10001".U){
		when (io.in1 =/= io.in2){io.out := 1.S}
		.otherwise {io.out := 0.S}}
	}

	//Branch
	//when (io.out === 1.S && io.AluControl(4,3) === "b10".U){io.Branch := "b1".U}
	//.otherwise {io.Branch := "b0".U}
}
