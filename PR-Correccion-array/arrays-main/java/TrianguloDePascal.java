/*Autor Andres Arrojo
 * 
 */
import java.util.Scanner;

public class TrianguloDePascal {
	public static void main(String[] args) {

		System.out.print("De que tamaño sera el triangulo?: ");
		Scanner in = new Scanner(System.in);

		int triangulo = in.nextInt();
		if (triangulo > 0) {
			int[][] matriz = new int[triangulo][triangulo];
			for (int i = 0; i < triangulo; i++) {
				matriz[i][0] = 1;
				for (int j = 1; j <= i; j++) {
					matriz[i][j] = matriz[i - 1][j - 1] + matriz[i - 1][j];
				}
			}
			for (int i = 0; i < triangulo; i++) {
				for (int j = 0; j < triangulo; j++)
					if (matriz[i][j] > 0)
						System.out.print(matriz[i][j] + " ");
				System.out.println();
			}

		} else {
			System.out.println("El triangulo debe ser mayor que 0");
		}
		in.close();
	}
}
