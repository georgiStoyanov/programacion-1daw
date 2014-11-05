
/**
 * Se necesita calcular la media de un conjunto de números reales. El programa comenzará preguntando por la cantidad de
 * números que forman parte de la media.
 * Esta cantida se supondrá entera y no negativa.
 * Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.
 * 
 * @author (Andrés Arrojo) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Media
{   public static void main( String[] args){
    
        Scanner in = new Scanner( System.in );

        System.out.println( "Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?" );
        int total = in.nextInt();
        
        double acum = 0;
        
        for( int i = 0 ; i < total ; i++ ) {
            
            System.out.println( "Numero " + ( i + 1 ) + " : ");
            acum += in.nextDouble();
        }
        
        System.out.println( acum / total );
    }
}
