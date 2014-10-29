
/**
 * Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

 *
 * 
 * @author (Enrique González ) 

 */
import java.util.Scanner;
public class TablaDeMultiplicar
{
    public static void main (String [] args ){
        Scanner in = new Scanner ( System.in);
        System.out.println ( "Tabla de multiplicar para el numero:");
        int numero = Integer.parseInt (in.nextLine () );
        
        if ( numero >= 1 && numero <= 10 ) {
            System.out.println ( "La tabla de multiplicar del " + numero + " es:");
            
            System.out.println ( numero + " x 1 = " + numero * 1 );
            System.out.println ( numero + " x 2 = " + numero * 2 );
            System.out.println ( numero + " x 3 = " + numero * 3 );
            System.out.println ( numero + " x 4 = " + numero * 4 );
            System.out.println ( numero + " x 5 = " + numero * 5 );
            System.out.println ( numero + " x 6 = " + numero * 6 );
            System.out.println ( numero + " x 7 = " + numero * 7 );
            System.out.println ( numero + " x 8 = " + numero * 8 );
            System.out.println ( numero + " x 9 = " + numero * 9 );
            System.out.println ( numero + " x 10 = " + numero * 10 );
        }
           else {
               
               System.out.println ( " fuera de rango " ) ;
            
        }
}
}
