
/**
 * Write a description of class ElMayorDeDiez here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class ElMayorDeDiez
{
    public static void main( String[] args ){
        System.out.println( "Programa que calcula el mayor de 10 numeros" );
        Scanner in = new Scanner( System.in );

        int mayor = Integer.MIN_VALUE;
        int contador = 0;

        while( contador < 10 ){
            System.out.println( "dato " + (contador + 1) + ":"  );
            int numero = Integer.parseInt( in.nextLine() );
            if( numero > mayor ){
                mayor = numero;
            }

            
            contador = contador + 1;
        }

        System.out.println( "El mayor de todos es:" + mayor );
    }
}
