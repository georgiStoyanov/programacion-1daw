
/**
 * Write a description of class MediaHastaCero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class MediaHastaCero
{
    public static void main( String[] args ){

        System.out.println( "Calculo la media hasta que se introduzca un cero" );
        Scanner in = new Scanner(System.in);
        double numeroIntroducido = 0;
        int contador = -1;
        double suma = 0;

        // MIENTRAS QUE NO SEA CERO EL NUMERO INTRODUCIDO
        while( numeroIntroducido != 0 || contador == -1 ){
            System.out.println( "Valor "  + (contador+2) + ":" );
            numeroIntroducido = Double.parseDouble( in.nextLine() );

            suma = suma + numeroIntroducido;
            contador = contador + 1;
            //System.out.println( "    Llevo " + contador + " valores con una suma de " + suma );

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
