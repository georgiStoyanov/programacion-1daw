
/**
 * Programa que genera la tabla de multiplicar de un número comprendido en el rango 1 a 10
 * 
 * @author Iván Hernanz Pérez
 * @version 25-oct-2014
 */

import java.util.Scanner;

public class TablaDeMultiplicar
{
    public static void main( String[] args ){        
        Scanner in = new Scanner( System.in );
        
        //Variables
        int contador;
        int numero;
        int resultado;
        
        //Pedir el número        
        System.out.println( "Tabla de multiplicar para el número: " );
        numero = Integer.parseInt( in.nextLine() );
        
        //Programa
        if( (numero >=1) && (numero <=10)){
            for (contador = 1; contador <= 10 ; contador = contador + 1 ){               
                resultado = numero * contador;
                System.out.println( numero + " x " + contador + " = " + resultado );       
            }
        }
        else{
        System.out.println( " fuera rango " );       
        }
    }
}
