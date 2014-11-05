
/**
 * Se desea clasificar cada triángulo según sus características.
 *      Por orden de importancia, nos interesan los triángulos:
 *          -Equiláteros
 *          -Isósceles
 *          -Rectángulo
 *          -Escaleno
 *          -Y por último, los triángulos imposibles
 *      Cuando un triángulo es de cierto tipo, ya no se comprueba si pertenece a un tipo posterior.
 *      Desarrolla un programa java que pregunte por la longitud del primer, segundo y tercer 
 *      lado de un triángulo, y lo clasifique según el criterio anterior.
 *      Se supondrá que las longitudes de los lados serán números enteros.
 * @author Adrián Marcos Zarabozo González.
 */
import java.util.Scanner;
public class ClasificaTriangulo
{
   public static void main (String args[]){
      System.out.println("Este programa clasfifica triangulos. ");
      
      Scanner in = new Scanner (System.in);
      
      System.out.println("Longitud del primer lado ");
      int lado1 = Integer.parseInt(in.nextLine());
      
      System.out.println("Longitud del segundo lado ");
      int lado2 = Integer.parseInt(in.nextLine());
      
      System.out.println("Longitud del tercer lado ");
      int lado3 = Integer.parseInt(in.nextLine());
      
      if ((lado1+lado2 < lado3) || (lado1+lado3 < lado2) || (lado2+lado3 < lado1)){
          System.out.println("Es un triangulo : imposible");
      }
      else if ((lado1 == lado2) && (lado2 == lado3)){
          System.out.println("Es un triangulo : equilatero");
      }
      else if ((lado1 == lado2) && (lado1 != lado3) || (lado1 == lado3) && (lado1 != lado2) || (lado2 == lado3) && (lado2 != lado1)){
          System.out.println("Es un triangulo : isosceles");
      }
      else if (((lado1 * lado1) + (lado2 * lado2) == (lado3 * lado3)) || ((lado1 * lado1) + (lado3 * lado3) == (lado2 * lado2)) || ((lado2 * lado2) + (lado3 * lado3) == (lado1 * lado1))) {
          System.out.println("Es un triangulo : rectangulo");
      }
      else if ((lado1 != lado2) && (lado1 != lado3) && (lado2 != lado3)){
          System.out.println("Es un triangulo : escaleno");
      }      
   }
}

