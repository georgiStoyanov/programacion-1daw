
/**
  Entre semana suelo colocar el despertador a las 7:30.
  El sábado el despertador suena a las 10:30, para poder dedicar tiempo al estudio. Los domingos
  el despertador no suena.
  Desarrolla un programa que pregunte en qué día de la semana estamos, y cuantos días hay 
  que programar el despertador. La salida será una línea con la horas a las que sonará el
  despertador los próximos días (sin incluir el actual), u OFF si ese día no suena.

  @author Jose David García López
 */

import java.util.Scanner;

public class Despertador{
    static String res="";
    
	public static void main( String[] args ){
	Scanner in = new Scanner( System.in );
        //Variables
        int dia;
        int numeroDias;
        int contador;
        //Preguntas       
        System.out.println( "Que dia de la semana es hoy?  " );
        dia = Integer.parseInt( in.nextLine() );
        System.out.println( "Dias que quiera que usted quiera programar el despertador? " );
        numeroDias = Integer.parseInt( in.nextLine() );
        //casos
        if( dia <=7){
             for(contador = 1; contador <=numeroDias; contador ++){
                dia = dia +1;
                switch( dia ){
                  case 1:                   
                  res =  res + "|07:30";
                  break;
                        
                  case 2:                
                  res =  res + "|07:30";
                  break;
                        
                  case 3:              
                  res =  res + "|07:30";
                  break;
                        
                  case 4:   
                  res =  res + "|07:30";
                  break;
                        
                  case 5:   
                  res =  res + "|07:30";
                  break;
                        
                  case 6: 
                  res =  res + "|10:00";
                  break;
                        
                  case 7: 
                  res =  res + "|OFF";
                  break;                       
                }                
             }
             System.out.println("Para las: " +res+ "|");
           }
        else {
            System.out.println( "Ese día no existe: " );            
    }
	}
}
