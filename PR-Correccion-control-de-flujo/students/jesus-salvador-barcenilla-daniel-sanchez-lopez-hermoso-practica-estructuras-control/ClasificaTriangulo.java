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


    @author Jesus Salvador Barcenilla - Daniel Sanchez Lopez-Hermoso
 */
import java.util.Scanner;
public class ClasificaTriangulo
{
   public static void main( String[] args)
    {
       
       Scanner in=new Scanner(System.in);
       
       System.out.println("Este programa clasifica triangulos");
       System.out.println ("Longitud del primer lado: ");
       int a=Integer.parseInt( in.nextLine());
   
       System.out.println ("Longitud del segundo lado: ");
       int b=Integer.parseInt( in.nextLine());
   
       System.out.println ("Longitud del tercer lado: ");
       int c=Integer.parseInt( in.nextLine());
       
       int mayor=c;
       int menor1=b;
       int menor2=a;
       
       if((c>b)&&(c>a))
       {
           mayor=c;
           menor1=b;
           menor2=a;
        }else if ((b>c)&&(b>a))
            {
                mayor=b;
                menor1=c;
                menor2=a;
            }else if ((a>c)&&(a>b))
            {
                mayor=a;
                menor1=c;
                menor2=b;
            }               
       
       boolean pitagoras=((mayor*mayor)==(menor1*menor1)+(menor2*menor2));
       boolean equilatero=((a==b)&&(b==c));
       boolean isosceles=( ( (a==b) && (b!=c) || ( (b==c) && (b!=a) || ( (a==c) && (a!=b) ) ) ) ) ;
       
       if ((a+b>c) && (a+c>b) && (b+c>a))
       {
           if (equilatero)
           {
               System.out.println ( "Es un triangulo: equilatero");
           }
           else  if (isosceles)
                {
                System.out.println ("Es un triangulo: isosceles");
                }
                else if (pitagoras)
                        {
                        System.out.println("Es un triangulo: rectángulo");
                        }
                        else System.out.println("Es un triangulo: escaleno");
        }
        else System.out.println ("Es un triangulo: imposible");
   }
}
