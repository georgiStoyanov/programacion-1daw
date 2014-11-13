
/**
 * Write a description of class DarVueltaAFrase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class DarVueltaAFrase
{
    public static void main( String args[] ){
        Scanner in = new Scanner(System.in);
        System.out.println( "dime una frase para invertir:" );
        String frase = in.nextLine();
        
        String palabras[] = frase.split(" ");
        for( int i = palabras.length-1 ; i >= 0 ; i -= 1 ){
            System.out.print( palabras[i] + " " );
        }
    }
}
