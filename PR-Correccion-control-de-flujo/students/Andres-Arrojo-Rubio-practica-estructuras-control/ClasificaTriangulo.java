
/**
 * Se desea clasificar cada triangulo segun sus caracteristicas.
 *  Por orden de importancia, nos interesan los triangulos:
 *      -Equilateros
 *      -Isosceles
 *      -Rectángulo
 *      -Escaleno
 *      -Y por ultimo, los triangulos imposibles
 *      
 *  Cuando un triangulo es de cierto tipo, ya no se comprueba si pertenece a un tipo posterior.
 *      
 *  Desarrolla un programa java que pregunte por la longitud del primer, segundo y tercer lado de un triangulo,
 *  y lo clasifique segun el criterio anterior.
 *  
 *  Se supondra que las longitudes de los lados seran numeros enteros.
 * 
 * @author (Andres Arrojo) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ClasificaTriangulo
{   public static void main( String[] args ){
        Scanner in = new java.util.Scanner( System.in );
        
        System.out.println( "Este programa clasifica triangulos" );
        
        System.out.println( "Longitud del primer lado" );
        int lado1 = Integer.parseInt( in.nextLine() );
        
        System.out.println( "Longitud del segundo lado" );
        int lado2 = Integer.parseInt( in.nextLine() );
        
        System.out.println( "Longitud del tercer lado" );
        int lado3 = Integer.parseInt( in.nextLine() );
        
        if( (lado1 + lado2 <= lado3 )  || (lado2 + lado3 <= lado1 )  || (lado3 + lado1 <= lado2  ) ){
            System.out.println( "Es un triangulo: imposible" );
        }
        else if( (lado1 == lado2) && (lado2 == lado3) ){
            System.out.println( "Es un triangulo: equilatero" );
        } 
        else if( ( (lado1 == lado2) && (lado1 != lado3) ) || ( (lado2 == lado3) && (lado2 != lado1) ) || ( (lado3 == lado1) && (lado3 != lado2) ) ){
                System.out.println( "Es un triangulo: isosceles" );     
        }
        else if( ( (lado1 * lado1) + (lado2 * lado2) == (lado3 * lado3) ) || ( (lado2 * lado2) + (lado3 * lado3) == (lado1 * lado1) ) || ( (lado3 * lado3) + (lado1 * lado1) == (lado2 * lado2) ) ){
            System.out.println( "Es un triangulo: rectangulo" );
        }
        else if( (lado1 != lado2) && (lado2 != lado3) && (lado1 != lado3) ){
            System.out.println( "Es un triangulo: escaleno" );
        }
    }   
}
