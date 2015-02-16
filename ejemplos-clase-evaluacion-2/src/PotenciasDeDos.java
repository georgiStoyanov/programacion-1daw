import java.math.BigInteger;


public class PotenciasDeDos {

	public static void main(String[] args) {
		BigInteger dos = new BigInteger("2");
		BigInteger potencia = new BigInteger("1");
		for( int i = 0 ; i <= 100 ; i++ ){
			System.out.printf( "%d --> %s (%.0f)\n", i, potencia, Math.pow(2, i) );
			potencia = potencia.multiply(dos);
		}
	}
}
