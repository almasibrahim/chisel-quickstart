package lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_ImmdValGen extends Bundle {
	val instr = Input ( UInt (32. W ) )
	val pc = Input ( UInt (32. W ) )
	val immd_se = Output ( UInt (32. W ) )
}
class ImmdValGen extends Module {
	val io = IO ( new LM_IO_Interface_ImmdValGen )


	val opcode=io.instr(6,0)
	io.immd_se:=0.U

	switch(opcode){
 
        is("b0100011".U){
	//S
	val s_imm13 = Cat (io.instr(31,25),io.instr(11,7))
	io.immd_se := (Cat(Fill(20,s_imm13(11)),s_imm13))}

	is("b1100011".U){
	//SB
	val sb_imm13 = Cat (io.instr(31),io.instr(7),io.instr(30,25),io.instr(11,8),"b0".U)
	io.immd_se := ((Cat(Fill(19,sb_imm13(12)),sb_imm13)) + io.pc)}

	is("b1101111".U){
	//UJ
	val uj_imm21 = Cat (io.instr(31),io.instr(19,12),io.instr(20),io.instr(30,21),"b0".U)
	io.immd_se := ((Cat(Fill(10,uj_imm21(20)),uj_imm21)) + io.pc)}

	is("b0110111".U){
	//U
	io.immd_se := ((Cat(Fill(12,io.instr(19)),io.instr(31,12))) << 12)}

	is("b0010011".U){
	//I
	io.immd_se := (Cat(Fill(20,io.instr(11)),io.instr(31,20)))}

	}
};
