
/**
 *   Se desea clasificar cada triángulo según sus características. 
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
 * @author (Enrique González ) 
 
 */
import java.util.Scanner;
public class ClasificaTriangulo
{
    public static void main(String [] args){
        System.out.println("Este programa clasifica triangulos.");
        Scanner in = new Scanner( System.in);
        System.out.println(" Longitud del primer lado: ");
        int a = Integer.parseInt( in.nextLine () );
        System.out.println(" Longitud del segundo lado: ");
        int b = Integer.parseInt( in.nextLine () );
        System.out.println(" Longitud del tercer lado: ");
        int c = Integer.parseInt( in.nextLine () );
        
        
        
        
        
        
        if ( a == b && a == c ){
            System.out.println(" Es un triangulo: equilatero.");       
        }
        else {
            if ( (a==b && (c < ( a+b)) && a!=c ) || (a==c && (b < (a+c)) && a!=b) || (b==c && (a < (b+c)) && b!= a)){ 
                System.out.println ( " Es un triangulo : isosceles.");
            }
            else {
                if ((a*a + b*b ==c*c ) ||(a*a + c*c  == b*b) || (c*c + b*b == a*a)) {
                    System.out.println( " Es un triangulo : rectangulo");
                }
                else {
                    if ( (a >= ( b+c)) || (b >= (a+c)) || ( c >= (a+b))) {
                        System.out.println( " Es un triangulo: imposible.");
                    }
                    else {    
                        System.out.println ( " Es un triangulo: escaleno.");
                    }
                }
            }
        }
    }
}

