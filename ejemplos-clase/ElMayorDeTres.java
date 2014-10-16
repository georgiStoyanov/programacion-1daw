
/**
 * Write a description of class ElMayorDeTres here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ElMayorDeTres
{
   public static void main( String[] args ){
       Scanner in = new Scanner( System.in );
       
       System.out.println( "Primer numero:" );
       int n1 = Integer.parseInt( in.nextLine() );

       System.out.println( "Segundo numero:" );
       int n2 = Integer.parseInt( in.nextLine() );

       System.out.println( "Tercero numero:" );
       int n3 = Integer.parseInt( in.nextLine() );
       
       int mayor = -1;
       
       if( n1 > n2 ){
           if( n1 > n3 ){
               mayor =  n1;
           }
           else{
               mayor =  n3;
           }
       }
       else{
           if( n2 > n3 ){
               mayor =  n2;
           }
           else{
               mayor =  n3;
           }
       }

       System.out.println( "El mayor es:" + mayor );
       
   }
}
