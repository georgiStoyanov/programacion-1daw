package daw;

/**
 * Write a description of class ClaseConPaquete here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ClaseConPaquete
{
    public static void main(String[] args ){
        double d = 1./3.;

        String a = "Álvaro González Sotillo";

        System.out.println( "________________________________" );
        System.out.println( d );

        System.out.println( String.format("%.4f", d) );
        System.out.println( String.format("%e", d) );
        System.out.println( String.format("%.6s%%%.27e", a, d) );

        System.out.println( (a.replaceAll("á", "a")).replaceAll("Á", "A") );
        System.out.println( (a.replaceAll("á", "&aacute;")).replaceAll("Á", "&Aacute;") );

        String loQueBusco = "Gonzalez";
        int dondeEsta = a.indexOf( loQueBusco );
        System.out.println( String.format( "%s está en %d", loQueBusco, dondeEsta ) );

        int inicioPrimerApellido = a.indexOf(' ');
        int finalPrimerApellido = a.indexOf( ' ', inicioPrimerApellido+1 );

        String primerApellido = a.substring(inicioPrimerApellido+1, finalPrimerApellido);
        System.out.println( String.format( "%d -- %d :>%s<", inicioPrimerApellido, 
                finalPrimerApellido, 
                primerApellido ) );

       
    
    }
}
