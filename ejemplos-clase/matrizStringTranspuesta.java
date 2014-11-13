
/**
 * Write a description of class matrizStringTranspuesta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class matrizStringTranspuesta
{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String[] lineas = new String[3];
        System.out.println( "Introduce la matrizString 3x3:" );
        for( int l = 0 ; l < lineas.length ; l += 1 ){
            lineas[l] = in.nextLine();
        }

        // PRIMERA DIMENSION: FILA
        // SEGUNDA DIMENSION: COLUMNA DENTRO DE LA FILA
        String matrizString[][] = new String[lineas.length][];
        for( int l = 0 ; l < lineas.length ; l += 1 ){
            matrizString[l] = lineas[l].split( " " );
        }
        
        double matriz[][] = new double[matrizString.length][matrizString[0].length];
        // BUCLE SOBRE LAS FILAS
        for( int f = 0 ; f < matriz.length; f += 1 ){
            // BUCLE SOBRE LAS COLUMNAS
            for( int c = 0 ; c < matriz[0].length ; c += 1 ){
                matriz[f][c] = Double.parseDouble( matrizString[f][c] );
            }
        }      
        

        System.out.println( "Transpuesta" );
        // BUCLE SOBRE LAS COLUMNAS
        for( int c = 0 ; c < matriz[0].length ; c += 1 ){
            // BUCLE SOBRE LAS FILAS
            for( int f = 0 ; f < matriz.length; f += 1 ){
                System.out.print( matriz[f][c] + " " );
            }
            System.out.println();
        }

        System.out.println( "Normal" );
        // BUCLE SOBRE LAS FILAS
        for( int f = 0 ; f < matriz.length; f += 1 ){
            // BUCLE SOBRE LAS COLUMNAS
            for( int c = 0 ; c < matriz[0].length ; c += 1 ){
                System.out.print( matriz[f][c] + " " );
            }
            System.out.println();
        }      

    }
}
