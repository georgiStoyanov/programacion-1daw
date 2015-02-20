import java.math.BigDecimal;
import java.math.MathContext;


public class RaizDeDos {

	public static void main(String[] args) {
		BigDecimal raizDeDos = raizDeDos( 5000 );
		System.out.println( "Raiz de dos:" + raizDeDos );
	}

	
	private static BigDecimal raizDeDos(int decimales) {
		MathContext mc = new MathContext(decimales);
		BigDecimal dos = new BigDecimal("2",mc);
		BigDecimal aproximacion = new BigDecimal("1",mc);
		BigDecimal aproximacionAnterior = new BigDecimal(0);
		
		
		while( !aproximacion.equals(aproximacionAnterior) ){
			aproximacionAnterior = aproximacion;
			aproximacion = (aproximacion.add(dos.divide(aproximacion,mc))).divide(dos,mc);
			System.out.println( "aproximacion:" + aproximacion );
		}
		
		return aproximacion;
	}
}
