import java.util.Scanner;


public class ImprimirSoloConMayusculas {

	public static void main(String[] args) {
		System.out.println("Dime una linea");
		String linea = new Scanner(System.in).nextLine();
		
		for( String palabra : linea.split(" ") ){
			if( !tieneMayuscula(palabra) ){
				continue;
			}
			System.out.print(palabra + " ");
		}
	}

	private static boolean tieneMayuscula(String palabra) {
		for( char c : palabra.toCharArray() ){
			if( Character.isUpperCase(c) ){
				return true;
			}
		}
		return false;
	}
	
}
