/**
 *  Entre semana suelo colocar el despertador a las 7:30.
  El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
  el despertador no suena.
  Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
  que programar el despertador. La salida será una línea con la horas a las que sonará el
  despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.
 * 
 * @author Carolina de Pascual Jimenez

 */
import java.util.Scanner;
public class Despertador{
    public static void main (String [] args){
     Scanner in = new Scanner( System.in);
     System.out.println ( "Bienvenido al programador de despertadores" );
    
     System.out.println( "¿Que dia de la semana es hoy?" );
     int DiaSemana = Integer.parseInt( in.nextLine() );
    
     System.out.println( "¿Cuantos dias debo programar el despertador?" );
     int DiasProgramar = Integer.parseInt( in.nextLine());
     
     
    
     for (int contador=0; contador < DiasProgramar; contador++){
         int d = (DiaSemana+contador)%7+1;
         switch (d){
           case 1: System.out.print( " 7:30 " ); break;
           case 2: System.out.print( " 7:30 " ); break;
           case 3: System.out.print( " 7:30 " ); break;
           case 4: System.out.print( " 7:30 "  ); break;
           case 5: System.out.print( " 7:30 " ); break;
           case 6: System.out.print( " 10:30 " ); break;
           case 7: System.out.print( " OFF " ); break;
           default: System.out.print( " Imprimir error " );                              
      }
   }  
 }  
}
