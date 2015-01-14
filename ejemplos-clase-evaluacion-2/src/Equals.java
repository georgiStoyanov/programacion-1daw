import java.util.Scanner;

public class Equals {

	private static Scanner in = new Scanner(System.in);
	private static String[] meses = { "Enero", "Febrero", "Marzo", "Abril",
			"Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
			"Noviembre", "Diciembre" };
	
	private static int[] diasDeMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	/**
	 * 
	 * @param array
	 * @param buscado
	 * @return -1 si no lo encuentro
	 */
	public static int buscaEnArray( String[] array, String buscado ){
		for (int i = 0 ; i < array.length ; i += 1 ){
			String m = array[i];
			if (m.toLowerCase().equals(buscado.toLowerCase())) {
				return i;
			}
		}
		return -1;
	}

	public static String preguntaMes() {
		while (true) {
			System.out.print("Dime un mes:");
			String mes = in.nextLine().toLowerCase();

			int i = buscaEnArray(meses, mes);
			if( i > 0 ){
				return meses[i];
			}
			
			if( mes.toLowerCase().equals( "salir") ){
				System.exit(0);
			}
		}
	}

	public static int diasDeMes(String mes) {
		int i = buscaEnArray(meses, mes);
		if( i > 0 ){
			return diasDeMes[i];
		}
		throw new IllegalArgumentException();
	}

	public static void main(String[] args) {

		String mes = preguntaMes();
		while (mes != "salir") {
			System.out.printf("El mes %s tiene %d días\n", mes, diasDeMes(mes));
			mes = preguntaMes();
		}
	}

}
