/**
 * Programa que genera la media
 * 
 * @author Iván Hernanz Pérez
 * @version 26-oct-2014
 */

import java.util.Scanner;
public class Media
{
    static double suma = 0;            
    public static void main( String[] args ){        
        Scanner in = new Scanner( System.in );
        
        System.out.println( " ¿Cuantos números formarán parte de la media?: " );
        double total = Double.parseDouble( in.nextLine() );
               
        for( int x = 1; x <= total; x ++ ){
            if(suma == 0){
                System.out.println( " Número " + x );
                suma = Double.parseDouble( in.nextLine() );           
            }
            else {
                System.out.println( " Número " + x );
                suma = suma + Double.parseDouble( in.nextLine() );
            }
        }        
        
        double media = suma / total;
        System.out.println( "La media es: " + media );        
    }
}