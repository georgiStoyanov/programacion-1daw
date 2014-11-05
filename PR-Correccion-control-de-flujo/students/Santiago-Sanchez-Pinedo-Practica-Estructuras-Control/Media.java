
/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Santiago Sánchez
*/
import java.util.Scanner;
public class Media{
    public static void main( String[] args ){


        Scanner in = new Scanner( System.in);
        Double numerosum = 0.0;
        Double media = 0.0;
        Double numero2 = 0.0;
        int d ;
        Double m1 = 0.0;
        System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
        int y = Integer.parseInt( in.nextLine () );
                              
                for ( d = 1 ; d<=y ; d++ ){  
                    
                    System.out.println(" Numero " + d);
                    Double numero = Double.parseDouble( in.nextLine () );
                    if ( d < y ) {
                        numero2 = numero + numerosum;
                        numerosum = numero2;
                    }
                    
                    if ( d == y ) {
                        numero2 = numero + numerosum;
                        m1 = numero2 ;                 
                        media = (m1 / y);
                        System.out.println( media ); 
                    }
                    
                    
                    
                }   
    }
}

