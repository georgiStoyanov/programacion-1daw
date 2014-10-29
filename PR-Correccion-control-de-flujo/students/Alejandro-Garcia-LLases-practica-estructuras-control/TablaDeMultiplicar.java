
/**
 * Write a description of class TablaDeMultiplicar here.
 * 
 * @author (Alejandro Garcia LLases) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class TablaDeMultiplicar
{
    public static void main( String [] args ){
        
        
        
        System.out.println( "Tabla de multiplicar para el numero:" ) ;
        Scanner in = new Scanner( System.in );
        int numero = Integer.parseInt(in.nextLine());
        
       
        //compruebo si esta fuera de rango
        if ( (numero >10) || (numero <1) ){
            System.out.println( "Numero fuera de rango" );
        }
        else{
            
        for (int factor= 1;factor <=10; factor= factor+1){
            
            int resultado = (numero * factor);
            System.out.println( +numero+(" X ")+ factor+ (" = ") +resultado);
        }
    }
}
}
