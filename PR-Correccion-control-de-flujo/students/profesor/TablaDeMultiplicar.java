/**

  Desarrolla un programa que imprima las tablas de multiplicar de los números del 1 al 10.
  Si el usuario solicita la tabla de un número fuera de rango (entre 1 y 10), se indicará Fuera de rango

  @author Nombres de los autores
 */
public class TablaDeMultiplicar{
	public static void main( String[] args ){
		for( int i = 1 ; i <= 10 ; i++ ){
			System.out.println( "3 x " + i + " = " + (3*i) );
		}
	}
}
