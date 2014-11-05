/**

  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Rosa De Lope Calatayud
 */
import java.util.Scanner;
public class TablaDeMultiplicar{
    public static void main( String[] args ){
        Scanner in = new Scanner( System.in );
        
        System.out.println( "Tabla de multiplicar para el numero:");
        int numero = Integer.parseInt( in.nextLine() );
        
        System.out.println( " ");
       
        if( (numero>10 || (numero<=0))) {
               System.out.println( "Fuera de rango" );
            }
        
        else for( int contador = 1; contador <= 10 ; contador = contador + 1){
            if( numero<=10){
            System.out.println( numero + "x" + contador + "=" + (numero*contador));
            }
           }
 
        }            
    }      
	    