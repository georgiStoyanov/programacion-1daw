
/**
 * Programa que genera la tabla de multiplicar de un número comprendido en el rango 1 a 10
 * 
 * @author Iván Hernanz Pérez
 * @version 25-oct-2014
 */

import java.util.Scanner;

public class Despertador
{
    static String resultado = "";
    
    public static void main( String[] args ){        
        Scanner in = new Scanner( System.in );
       
        //Pedir el número        
        System.out.println( "¿Qué día de la semana es hoy? : " );
        int dia = Integer.parseInt( in.nextLine() );
        System.out.println( "¿Cuantos días debo programar el despertador? : " );
        int numdias = Integer.parseInt( in.nextLine() );
        
        
        
        if( dia <= 7){
           // System.out.println( "dentro del if " );
           for(int contador = 1; contador <= numdias; contador ++){
                 //System.out.println( "dentro del for " );
                 if(dia  >= 7){
                
                     dia = 0;
                     dia = dia + 1;
                
                switch( dia ){
                    case 1:                   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 2:                
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 3:              
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 4:   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 5:   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 6: 
                         resultado =  resultado + " 10:30";
                         break;
                        
                    case 7: 
                         resultado =  resultado + " OFF";
                         break;                    
                }
            }
            else{
                dia = dia +1;
                switch( dia ){
                    case 1:                   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 2:                
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 3:              
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 4:   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 5:   
                         resultado =  resultado + " 07:30";
                         break;
                        
                    case 6: 
                         resultado =  resultado + " 10:30";
                         break;
                        
                    case 7: 
                         resultado =  resultado + " OFF";
                         break;                    
                        }
                   
                    }                
             }
             System.out.println( resultado );
           }
            else{
            System.out.println( "Ese día de la semana no existe : " );            
        }   
       
    }
}
