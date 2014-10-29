/**
 * Ejercicio para calcular la media de varios numeros introducidos.
 * 
 * @author Pawel Bartnik
 */
import java.util.Scanner;
public class Media {

   public static void main( String[] args ) {
       Scanner in = new Scanner( System.in);
            double n = 0;
      
       System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?:");
            n = Integer.parseInt( in.nextLine() );
            double valor = 0;
            int contador = 0;
            double suma = 0;
          while( contador < n ){
           System.out.println( "Numero " + (contador + 1) + ":"  );
           
             valor = Double.parseDouble( in.nextLine() );
           
           suma = suma + valor;
           contador = contador +1;
           
          }
    
            double media = suma / contador;
    
       System.out.println( + media );

    }
}