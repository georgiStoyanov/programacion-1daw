import java.util.Scanner;
public class ClasificaTriangulo {

	public static void main(String args[] ){
		System.out.println("Este programa clasifica triangulos. ");	

		int lado1, lado2, lado3;

		Scanner in = new Scanner( System.in );

		//Pregunta por el primer lado
		System.out.println("Longitud del primer lado: ");			
		lado1 =	Integer.parseInt(in.nextLine());

		//Pregunta por el segundo lado
		System.out.println("Longitud del segundo lado: ");
		lado2 = Integer.parseInt(in.nextLine());

		// Pregunta por el tecer lado
		System.out.println("Longitud del tercer lado: ");
		lado3= Integer.parseInt(in.nextLine());		

		//Comprueba si la suma de dos lados es mayor que el tercer lado
		if ( ((lado1 + lado2) <= lado3) || (lado1 + lado3 <=lado2) || (lado2 + lado3 <= lado1)){ 
			System.out.println("Es un triangulo: imposible. ");
		}

		else if((lado1 == lado2) && (lado1 == lado3)) {
			System.out.println("Es un triangulo: equilatero. ");

		} else if ((lado1 == lado2) || (lado1 == lado3) || (lado2 == lado3)){  
			System.out.println("Es un triangulo: isosceles. ");
			
		/* Hace el cuadrado de un lado y lo suma al cuadrado de otro. Si es igual al cuadrado del tercero, es rectángulo*/
		} else if 
		((lado1 * lado1) + (lado2 * lado2) == (lado3 * lado3) ||
		(lado1 * lado1) + (lado3 * lado3) == (lado2 * lado2)||
		(lado3 * lado3) + (lado2 * lado2) == (lado1 * lado1))
				 {
			System.out.println("Es un triangulo: rectangulo. ");		
			}		

		//Si son todos distintos entre ellos, es escaleno.
		else if ((lado1 != lado2) && (lado1 != lado3) && (lado2 != lado3)) {
			System.out.println("Es un triangulo: escaleno. ");	

		}
	}

}
