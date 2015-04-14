package ficheros;

import java.io.File;

public class SistemaDeFicheros {

    
    /**
     * 
     * @param directorio El nombre del fichero
     * @return El número de bytes que ocupa el fichero, o -1 si no existe el fichero indicado
     */
    public long bytesDeFichero( String fichero ){
        File d = new File(fichero);
        if( !d.exists() ){
            return -1;
        }
        if( d.isDirectory() ){
            return -1;
        }
        return d.length();
    }
    
    /**
     * 
     * @param directorio El nombre del directorio
     * @return El número de bytes que ocupan los ficheros de ese directorio, o -1 si no existe el directorio indicado
     */
    public long bytesEnDirectorio( String directorio ){
        return bytesEnDirectorio( directorio, false );
    }

    
    /**
     * 
     * @param directorio El nombre del directorio
     * @param recursivo Si se tienen en cuenta los directorios incluidos en ese directorio
     * @return El número de bytes que ocupan los ficheros de ese directorio, o -1 si no existe el directorio indicado
     */
    public long bytesEnDirectorio( String directorio, boolean recursivo ){
        File d = new File(directorio);
        if( !d.exists() ){
            return -1;
        }
        if( !d.isDirectory() ){
            return -1;
        }
        long contador = 0; 
        for( File f: d.listFiles() ){
            if( f.isDirectory() && recursivo ){
                contador += bytesEnDirectorio(f.getAbsolutePath(), recursivo);
            }
            if( f.isFile() ){
                contador += f.length();
            }
        }
        return contador;
    }
}
