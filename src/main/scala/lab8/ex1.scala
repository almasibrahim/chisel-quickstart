package lab8
import chisel3._
import chisel3.util._

class ex1 extends Module {
	val width : Int = 8
	val io = IO ( new Bundle {
	val enable = Input ( Bool () )
	val write = Input ( Bool () )
	val addr = Input ( UInt (10. W ) )
	val mask = Input ( Vec (4 , Bool () ) )
	val dataIn = Input ( Vec (4 , UInt ( width . W ) ) )
	val dataOut = Output ( Vec (4 , UInt ( width . W ) ) )
})
	// Create a 32 - bit wide memory that is byte - masked
	val mem = SyncReadMem (1024 , Vec (4 , UInt ( 8. W ) ) )
	// Write with mask
        val a=Reg(Vec(4,UInt()))
        
	//0.U
	when(io.mask(0)===0.B && io.mask(1)===0.B && io.mask(2)===0.B && io.mask(3)===0.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=0.U
		a(3):=0.U
		mem . write ( io . addr , a)
	//1.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===0.B && io.mask(2)===0.B && io.mask(3)===1.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=0.U
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)
	
	//2.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===0.B && io.mask(2)===1.B && io.mask(3)===0.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=io.dataIn(2)
		a(3):=0.U
		mem . write ( io . addr , a)
	//3.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===0.B && io.mask(2)===1.B && io.mask(3)===1.B){
		a(0):=0.U
		a(1):=0.U
		a(2):=io.dataIn(2)
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)
	
	//4.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===1.B && io.mask(2)===0.B && io.mask(3)===0.B){
		a(0):=0.U
		a(1):=io.dataIn(1)
		a(2):=0.U
		a(3):=0.U
		mem . write ( io . addr , a)

	//5.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===1.B && io.mask(2)===0.B && io.mask(3)===1.B){
		a(0):=0.U
		a(1):=io.dataIn(1)
		a(2):=0.U
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)

	//6.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===1.B && io.mask(2)===1.B && io.mask(3)===0.B){
		a(0):=0.U
		a(1):=io.dataIn(1)
		a(2):=io.dataIn(2)
		a(3):=0.U
		mem . write ( io . addr , a)

	//7.U
	}.elsewhen(io.mask(0)===0.B && io.mask(1)===1.B && io.mask(2)===1.B && io.mask(3)===1.B){
		a(0):=0.U
		a(1):=io.dataIn(1)
		a(2):=io.dataIn(2)
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)



	//8.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===0.B && io.mask(2)===0.B && io.mask(3)===0.B){
		a(0):=io.dataIn(0)
		a(1):=0.U
		a(2):=0.U
		a(3):=0.U
		mem . write ( io . addr , a)

	//9.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===0.B && io.mask(2)===0.B && io.mask(3)===1.B){
		a(0):=io.dataIn(0)
		a(1):=0.U
		a(2):=0.U
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)

	//10.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===0.B && io.mask(2)===1.B && io.mask(3)===0.B){
		a(0):=io.dataIn(0)
		a(1):=0.U
		a(2):=io.dataIn(2)
		a(3):=0.U
		mem . write ( io . addr , a)

	//11.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===0.B && io.mask(2)===1.B && io.mask(3)===1.B){
		a(0):=io.dataIn(0)
		a(1):=0.U
		a(2):=io.dataIn(2)
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)

	//12.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===1.B && io.mask(2)===0.B && io.mask(3)===0.B){
		a(0):=io.dataIn(0)
		a(1):=io.dataIn(1)
		a(2):=0.U
		a(3):=0.U
		mem . write ( io . addr , a)

	//13.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===1.B && io.mask(2)===0.B && io.mask(3)===1.B){
		a(0):=io.dataIn(0)
		a(1):=io.dataIn(1)
		a(2):=0.U
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)
	
	//14.U
	}.elsewhen(io.mask(0)===1.B && io.mask(1)===1.B && io.mask(2)===1.B && io.mask(3)===0.B){
		a(0):=io.dataIn(0)
		a(1):=io.dataIn(1)
		a(2):=io.dataIn(2)
		a(3):=0.U
		mem . write ( io . addr , a)


	}.otherwise{
		a(0):=io.dataIn(0)
		a(1):=io.dataIn(1)
		a(2):=io.dataIn(2)
		a(3):=io.dataIn(3)
		mem . write ( io . addr , a)
        }


	io . dataOut := mem . read ( io . addr , io . enable )
}
