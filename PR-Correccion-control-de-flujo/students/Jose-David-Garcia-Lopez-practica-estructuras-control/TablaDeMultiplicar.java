
/**

  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Jose David García López
 */
import java.util.Scanner;

public class TablaDeMultiplicar{
	public static void main( String[] args ){
	    Scanner in = new Scanner(System.in);
     
      System.out.println( "Tabla de multiplicar para el numero: " );
      //System.out.println( "Insertar un numero:" );
      
       //Variables
      int n= Integer.parseInt (in.nextLine() );
     
      if ((n<=10)&&(n>0)){  
          for( int c=1; c<= 10; c++ ){
           System.out.println(n + "x" + c + "=" + n*c); 
        }
       }
        else{
      System.out.println( "fuera de rango" );
    }
  }  
}


