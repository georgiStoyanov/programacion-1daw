
/**
 * Entre semana suelo colocar el despertador a las 7:30.
 * El sábado el despertador suena a las 10:30, para llegar a tiempo al gimnasio. 
 * Los domingos el despertador no suena.
 * Desarrolla un programa que pregunte en qué día de la semana estamos (siendo 1 el lunes y 7 el domingo), y cuantos
 * días hay que programar el despertador.
 * La salida será una línea con las horas a las que sonará el despertador los próximos días (sin incluir el actual),
 * u OFF si ese día no suena.
 * 
 * @author (Andres Arrojo) 
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Despertador
{   public static void main( String[] args ){
    
        System.out.println( "Bienvenido al programa de despertadores" );
        Scanner in = new Scanner( System.in );
    
        System.out.println( "Que dia de la semana es hoy?" );
        int numero = Integer.parseInt( in.nextLine() );
        
        System.out.println( "Cuantos dias debo programar el despertador?" );
        int programar = Integer.parseInt( in.nextLine() );
        
        for( int i = numero + 1; i <= ( programar + numero ); i = i + 1 ){
            
            if( i  % 7 == 0 ){
                System.out.print( "OFF " );
            }
            else if( i % 7 == 6 ){
                System.out.print( "10:30 " );
            }
            else{
                System.out.print( "07:30 " );
            }
        }
    }
}
