
/**
 * Se necesita calcular la media de un conjunto de números reales.
 * El programa comenzará preguntando por la cantidad de números que
 * forman parte de la media.
 * Esta cantidad se supondrá entera y no negativa.
 * Después preguntará por todos esos números (indicando su orden), y
 * finalizará mostrando la media de los mismos.
 * 
 * @author Adrián Marcos Zarabozo González
 */
import java.util.Scanner;
public class Media
{   public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        
        System.out.println("Bienvenido al calculador de medias. Cuantos numeros forman parte de la media? ");
        int numerosMedia= Integer.parseInt( in.nextLine() );
        
        int contador = 0;
        double suma = 0; //Esta es la variable que sumará los números introducidos.
        double media = 0; //Esta es la variable que se usará para enseñar el resultado final.
        double numeroIntroducido = 0;
        
        while( numerosMedia > 0){
            System.out.println( "Numero " + (contador +1) + ": ");
            numeroIntroducido = Double.parseDouble( in.nextLine() );
            
            suma = suma + numeroIntroducido;
            numerosMedia= numerosMedia - 1;
            contador = contador + 1;
        }
        media= suma/contador;
        System.out.println( media );
    }
}
