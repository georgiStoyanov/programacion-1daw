
/**
 * Write a description of class Aulas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Scanner;
public class Aulas
{

    /**
     * Pregunta por cuantas aulas hay, y por los alumnos de cada aula.
     * Después, hace un listado de las aulas.
     */
    public static void main( String args[] ){

        Scanner in = new Scanner(System.in);
        System.out.println( "*********************************" );

        System.out.println( "Cuantas aulas?:" );
        int numeroAulas = Integer.parseInt( in.nextLine() );

        /*
         * ESTA VARIABLE TIENE LAS AULAS
         * DIMENSION 1ª: AULAS
         * DIMENSION 2ª: ALUMNOS DENTRO DEL AULA
         */
        String[][] aulas; 
        aulas = new String [numeroAulas][];

        // BUCLE PARA RECORRER LAS AULAS
        for( int aula = 1 ; aula <= numeroAulas ; aula += 1 ){
            System.out.printf( "Cuantos alumnos en aula %d?:", aula );
            int numeroAlumnos = Integer.parseInt( in.nextLine() );

            // VARIABLE PARA ALMACENAR LOS ALUMNOS DEL AULA ACTUAL
            String[] alumnos = new String[numeroAlumnos];

            // BUCLE PARA RECORRER LOS ALUMNOS DEL AULA
            for( int alumno = 1 ; alumno <= numeroAlumnos ; alumno += 1 ){
                System.out.printf( "Alumno %d de aula %d?:", alumno, aula );
                alumnos[alumno-1] = in.nextLine();
            }

            aulas[aula-1] = alumnos;
        }
        
        // BUCLE PARA HACER UN LISTADO DE LAS AULAS Y SUS ALUMNOS
        for ( int i = 0 ; i < aulas.length ; i ++ ){
            System . out . println ( " Aula " + i );
            for ( String alumno : aulas [ i ] ){
                System . out . println ( " \t " + alumno );
            }
        }
    }
}
