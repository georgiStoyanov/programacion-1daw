package serialize;

import java.io.IOException;


public class FabricaDeDatos {

    
    public static CarpetaDatos creaCarpetaDatos( String nombre ){
        return MiFabricaDeDatos.creaCarpetaDatos(nombre);
    }
    
    public static void escribeDatoEnFichero( String fichero, Dato dato ) throws IOException{
        MiFabricaDeDatos.escribeDatoEnFichero(fichero, dato);
    }

    public static void escribeDatoEnFichero( String fichero, Dato dato, boolean gzip ) throws IOException{
        MiFabricaDeDatos.escribeDatoEnFichero(fichero, dato, gzip );
    }
    
    public static Dato leeDatoDeFichero(String fichero) throws IOException {
        return MiFabricaDeDatos.leeDatoDeFichero(fichero);
    }

    public static Dato leeDatoDeFichero(String fichero, boolean gzip) throws IOException {
        return MiFabricaDeDatos.leeDatoDeFichero(fichero, gzip);
    }

}
