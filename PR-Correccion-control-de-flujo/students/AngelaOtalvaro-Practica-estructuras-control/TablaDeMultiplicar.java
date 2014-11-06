import java.util.Scanner;

public class TablaDeMultiplicar {

	/**
	 * @author Angela Maria Otalvaro Munera
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Tabla de multiplicar para el numero: ");
		int numero = Integer.parseInt(myScanner.nextLine());

		if (numero < 1 || numero > 10) {
			// Condicion que me evalua el rango que debe ser entre (1 y 10)
			System.out.println("Fuera de rango");
		} else {
			for (int i = 1; i <= 10; i++) {

				System.out.println(numero + " x " + i + " = " + (numero * i));

			}
		}
	}

}
