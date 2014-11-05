/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Rosa De Lope Calatayud
*/
import java.util.Scanner;
public class Media{
	public static void main( String[] args ){
	    Scanner in = new Scanner( System.in );
	    
	    System.out.println("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?");
	    int cantidadnumeros = Integer.parseInt( in.nextLine() );
	    
	    double suma = 0;
	    
	    for( int contador = 1; contador <= cantidadnumeros ; contador = contador + 1){
	        
	        System.out.println("Numero" + contador);
	        double valor = Double.parseDouble( in.nextLine() );
	        
	        
	        suma = suma + valor;
	       }
 
	    double media = suma / cantidadnumeros;
	    System.out.println("La media es: " + media);  
	}
}
