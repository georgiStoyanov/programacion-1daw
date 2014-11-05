
/**
  Entre semana suelo colocar el despertador a las 7:30.
  El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
  el despertador no suena.
  Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
  que programar el despertador. La salida será una línea con la horas a las que sonará el
  despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.

  @author Jonathan Pichel.
 */
import java.util.Scanner;
public class Despertador {
    public static void main(String[] args) {
       Scanner in = new Scanner( System.in );
       System.out.println( "Bienvenido al programador de despertadores" );
       System.out.println( "Que dia de la semana es hoy:" );
       int dia = Integer.parseInt ( in.nextLine());
       System.out.println( "Cuantos dias debo programar el destertador:" );
       int programa = Integer.parseInt ( in.nextLine());
       
       int y = 0;
       
       for (  int c = (dia + 1) ; c <= (dia + programa) ; c++){
            
            if ( c >= ( 1 + 7 * y ) && c <= ( 5 + 7 * y ) ){
                System.out.print( " 07:30 " );
            }
            if ( c == ( 6 + 7 * y )){
                System.out.print( " 10:30 " );
            }
            if ( c == ( 7 + 7 * y )){
                System.out.print( " OFF " );
            }
            if (c == ( 8 + 7 * y )){
                System.out.print( " 07:30 " );
                y = y + 1;
            }
     
       }
      
    }
}

    

