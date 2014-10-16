
/**
 * Write a description of class CondicionSwitch here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class CondicionSwitch{

   public static void main(String args[] ){
       Scanner in = new Scanner( System.in );
       int dia = Integer.parseInt( in.nextLine() );
       
       switch( dia ){
           case 1: 
                System.out.println( "Lunes" ); 
                break;
           case 4: 
                System.out.println( "Jueves" ); 
                break;
           case 2: 
                System.out.println( "Martes" ); 
                break;
           case 5:
                System.out.println( "Viernes" ); 
                break;
           case 3:
                System.out.println( "Miércoles" ); 
                break;
           default: 
                System.out.println( "Ya es muy tarde" );
       }
       
 
   }
}
