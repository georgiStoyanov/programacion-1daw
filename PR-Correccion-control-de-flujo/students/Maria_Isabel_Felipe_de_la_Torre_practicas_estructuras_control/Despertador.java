
/**
Entre semana suelo colocar el despertador a las 7:30.
El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
el despertador no suena.
Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
que programar el despertador. La salida será una línea con la horas a las que sonará el
despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.

@author Maria Isabel Felipe de la Torre
*/

import java.util.Scanner;
public class Despertador{
    public static void main( String[] args ){
        System.out.println ( "Bienvenido al programador de despertadores" );
        System.out.println ( "¿Que dia de la semana es hoy?" );
        Scanner in = new Scanner( System.in );
        int diaSemana = Integer.parseInt (in.nextLine ());
        
        System.out.println ( "¿Cuantos días debo programar el despertador?");
        int diasQuePasan = Integer.parseInt (in.nextLine ());
        
        
        for (int contador = 0; contador < diasQuePasan; contador = contador + 1 ) {
        
        int dia = (diaSemana + contador) % 7 + 1;
        
        switch ( dia ){
            case 1 :
                System.out.println ("- 7:30 -");
                break;
                
            case 2 : 
                System.out.println ("- 7:30 -");
                break;                                      
                
            case 3 :      
                System.out.println ("- 7:30 -");
                break;               
                
            case 4 :
                System.out.println ("- 7:30 -");
                break;
                
            case 5 :
                System.out.println ("- 7:30 -");
                break;
                
            case 6 :
                System.out.println ("- 10:00 -");  
                break;
                               
            case 7 :
                System.out.println ("- OFF -");
                break;
        }
    }
   }
}

