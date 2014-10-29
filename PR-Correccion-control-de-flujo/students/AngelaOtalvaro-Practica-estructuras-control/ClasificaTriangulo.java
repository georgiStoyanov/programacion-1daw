import java.util.Scanner;

public class ClasificaTriangulo {

	/**
	 * @author Angela Maria Otalvaro Munera
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner myScanner = new Scanner(System.in);
		System.out.println("Este programa clasifica triangulos");
		System.out.println("longitud del primer lado: ");
		int ladoUno = Integer.parseInt(myScanner.nextLine());
		System.out.println("longitud del segundo lado: ");
		int ladoDos = Integer.parseInt(myScanner.nextLine());
		System.out.println("longitud del tercero lado: ");
		int ladoTres = Integer.parseInt(myScanner.nextLine());

		if ((ladoUno + ladoDos > ladoTres) && (ladoDos + ladoTres > ladoUno)
				&& (ladoTres + ladoUno > ladoDos)) {

			if ((ladoUno == ladoDos) && (ladoDos == ladoTres)) {
				System.out.println("Es un triángulo: equilátero");

			} else if ((ladoUno * ladoUno) + (ladoDos * ladoDos) == (ladoTres * ladoTres)
					|| (ladoUno * ladoUno) + (ladoTres * ladoTres) == (ladoDos * ladoDos)
					|| (ladoDos * ladoDos) + (ladoTres * ladoTres) == (ladoUno * ladoUno)) {

				System.out.println("Es un triangulo rectángulo");

			} else if ((ladoUno == ladoDos) || (ladoUno == ladoTres)
					|| (ladoDos == ladoTres)) {

				System.out.println("Es un tríangulo: isósceles");

			} else {

				System.out.println("Es un triángulo: escaleno");

			}

		} else {
			System.out.println("Es un triangulo: imposible");

		}
	}

}
