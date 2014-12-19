import java.util.Scanner;
import static java.lang.Math.*;

/**
 * 
 * Realiza un programa que recoja una linea de texto por teclado (se supone que
 * no habra signos de puntuacion). Despues imprimira la siguiente estadistica:
 * Numero de palabras (1 punto) Longitud de la palabra mas larga (1.5 puntos)
 * Longitud de la palabra mas corta (1.5 puntos) Si no hubiese palabras que
 * contabilizar, se indicara adecuadamente segun los ejemplos (1 punto)
 * 
 * @author ---nombre-del-alumno---
 * 
 */
public class EstadisticaDeTexto {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		println("Dime la linea de texto");
		String linea = in.nextLine();

		int numeroDePalabras = contarPalabras(linea);
		int longitudPalabraMasCorta = calculaLongitudMasCorta(linea);
		int longitudPalabraMasLarga = calculaLongitudMasLarga(linea);

		if (numeroDePalabras > 0) {
			println("Numero de palabras:" + numeroDePalabras);
			println("Longitud de la palabra mas larga: "
					+ longitudPalabraMasLarga);
			println("Longitud de la palabra mas corta: "
					+ longitudPalabraMasCorta);

		} else {
			println("Numero de palabras: 0");
			println("Longitud de la palabra mas larga: No hay palabra mas larga");
			println("Longitud de la palabra mas corta: No hay palabra mas corta");
		}

	}

	private static int calculaLongitudMasLarga(String linea) {
		String[] palabras = linea.split(" ");
		int ret = Integer.MIN_VALUE;
		for (String p : palabras) {
			ret = max(ret, p.length());
		}
		return ret;
	}

	private static int calculaLongitudMasCorta(String linea) {
		String[] palabras = linea.split(" ");
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < palabras.length; i += 1) {
			if (ret > palabras[i].length()) {
				ret = palabras[i].length();
			}
		}
		return ret;
	}

	private static int contarPalabras(String linea) {
		if( linea.trim().length() == 0 ){
			return 0;
		}
		String[] palabras = linea.split(" ");
		return palabras.length;
	}

	private static int contarPalabras_2(String linea) {
		char[] array = linea.toCharArray();
		int espacios = 0;
		for (int i = 0; i < array.length; i++) {
			char c = array[i];
			if (c == ' ') {
				espacios += 1;
			}
		}
		return espacios + 1;
	}

	private static int contarPalabras_1(String linea) {
		String lineaSinEspacios = linea.replaceAll(" ", "");
		return linea.length() - lineaSinEspacios.length() + 1;
	}

	private static void println(String string) {
		System.out.println(string);
	}

}