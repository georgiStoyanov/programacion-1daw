import java.util.Scanner;

/**
 * Realiza un programa que pregunte por dos numeros enteros y los sume. 
 * Si no se introduce un numero, el
 * programa seguira preguntando hasta que obtener un numero correcto (2 puntos). 
 * Despues, este programa decidira si dicha suma es capicua (3 puntos)
 * 
 * 
 * @author ---nombre-del-alumno---
 *
 */
public class SumaCapicua {
    
	
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i1 = preguntaNumeroHastaAcertar( in, "primer numero?:");
		int i2 = preguntaNumeroHastaAcertar( in, "segundo numero?:");
		int suma = i1 + i2;
		System.out.printf( "la suma de %d y %d es %d\n", i1, i2, suma );
		
		if( esCapicua(suma) ){
			System.out.printf( "%d si es capicua\n", suma );
			
		}
		else{
			System.out.printf( "%d no es capicua\n", suma );
		}
		
    }

	private static boolean esCapicua(int suma) {
		String s = String.valueOf(suma);
		for (int i = 0; i < s.length(); i++) {
			int j = s.length()-i-1;
			if( s.charAt(i) != s.charAt(j) ){
				return false;
			}
		}
		return true;
	}

	private static boolean esCapicua_dosVariables(int suma) {
		String s = String.valueOf(suma);
		int i = 0 ;
		int j = s.length()-1;
		while( i < s.length() ){
			if( s.charAt(i) != s.charAt(j) ){
				return false;
			}
			i += 1;
			j -= 1;
		}
		return true;
	}
	
	
	private static boolean esCapicua_matematicas(int suma) {
		int alReves = 0;
		int resto = suma;
		while( resto > 0 ){
			int digito = resto % 10;
			resto = resto / 10;
			alReves = alReves* 10 + digito;
		}
		
		return suma == alReves;
		
		
	}		


	private static int preguntaNumeroHastaAcertar(Scanner in, String mensaje ) {
		while( true ){
			System.out.print( mensaje );
			String linea = in.nextLine();
			try {
				return Integer.parseInt(linea);
			}
			catch (NumberFormatException e) {
				System.out.print( linea + " no es un numero. ");
			}
		}
	}
	
	

}