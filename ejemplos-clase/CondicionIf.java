
/**
 * Write a description of class CondicionIf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class CondicionIf
{
   public static void main(String args[] ){
       Scanner in = new Scanner( System.in );
       int numero = Integer.parseInt( in.nextLine() );
       
       boolean esPar = numero % 2 == 0;
       if( esPar ){
           System.out.println( "El número " + numero + " es par" );
       }
       else{
           System.out.println( "El número " + numero + " es impar" );
       }
   }
}
