import java.util.Scanner;

public class IntentaParsearNumero {

	private static void println(String s) {
		System.out.println(s);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		println("Escribe un texto, intentare parsearlo como numero:");
		String texto = in.nextLine();
		
		try{
			int i = Integer.parseInt(texto,10);
			println( texto + " vale " + i + " como numero decimal ");
		}
		catch( NumberFormatException e ){
			println( texto + " no es un numero decimal ");
		}

		try{
			int i = Integer.parseInt(texto,16);
			println( texto + " vale " + i + " como numero hexadecimal ");
		}
		catch( NumberFormatException e ){
			println( texto + " no es un numero hexadecimal ");
		}
		
		try{
			double d = Double.parseDouble(texto);
			println( texto + " vale " + d + " como numero real ");
		}
		catch( NumberFormatException e ){
			println( texto + " no es un numero real ");
		}
	
	}

}
