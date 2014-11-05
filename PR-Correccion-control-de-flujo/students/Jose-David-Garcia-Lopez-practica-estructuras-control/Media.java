/**
  Se necesita calcular la media de un conjunto de números reales.
  El programa comenzará preguntando por la cantidad de números que forman parte de la media. 
  Esta cantidad se supondrá entera y no negativa.
  Después preguntará por todos esos números (indicando su orden), y finalizará mostrando la media de los mismos.

  @author Jose David García López
*/
import java.util.Scanner;

public class Media{
	public static void main( String[] args ){
	    
      Scanner in = new Scanner( System.in );
      //Variables
      double numero=0;
      double suma=0;
      int contador=1;
      double media=0;
      int total=0;
      
      System.out.print("Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media? ");
      total=Integer.parseInt(in.nextLine());
     
      while (contador <= total){
          
          contador++;
           
          System.out.println("Introduzca otro numero: ");
          numero=Double.parseDouble (in.nextLine() );
       
          suma=suma+numero;
      }
          media= suma/total;
          System.out.println("La media es: " + media);
  }
}
