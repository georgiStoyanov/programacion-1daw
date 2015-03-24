package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaDirectorio {

    /**
     * Copia un directorio recursivamente en otro directorio. 
     * Si el directorio origen no existe, el programa indicará "origen no existe o no es un directorio", y no hará nada.
     * Si el directorio destino ya existe, el programa indicará "destino ya existe", y no hará nada.
     * Si el directorio destino no puede crearse, el programa indicará "error creando destino", y no hará nada.
     * En linux, el comando tree -s te dará información de si has copiado bien o mal el directorio
     * @param args
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException{
        if( args.length != 2 ){
            System.out.println( "Uso: <directorio origen> <directorio destino>" );
            return;
        }
        
        File origen = new File(args[0]);
        File destino = new File(args[1]);
        
        copiaDirectorio(origen, destino);

    }

    private static void copiaDirectorio(File origen, File destino) throws IOException {
        
        if( !origen.isDirectory() ){
            System.out.println( "origen no existe o no es un directorio" );
            System.exit(0);
        }

        if( destino.exists() ){
            System.out.println( "destino ya existe" );
            System.exit(0);
        }
        
        if( !destino.mkdirs() ){
            System.out.println( "error creando destino" );
            System.exit(0);
        }
        
        String[] files = origen.list();
        for( String file: files ){
            File f = new File( origen, file );
            if( f.isFile() ){
                copiaFichero( origen, destino, file );
            }
            if( f.isDirectory() ){
                File d = new File( destino, file );
                copiaDirectorio( f, d );
            }
        }
    }

    private static void copiaFichero(File origen, File destino, String file) throws IOException {
        FileInputStream fis = new FileInputStream( new File(origen, file ) );
        FileOutputStream fos = new FileOutputStream( new File(destino, file ) );
        int b = fis.read();
        while( b != -1 ){
            fos.write(b);
            b = fis.read();
        }
        fis.close();
        fos.close();
    }
}
