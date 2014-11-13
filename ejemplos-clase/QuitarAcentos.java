
/**
 * Write a description of class QuitarAcentos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QuitarAcentos
{
    public static void main( String args[] ){

        System.out.println( "______________________________" );

        String nombre = new java.util.Scanner(System.in).nextLine();
        String original = nombre;
        
        

        nombre = nombre.replaceAll( "Á", "A" )
        .replaceAll( "É", "A" )
        .replaceAll( "Í", "A" )
        .replaceAll( "Ó", "A" )
        .replaceAll( "Ú", "A" )
        .replaceAll( "á", "a" )
        .replaceAll( "é", "e" )
        .replaceAll( "í", "i" )
        .replaceAll( "ó", "o" )
        .replaceAll( "ú", "u" );

        System.out.printf( "%s --> %s\n", original, nombre );
        
        
        
        
        nombre = original;
        
        String[] acentos = new String[]{ "á", "é", "í", "ó", "ú", "ñ", "Ñ" };
        for( String ac : acentos ){
            nombre = nombre.replaceAll(ac,"*" );
        }
        System.out.printf( "%s[]--> %s\n", original, nombre );
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

    }

}
