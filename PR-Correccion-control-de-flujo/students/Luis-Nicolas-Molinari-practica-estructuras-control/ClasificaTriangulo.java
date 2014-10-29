
/**
 * Write a dSystem.out.println("ription of class ClasificaTriangulo here.
 * 
 * @author (Luis Nicolas Molinari) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ClasificaTriangulo
{
    public static void main (String args[])
    {
    
    Scanner in = new Scanner(System.in);
    
    int ladoA,ladoB,ladoC; 
    boolean isosceles , equilatero , rectangulo , escaleno , triangulo , imposible ;
    
    System.out.println("Este programa clasifica triangulos." );
    System.out.println("Longitud del primer lado:");
    ladoA= in.nextInt();
    System.out.println("Longitud del segundo lado:");
    ladoB= in.nextInt();
    System.out.println("Longitud del tercer lado:");
    ladoC= in.nextInt();
    
    
    isosceles= ((ladoA==ladoB)&&(ladoA!=ladoC))||((ladoB==ladoC)&&(ladoB!=ladoA))||((ladoC==ladoA)&&(ladoC!=ladoB));
    equilatero= (ladoA==ladoB)&&(ladoC==ladoB);
    rectangulo= ( (ladoC*ladoC)==((ladoA*ladoA)+(ladoB*ladoB)))||( (ladoA*ladoA)==((ladoB*ladoB)+(ladoC*ladoC)))||( (ladoB*ladoB)==((ladoC*ladoC)+(ladoA*ladoA)));
    escaleno=   ((ladoA!=ladoB)&&(ladoA!=ladoC)&&(ladoB!=ladoC));
    triangulo= (ladoA<(ladoB+ladoC))&&(ladoB<(ladoA+ladoC))&&(ladoC<(ladoA+ladoB));
    imposible = (!triangulo);  
    
         if(triangulo){ 
                   if (isosceles)
                   {
                       System.out.println("Es un triangulo: isosceles ");
                    }
                    else if (equilatero)
                    {
                       System.out.println("Es un triangulo: equilatero ");
                    } 
                    else if (rectangulo&&!isosceles&&!equilatero)
                    {
                        System.out.println("Es un triangulo: rectangulo ");
                    }
                    else if (escaleno&&!rectangulo)
                    {
                        System.out.println("Es un triangulo: escaleno ");
                    } 
                }
         if (imposible) {
              
                  System.out.println("Es un triangulo: imposible ");
                } 
            
        }
    }
