/**
  Se desea clasificar cada triangulo segun sus caracterasticas. 
    Por orden de importancia, nos interesan los triangulos:
        - Equilateros
        - Isoceles
        - Rectangulos
        - Escalenos
        - Y por Ultimo, los triangulos imposibles
    
    Cuando un triangulo es de cierto tipo, ya no se comprueba si pertenece a un tipo posterior.
    
    Desarrolla un programa Java que pregunte por la longitud del primer, segundo y tercer
    lado de un triangulo, y lo clasifique segun el criterio anterior.
    Se supondra que las longitudes de los lados son numeros enteros.


    @author Carolina de Pascual JimÃ©nez
 */
import java.util.Scanner;
public class ClasificaTriangulo{
    public static void main( String[] args ){
        Scanner in = new Scanner ( System.in );
        System.out.println( "Este programa clasifica triangulos" );
        
        System.out. println( "Longitud del primer lado:" );
        int lado1 = Integer.parseInt( in.nextLine());
        
        System.out.println( "Longitud del segundo lado:" );
        int lado2 = Integer.parseInt( in.nextLine());
        
        System.out.println( "Longitud del tercer lado:" );
        int lado3 = Integer.parseInt( in.nextLine());
      if  ((lado1 >= (lado2+lado3)) ||
            (lado2 >= (lado1+lado3)) ||
            (lado3 >= (lado1+lado2))) 
            {System.out.println( "El triangulo es imposible");
            }else if ((lado1==lado2) && (lado1==lado3) && (lado2==lado3)){
                System.out.println( "El triangulo es equilatero ");
            }
                else if ((lado1==lado2) || (lado1==lado3) || (lado3==lado2)){                     
                    System.out.println( "El triangulo es isosceles" );                          
                }
                else if (((lado1*lado1)==(lado2*lado2)+(lado3*lado3)) ||
                    ((lado2*lado2)==(lado1*lado1)+(lado3*lado3)) ||
                    ((lado3*lado3)==(lado1*lado1)+(lado2*lado2))){
                        System.out.println( "El triangulo es rectangulo" );       
                    }
                    else if (!(lado1==lado2) && (!(lado1==lado3)) && (!(lado2==lado3))&&!
                    ((lado1 >= (lado2+lado3)) ||
                    (lado2 >= (lado1+lado3)) ||
                    (lado3 >= (lado1+lado2)))){
                        System.out.println( "El triangulo es escaleno");
      }
   }
}