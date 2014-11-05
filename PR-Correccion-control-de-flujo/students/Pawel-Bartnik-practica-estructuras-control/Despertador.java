/**
 * @description : Programa despertador. 
 * @author : Pawel Bartnik
 */
 import java.util.Scanner;

public class Despertador {

	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		
		System.out.println("Bienvenido al programador de despertadores");
		System.out.println("Que dia de la semana es hoy?");
		int dia = Integer.parseInt(in.nextLine());
		
		System.out.println("Cuantos dias debo programar el despertador?");
		int dias = Integer.parseInt(in.nextLine());
		
		for(int contador=1; contador <= dias; contador++){
			if(dia + contador % 7 ==7){
				System.out.print(" OFF ");
			} else if ((dia + contador) % 7 ==6) {
				System.out.print(" 10:30 ");
			} else {
				System.out.print(" 7:30 ");
			}
		}
		
		

	}

}
