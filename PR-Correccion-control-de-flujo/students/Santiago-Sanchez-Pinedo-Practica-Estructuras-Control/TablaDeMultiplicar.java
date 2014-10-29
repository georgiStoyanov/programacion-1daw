
/**
 * @author Santiago Sánchez Pinedo
 */
import java.util.Scanner;
public class TablaDeMultiplicar
{
    public static void main(String[] args ){
        Scanner in = new Scanner ( System.in);
        System.out.println ( "Tabla de multiplicar para el numero:");
        int num = Integer.parseInt (in.nextLine () );
        
        if ( num >= 1 && num <= 10 ) {
            System.out.println ( "La tabla de multiplicar del " + num + " es:");
            
            System.out.println ( num + " x 1 = " + num * 1 );
            System.out.println ( num + " x 2 = " + num * 2 );
            System.out.println ( num + " x 3 = " + num * 3 );
            System.out.println ( num + " x 4 = " + num * 4 );
            System.out.println ( num + " x 5 = " + num * 5 );
            System.out.println ( num + " x 6 = " + num * 6 );
            System.out.println ( num + " x 7 = " + num * 7 );
            System.out.println ( num + " x 8 = " + num * 8 );
            System.out.println ( num + " x 9 = " + num * 9 );
            System.out.println ( num + " x 10 = " + num * 10 );
        }
        else {
            System.out.println ( " Fuera de rango " ) ;
        }
    }
}
