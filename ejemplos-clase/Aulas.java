
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

        // BUCLE PARA RECORRER LAS AULAS Y PREGUNTAR POR SUS DATOS
        // cAula ES LA VARIABLE INDICE DEL ARRAY DE aulas
        for( int cAula = 1 ; cAula <= numeroAulas ; cAula += 1 ){
            System.out.printf( "Cuantos alumnos en aula %d?:", cAula );
            int numeroAlumnos = Integer.parseInt( in.nextLine() );

            // VARIABLE PARA ALMACENAR LOS ALUMNOS DEL AULA ACTUAL
            String[] alumnos = new String[numeroAlumnos];

            // BUCLE PARA RECORRER LOS ALUMNOS DEL AULA
            // cAlumno ES LA VARIABLE INDICE DEL ARRAY DE alumnos
            for( int cAlumno = 1 ; cAlumno <= numeroAlumnos ; cAlumno += 1 ){
                System.out.printf( "Alumno %d de aula %d?:", cAlumno, cAula );
                alumnos[cAlumno-1] = in.nextLine();
            }

            aulas[cAula-1] = alumnos;
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
