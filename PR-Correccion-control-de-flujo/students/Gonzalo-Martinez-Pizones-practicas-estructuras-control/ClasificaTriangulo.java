/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

import java.util.Scanner;

/*Se desea clasificar cada triángulo según sus características. 
	Por orden de importancia, nos interesan los triángulos:
		- Equiláteros
		- Isósceles
		- Rectángulos
		- Escalenos
		- Y por último, los triángulos imposibles
	
	Cuando un triángulo es de cierto tipo, ya no se comprueba si pertenece a un tipo posterior.
	
	Desarrolla un programa Java que pregunte por la longitud del primer, segundo y tercer
	lado de un triángulo, y lo clasifique según el criterio anterior.
	Se supondrá que las longitudes de los lados son números enteros.


    @author Gonzalo Martinez Pizones
 */
public class ClasificaTriangulo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner in = new Scanner(System.in);
         System.out.println("Este programa clasifica triangulos.");
         System.out.println("Longitud del primer lado:");
         int lado1 = Integer.parseInt(in.nextLine());
         System.out.println("Longitud del segundo lado:");
         int lado2 = Integer.parseInt(in.nextLine());
         System.out.println("Longitud del tercer lado:");
         int lado3 = Integer.parseInt(in.nextLine());
         if ((lado1 + lado2 <= lado3)||(lado2 + lado3 <= lado1)||(lado1+lado3 <= lado2)){
             System.out.println("Es un triangulo imposible");
         }else if ((lado1 == lado2)&&(lado2==lado3)&&(lado1==lado3)){
             System.out.println("Es un triangulo equilatero");
         } else if (((lado1==lado2)&&(lado1!=lado3))||((lado2==lado3)&&(lado1!=lado2))||((lado1==lado3)&&(lado2!=lado3))){
              System.out.println("Es un triangulo isosceles"); 
         }else if ((lado1*lado1==lado2*lado2+lado3*lado3)||(lado2*lado2==lado1*lado1+lado3*lado3)||(lado3*lado3==lado1*lado1+lado2*lado2)){
             System.out.println("Es un triangulo rectangulo");
         }else if (((lado1!=lado2)&&(lado2!=lado3)&&(lado1!=lado3))){
             System.out.println("Es un triangulo escaleno");
         }
    }
}
