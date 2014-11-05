
/**
 * Entre semana suelo colocar el despertador a las 7:30.
 * El sábado el despertador suena a las 10:30, para poder dedicar
 * tiempo al estudio.
 * Los domingos el despertador no suena.
 * Desarrolla un programa que pregunte en qué día de la semana estamos,
 * y cuantos días hay que programar el despertador. La salida será una línea 
 * con las horas a las que sonará el despertador los próximos días (sin incluir el actual),
 * u OFF si ese día no suena.
 * 
 * @author Adrián Marcos Zarabozo Gonzalez.
 */
import java.util.Scanner;
public class Despertador
{   public static void main (String [] args)
       {
        Scanner in = new Scanner (System.in);
        
        System.out.println("Bienvenido al programa de despertadores");
        
        System.out.println("Que dia de la semana es hoy? ");
        int dia = Integer.parseInt (in.nextLine() ); 
        
        System.out.println("Cuantos dias debo programar el despertador? ");
        int despertador = Integer.parseInt (in.nextLine() );
        
        for (int contador = dia + 1; contador <= dia + despertador; contador = contador + 1 ){                
                if (contador % 7 == 6){
                    System.out.print("10:30 ");
                }
                else if ( contador  % 7 == 0){
                    System.out.print("OFF ");
                }
                else{
                    System.out.print( "7:30 ");
                }                
        }
    }
}
