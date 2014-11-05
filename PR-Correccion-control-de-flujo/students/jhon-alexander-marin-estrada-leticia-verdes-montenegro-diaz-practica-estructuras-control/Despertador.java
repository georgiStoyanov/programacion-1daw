
/**
 *Entre semana suelo colocar el despertador a las 7:30.
  El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
  el despertador no suena.
  Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
  que programar el despertador. La salida será una línea con la horas a las que sonará el
  despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.

  @author Jhon Alexander Marín Estrada / Leticia Verdes Montenegro Díaz
 */



import java.util.Scanner;

public class Despertador
{
    public static void main(String[] args){
    
        Scanner in = new Scanner(System.in);
         
        System.out.println("Bienvenido al programa de despertador: ");
        
        
        //PIDO DIA ACTUAL
        System.out.println("Que dia de la semana es hoy?: ");
        int DiaHoy = Integer.parseInt(in.nextLine());
        
        //PIDO LOS DIAS EN LOS QUE SE DEBE PROGRAMAR EL DESPERTADOR
        System.out.println("Cuantos dias debo programar el despertador?: ");
        int DiasDespertador = Integer.parseInt(in.nextLine());
        
        int DiaSemana;
        
        //BUCLE PARA REALIZAR EL RECORRIDO DEL LA SEMANA
        for (int contador = DiaHoy; contador < DiasDespertador + DiaHoy ; contador ++){
        
            
           DiaSemana = contador% 7;
                   
                   
            switch( DiaSemana ){
        
                case 0: System.out.print ( "7:30 \t" );
                break;      
                case 1: System.out.print ( "7:30 \t" );
                break;            
                case 2: System.out.print ( "7:30 \t" );
                break;            
                case 3: System.out.print ( "7:30 \t" );
                break;            
                case 4: System.out.print ( "7:30 \t" );
                break;            
                case 5: System.out.print ( "10:30 \t" );
                break;
                case 6: System.out.print ( "OFF \t" );
                break;
                
                default:
                    System.out.println( "Ya es muy tarde" );
            }
            
        
        }

        
    }
  }
