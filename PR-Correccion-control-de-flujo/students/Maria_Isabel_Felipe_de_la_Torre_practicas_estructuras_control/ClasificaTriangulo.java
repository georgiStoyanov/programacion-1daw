
/**
Se desea clasificar cada triángulo según sus características. 
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
@author Maria Isabel Felipe de la Torre
 */
import java.util.Scanner;
public class ClasificaTriangulo
{
   public static void main (String[] args){
       Scanner in = new Scanner (System.in);
       
       System.out.println ("Longitud del primer lado");
       int a=Integer.parseInt (in.nextLine ());
       
       System.out.println ("Longitud del segundo lado");
       int b=Integer.parseInt (in.nextLine ());
       
       System.out.println ("Longitud del tercer lado");
       int c=Integer.parseInt (in.nextLine ());
       
      
       if ((a>=b+c) || (b>=a+c) || (c>=a+b)) {
           System.out.println ("El triángulo es imposible");
        }
       else if ((a==b) && (a==c) && (b==c)) {
           System.out.println ("El triángulo es equilátero");
        }
       else if ((a==b) || (a==c) || (b==c)) {
           System.out.println ("El triángulo es isósceles");
        }
       else if ( 
                ((a*a)==((b*b)+(c*c))) ||
                ((b*b)==((a*a)+(c*c))) ||
                ((c*c)==((a*a)+(b*b)))
                ) 
        {
           System.out.println ("El triángulo es rectángulo");
        }
       else if (!((a==b) && (a==c) && (b==c)) && !((a>=b+c) || (b>=a+c) || (c>=a+b))) {
           System.out.println ("El triángulo es escaleno");
        }
   }
}
