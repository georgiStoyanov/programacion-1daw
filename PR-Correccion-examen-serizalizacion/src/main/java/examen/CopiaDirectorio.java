package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopiaDirectorio {

    public static final int OK = 0;
    public static final int ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO = -1;
    public static final int DESTINO_YA_EXISTE = -2;
    public static final int ERROR_CREANDO_DESTINO = -3;
    
    
    /**
     * Copia un directorio recursivamente en otro directorio. 
     * Si no sucede ningún error devolverá OK (0)
     * Si el directorio origen no existe,  devolverá ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO (-1), y no hará nada.
     * Si el directorio destino ya existe, devolverá DESTINO_YA_EXISTE (-2), y no hará nada.
     * Si el directorio destino no puede crearse, devolverá ERROR_CREANDO_DESTINO (-3), y no hará nada.
     * En linux, el comando tree -s te dará información de si has copiado bien o mal el directorio
     * @param args
     * @throws IOException 
     */
    public int copia( String directorioOrigen, String directorioDestino ) throws IOException{
        
        File origen = new File(directorioOrigen);
        File destino = new File(directorioDestino);
        
        return copiaDirectorio(origen, destino);

    }

    private int copiaDirectorio(File origen, File destino) throws IOException {
        
        if( !origen.isDirectory() ){
            return ORIGEN_NO_EXISTE_O_NO_ES_DIRECTORIO;
        }

        if( destino.exists() ){
            return DESTINO_YA_EXISTE;
        }
        
        if( !destino.mkdirs() ){
            return ERROR_CREANDO_DESTINO;
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
        
        return OK;
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
