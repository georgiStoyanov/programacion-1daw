
/**
 *Se desea clasificar cada triángulo según sus características. 
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

    
@author Jhon Alexander Marín Estrada / Leticia Verdes Montenegro Díaz 
 */

import java.util.Scanner;


public class ClasificaTriangulo
{
    public static void main( String[] args ){
                
            Scanner in = new Scanner( System.in );
            
            System.out.println("Este programa clasifica triangulos.");
            
            // Pedir el lado 1
            System.out.println("Longitud del primer lado:");
            int LadoA =  Integer.parseInt(in.nextLine());
        
            // Pedir el lado 2 
            System.out.println("Longitud del segundo lado:");
            int LadoB =  Integer.parseInt(in.nextLine());
            
            // Pedir el lado 3
            System.out.println("Longitud del tercero lado:");
            int LadoC =  Integer.parseInt(in.nextLine());
            
            
                     //triangulo imposible
           boolean ImposibleA = LadoA > LadoB + LadoC;
           boolean ImposibleB = LadoB > LadoA + LadoC;
           boolean ImposibleC = LadoC > LadoB + LadoA;
           boolean Imposible = ImposibleA || ImposibleB || ImposibleC;
           
                        //equilatero
           boolean Equilatero = LadoA == LadoB && LadoB == LadoC;
            
           
                        //isoceles
           boolean IsocelesAB = LadoA == LadoB;
           boolean IsocelesBC = LadoB == LadoC;
           boolean IsocelesCA = LadoC == LadoA;
           boolean Isoceles =  !Imposible && (IsocelesAB ^ IsocelesBC ^ IsocelesCA);
    
           
                        //rectangulos
           boolean RectanguloA = LadoA * LadoA == (LadoB * LadoB) + (LadoC * LadoC);
           boolean RectanguloB = LadoB * LadoB == (LadoA * LadoA) + (LadoC * LadoC);
           boolean RectanguloC = LadoC * LadoC == (LadoB * LadoB) + (LadoA * LadoA);
           boolean Rectangulo = ( RectanguloA || RectanguloB || RectanguloC );
           
           

           
                       //escaleno
          boolean Escaleno = !Isoceles && !Rectangulo && !Imposible && !Equilatero;

          
          //saco el resultado
            if( Equilatero ){
            
                System.out.println("es un triangulo: Equilatero ");
           
                
            }else if( Isoceles ){
            
                System.out.println("es un triangulo:  Isosceles ");
                
            }else if( Rectangulo ){
            
                System.out.println("es un triangulo: Rectangulo ");
                
            }else if( Escaleno ){
            
                System.out.println("es un triangulo:  Escaleno ");
                
            }else{
            
                System.out.println("es un triangulo:  Imposible ");
                
            }
               
    }
}