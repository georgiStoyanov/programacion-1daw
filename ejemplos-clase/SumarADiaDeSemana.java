
/**
 * Write a description of class SumarADiaDeSemana here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class SumarADiaDeSemana
{
    public static void main( String[] args ){
        System.out.println ( "Te voy a decir el dia de la semana a partir del numero y unos dias que pasan:" );
        Scanner in = new Scanner( System.in );

        System.out.println( "Que dia es hoy?" );
        int dia = Integer.parseInt( in.nextLine() );

        System.out.println( "Cuantos dias pasan?" );
        int diasQuePasan = Integer.parseInt( in.nextLine() );

        dia = ((dia-1) + diasQuePasan) % 7;
        if( dia < 0 ){
            dia = dia + 7;
        }

        System.out.println( "El nuevo dia es (empezando en cero):" + dia );

        String nombreDia;

        switch( dia ){
            case 0: nombreDia = "Lunes"; break;
            case 1: nombreDia = "Martes"; break;
            case 2: nombreDia = "Miercoles"; break;
            case 3: nombreDia = "Jueves"; break;
            case 4: nombreDia = "Viernes"; break;
            case 5: nombreDia = "Sabado"; break;
            case 6: nombreDia = "Domingo"; break;
            default: nombreDia = "Dia fuera de rango"; 

        }

        System.out.println( "El dia numero " + (dia+1) + " se llama:" + nombreDia );
    }

}
