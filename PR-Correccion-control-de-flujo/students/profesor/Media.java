import java.util.Scanner;

/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Nombres de los autores
*/
public class Media{
	public static void main( String[] args ){
		   System.out.println( "Calculo la media" );
		   System.out.println( "Cuantos valores?:" );
	        Scanner in = new Scanner(System.in);
	        double numeroIntroducido = 0;
	        
	        int contador = Integer.parseInt( in.nextLine() );
	        double suma = 0;

	        
	        for( int c = 0 ; c < contador ; c++ ){
	            System.out.println( "Valor "  + (c+1) + ":" );
	            numeroIntroducido = Double.parseDouble( in.nextLine() );
	            suma = suma + numeroIntroducido;
	        }

	        if( contador == 0 ){
	            System.out.println( "No puedo hacer la media sin valores" ); 
	        }
	        else{
	            double media = suma / contador;
	            System.out.println( "La media es:" +media ); 
	        }
	}
}