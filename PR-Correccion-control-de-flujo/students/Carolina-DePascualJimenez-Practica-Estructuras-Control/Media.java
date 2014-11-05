/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Carolina de Pascual Jimenez
*/
import java.util.Scanner;
public class Media{
	public static void main( String[] args ){
	    Scanner in = new Scanner( System.in);
	    System.out.println( "Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?" );
	    int NumeroDeValores = Integer.parseInt( in.nextLine());
	    
	    double Suma = 0;
	    
	    for ( int i=1; i<=NumeroDeValores; i=i+1){	                
	        System.out.println( "Numero" + i + ":" );
	        double Valor = Double.parseDouble( in.nextLine());	
	        Suma = Suma + Valor;	        	    	    	    	 
      }
      
      double Media = Suma / NumeroDeValores;
      System.out.println( +Media) ;
    }
}
