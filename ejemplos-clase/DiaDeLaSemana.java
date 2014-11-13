
/**
 * Write a description of class DiaDeLaSemana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class DiaDeLaSemana
{
    public static void main( String[] args ){
        System.out.println ( "Te voy a decir el dia de la semana a partir del numero:" );
        Scanner in = new Scanner( System.in );
        
        int dia = Integer.parseInt( in.nextLine() );
        
        String nombreDia;
        
        switch( dia ){
            case 1: nombreDia = "Lunes"; break;
            case 2: nombreDia = "Martes"; break;
            case 3: nombreDia = "Miercoles"; break;
            case 4: nombreDia = "Jueves"; break;
            case 5: nombreDia = "Viernes"; break;
            case 6: nombreDia = "Sabado"; break;
            case 7: nombreDia = "Domingo"; break;
            default: nombreDia = "Dia fuera de rango"; 
            
        }
        
        System.out.println( "El dia numero " + dia + " se llama:" + nombreDia );
    }

}
