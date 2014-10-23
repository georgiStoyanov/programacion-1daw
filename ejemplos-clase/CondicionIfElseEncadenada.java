
/**
 * Write a description of class CondicionIfElseEncadenada here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 import java.util.Scanner;
public class CondicionIfElseEncadenada
{

   public static void main(String args[] ){
       Scanner in = new Scanner( System.in );
       int dia = Integer.parseInt( in.nextLine() );
       
       
       if( dia == 1 ){
           System.out.println( "Lunes" );
       }
       else if( dia == 2 ){
           System.out.println( "Martes" );
       }
       else if( dia == 3 ){
           System.out.println( "Miércoles" );
       }
       else{
           System.out.println( "Ya es muy tarde" );
       }
   }
}
