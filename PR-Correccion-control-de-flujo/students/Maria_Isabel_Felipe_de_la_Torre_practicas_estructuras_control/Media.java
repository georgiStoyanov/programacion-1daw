
/**
Se necesita calcular la media de un conjunto de números reales.
El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
Esta cantidad se supondrá entera y no negativa.
Después preguntará por todos esos números (indicando su orden), 
y finalizará mostrando la media de los mismos.
@author Maria Isabel Felipe de la Torre
*/
import java.util.Scanner;
public class Media{
    public static void main( String[] args    ){

        System.out.println( "Bienvenido al calculador de medias. ¿Cuantos números formaran parte de la media?");
        Scanner in = new Scanner(System.in);
        
        int cuantosNumeros = Integer.parseInt (in.nextLine() );
        double suma = 0;  
        
 
        for (int contador = 1; contador <= cuantosNumeros; contador = contador + 1) {
            
            System.out.println( "Número " + contador + ":" );
            double numeroIntroducido = Double.parseDouble( in.nextLine() );

            suma = suma + numeroIntroducido;
            

        }
        
        double media = suma / cuantosNumeros;
        System.out.println( "La media es:" + media );
        
        if( cuantosNumeros == 0 ){
            System.out.println( "No puedo hacer la media sin valores" ); 
        }
      
    }
}
