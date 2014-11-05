import java.util.Scanner;
public class Media {
	public static void main(String args[]){

		int numeros = 0; //numeros en total de la media
		double num = 0; //numero que se escribe para hacer la media	
		double suma = 0;

		System.out.println("Bienvenido al calculador de medias. Cuantos numeros forman parte de la media?");
		Scanner in = new Scanner( System.in );
		numeros = Integer.parseInt(in.nextLine());		



		for(int contador=1; contador<=numeros; contador++){ 

			System.out.println("Numero " + contador + ":");
			num = Double.parseDouble(in.nextLine());
			suma = (suma + num);
		}
		System.out.println(suma/numeros);

	}
}


