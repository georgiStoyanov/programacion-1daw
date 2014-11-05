/**
 * Programa para clasificar triangulos.
 * 
 * @author Pawel Bartnik 
 * @version 
 */
import java.util.Scanner;
public class ClasificaTriangulo {

     public static void main(String[] args) {
        System.out.println("Este programa clasifica triangulos.");
        Scanner in = new Scanner (System.in);
        int a,b,c;
        System.out.println("Longitud del primer lado:");
        a = Integer.parseInt( in.nextLine() );
        System.out.println("Longitud del segundo lado:");
        b = Integer.parseInt( in.nextLine() );
        System.out.println("Longitud del tercer lado:");
        c = Integer.parseInt( in.nextLine() );
        if( (a+b)<=c || (a+c)<=b || (b+c)<=a ) // formula para saber si es imposible
                System.out.println("Es un triangulo:Imposible ");
        
              else{
              
                    if(a==b && b==c)
                      System.out.println("Es un triangulo: Equilatero");
        
                     else{ 
            
                        if(a==b  || a==c  || b==c)
                          System.out.println("Es un triangulo: Isosceles");
            
                         else{
            
                            if((a*a+b*b==c*c) ||(a*a+c*c==b*b) || (b*b+c*c==a*a))
               
                              System.out.println("Es un triangulo: Rectangulo");
                             else{ 
            
                               if(a!=b  || a!=c  || b!=c)
        
                                  System.out.println("Es un triangulo: Escaleno");
            
            
            
                 
                                }
        
                        }

                    }  
                }
   }
}