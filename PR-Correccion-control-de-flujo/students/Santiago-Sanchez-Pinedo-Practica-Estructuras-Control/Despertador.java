
/**
 *  * @author (Santiago Sánchez) 
 * Aula 31
 */
import java.util.Scanner;
public class Despertador{
     public static void main (String[] argumentos){
         int diasem;
         int diasdesp;
         int i;
         String despert = "No";
         
         System.out.println ("Escribe el día de la semana");
         Scanner in = new Scanner( System.in );   
         diasem = Integer.parseInt(in.next());
         System.out.println ("Escribe nº días después");
         diasdesp = Integer.parseInt(in.next());
                
         
         for( i =diasem+1;i<= (diasdesp + diasem);i++){
                            
             if( i % 7 == 0)
                System.out.print( "OFF -");
             else if( i %7== 6)
                System.out.print( "10:30 -");
             else{
                 System.out.print( "7:30 -") ; 
                }
             
              }
           
        }
          
  }

