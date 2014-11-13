
/**
 * Write a description of class Capitalizar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitalizar
{
    public static void main( String args[] ){

        System.out.println( "______________________________" );

        String nombre = new java.util.Scanner(System.in).nextLine();
        
        
        String inicial = nombre.substring(0, 1);
        String resto = nombre.substring(1);
        
        System.out.printf( "%s -- %s : %s\n", nombre, inicial, resto ); 
        
        inicial = inicial.toUpperCase();
        resto = resto.toLowerCase();
        
        System.out.printf( "%s%s\n", inicial, resto ); 
        

    
    }
}
