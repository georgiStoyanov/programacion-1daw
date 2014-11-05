import java.util.Scanner;


public class Media {

	/**
	 * @author Angela Maria Otalvaro Munera
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner miScanner = new Scanner(System.in);
		
		System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");		
		int numerosACalcular = Integer.parseInt(miScanner.nextLine());
		double suma = 0;
		
		for(int i=0; i<numerosACalcular;i++){
			
			System.out.println("Numero " + (i+1) + ":");
			double numero = Double.parseDouble(miScanner.nextLine());
			suma = suma + numero;			
		}
        double media= (suma/numerosACalcular); //realizamos el calculo de la media
        System.out.println(media);
	}

}
