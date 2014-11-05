package grades;
/**
 * Se desea clasificar cada triángulo según sus características. Por orden de
 * importancia, nos interesan los triángulos: - Equiláteros - Isósceles -
 * Rectángulos - Escalenos - Y por último, los triángulos imposibles
 * 
 * Cuando un triángulo es de cierto tipo, ya no se comprueba si pertenece a un
 * tipo posterior.
 * 
 * Desarrolla un programa Java que pregunte por la longitud del primer, segundo
 * y tercer lado de un triángulo, y lo clasifique según el criterio anterior. Se
 * supondrá que las longitudes de los lados son números enteros.
 * 
 * @author Nombres de los autores
 */

import java.util.Scanner;
public class ClasificaTriangulo
{
  public static void main(String [] args ){
      System.out.println("Este programa clasifica triangulos.");
      System.out.println("Longitud del primer lado:");
       int h=0;
                       int a=0;
                       int c=0; 
      Scanner in = new Scanner( System.in );
      int primerlado = Integer.parseInt(in.nextLine());
      System.out.println("Longitud del segundo lado:");
      
      in = new Scanner( System.in );
      int segundolado = Integer.parseInt(in.nextLine());
      
      System.out.println("Longitud del tercer lado:");
      
      in = new Scanner( System.in );
      int tercerlado = Integer.parseInt(in.nextLine());
      
       if ((primerlado == segundolado) && (primerlado==tercerlado) ){ 
                System.out.println( "Es un triangulo: Equilatero" );}
            
          else if ((primerlado == segundolado)|| (primerlado == tercerlado) || (segundolado == tercerlado) || (segundolado == primerlado) || (tercerlado == primerlado) || (tercerlado == segundolado)){ 
                System.out.println( "Es un triangulo: Isosceles" );}
           
              else if((primerlado != segundolado) && (segundolado !=tercerlado) && (tercerlado != primerlado)){
               if(primerlado > segundolado){
                   if (primerlado > tercerlado){
                       h = primerlado;
                       a = segundolado;
                       c = tercerlado;
                    }
                       else {
                        h = tercerlado;
                        a = segundolado;
                        c = primerlado;}}
                    
                  else if(segundolado > tercerlado){
                    h = segundolado;
                    a = primerlado;
                    c = tercerlado;}
                     else{
                       h = tercerlado;
                       a = segundolado;
                       c = primerlado; }
                    
                       if ((h*h)==( c*c ) +(a*a)){
                         System.out.println( "Es un triangulo: rectangulo" );
                       }  
                       else if(a+c>h){
                         System.out.println( "Es un triangualo: escaleno" );
                       }
                     else  {
                       System.out.println( "Es un triangulo imposible ");
                }
                }
               
            }
            
                      
                        
                 
       }
      

      


