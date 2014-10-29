
/**
 * Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.
 
 * @author (Enrique González) 
 
 */
import java.util.Scanner;
public class Media
{
    public static void main ( String [] args ){
        Scanner in = new Scanner ( System.in);
        System.out.println( " Bienvenido al calculador de medias.Cuantos numeros formaran parte de la media?");
        int a= Integer.parseInt (in.nextLine());
        int b;
        int c;
        double suma = 0.0;
        for (c=1; c <= a ;c++ ){
                
                System.out.println(" Numero "+ c );
                Double numero = Double.parseDouble( in.nextLine ());
                if ( c < a ){
                Double suma2 = suma + numero ;
                suma = suma2;
                //System.out.println ( suma2 );
                }
                else{
                Double suma2 = suma + numero ;
                suma = suma2;
                double media = suma2 / a ;
                System.out.println( media );
                }
                
                
                      
                
        }
        
    }
}
