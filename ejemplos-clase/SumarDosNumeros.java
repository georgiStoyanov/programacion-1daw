import java.util.Scanner;


public class SumarDosNumeros {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int i1 = leeNumero( "Dime el primer numero:", in );
		int i2 = leeNumero( "Dime el segundo numero:", in );
		
		System.out.printf( "La suma de %d y %d es %d", i1, i2, i1+i2 );
	}

	
	
	private static int leeNumero(String mensaje, Scanner in) {
		boolean numeroCorrecto = false;
		int ret = 0;
		while( !numeroCorrecto ){
			System.out.print( mensaje );
			String s = in.nextLine();
			try{
				ret = Integer.parseInt(s);
				numeroCorrecto = true;
			}
			catch(NumberFormatException e ){
				System.out.printf( "|%s| no es un numero entero. ", s );
			}
		}
		return ret;
	}
	
	
	private static int leeNumeroCorto(String mensaje, Scanner in) {
		while( true ){
			System.out.print( mensaje );
			String s = in.nextLine();
			try{
				return Integer.parseInt(s);
			}
			catch(NumberFormatException e ){
				System.out.printf( "|%s| no es un numero entero. ", s );
			}
		}
	}
	
	
	
	
	

	
}
