
/**
 * Write a description of class media here.
 * 
 * @author (Alejandro Garcia Llases) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Media
{
   public static void main( String [] args ){
        
        double resultado=0;
        
        System.out.println( "Bienvenido al calculador de medias. Cuantos numeros formaran parte de la media?" ) ;
        Scanner in = new Scanner( System.in );
        int numero = Integer.parseInt(in.nextLine());
        
         for ( int j=1; j<=numero; j=j+1){
        
        System.out.println( "Numero " +j+":") ;
        //in = new Scanner( System.in );
        double med = Double.parseDouble(in.nextLine());
        resultado= med + resultado;
    }
        double solucion=resultado /numero;
        System.out.println( +solucion);
    
      
}
}
