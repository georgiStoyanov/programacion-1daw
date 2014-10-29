import java.util.Scanner;

public class Despertador {

	/**
	 * @author Angela Maria Otalvaro Munera
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Bienvenido al programador de despertadores");
		System.out.println("Que dia de la semana es hoy? ");
		int dia = Integer.parseInt(myScanner.nextLine());
		System.out.println("Cuantos dias debo programar el despertador? ");
		int diasProgramar = Integer.parseInt(myScanner.nextLine());
		String despertador = "";

		int resultado = 0;

		for (int i = 1; i <= diasProgramar; i++) {

			resultado = (dia + i); // incrementamos el dia, para que inicie el dia siguiente
									

			if (resultado > 7) {
				resultado = resultado % 7;

				// Cuando son multiplos de 7
			if (resultado == 0) {
					resultado = 7;
				}
			}

			switch (resultado) {

			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				despertador = "7:30";
				break;
			case 6:
				despertador = "10:30";
				break;
			case 7:
				despertador = "OFF";
				break;
			default:

			}
			System.out.print(despertador + " ");
		}

	}
}
