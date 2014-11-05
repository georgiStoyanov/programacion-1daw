/**

  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Jesus Salvador Barcenilla - Daniel Sanchez Lopez-Hermoso
 */
import java.util.Scanner;
public class TablaDeMultiplicar
{
	public static void main ( String [] args)
    {

        Scanner in= new Scanner (System.in);
        
        System.out.println ("Tabla de multiplicar para el numero:" );
        int numero=Integer.parseInt( in.nextLine() );
        
        if ((numero<11) && (numero>0)) //verifica que el numero este dentro de los rangos permitidos
        {
            for(int contador=1;contador<11;contador++)
            {
                int resultado=(numero*contador);
                System.out.println(+numero+" x "+contador+" = "+resultado);
            }
        }else System.out.println ("Fuera de rango"); 
    }
}
