
import java.util.Scanner;


public class TablaDeMultiplicar{
	public static void main (String args[]){

		int contador = 1;
		int num = 0;

		Scanner in = new Scanner( System.in );
		//Introduzco un numero por pantalla
		System.out.println("Tabla de multiplicar para el numero: ");
		num = Integer.parseInt(in.nextLine());	

		//Si es menor o igual que 10, lo multiplica por el contador
		if(num<=10 && num>=1){		
			// mostrar en bucle la multiplicacion
			while(contador <= 10){
			System.out.println(num + " x " + contador + " = " + num * contador);
			contador++;
			}
		} else {
			System.out.println(" Fuera de rango");
		}

	}
}


