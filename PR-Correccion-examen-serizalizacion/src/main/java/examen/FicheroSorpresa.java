package examen;

import java.io.CharArrayWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.util.zip.GZIPInputStream;

public class FicheroSorpresa {

    /**
     * Recibirá un nombre de fichero. Se garantiza que el fichero existe. El
     * fichero puede ser: - Un fichero de texto UTF-8: se devolverá el contenido
     * del fichero como String - Un fichero con un objeto serializado: se
     * devolverá el valor como cadena del objeto, con String.valueOf() -
     * Cualquiera de los anteriores, comprimido con GZIP: se descomprimirá y se
     * devolverá lo mismo que si no estuviera comprimido - Ante un error:
     * devolverá null
     * 
     * @param file
     * @return
     */
    public String ficheroSorpresa(String file) {
        String ret = pruebaSerializadoComprimido(file);

        if (ret == null) {
            ret = pruebaSerializado(file);
        }
        if (ret == null) {

            ret = pruebaUTF8Comprimido(file);
        }

        if (ret == null) {
            ret = pruebaUTF8(file);
        }

        return ret;

    }

    private String leeFichero(Reader in) throws IOException{
        CharArrayWriter out = new CharArrayWriter();
        int c = in.read();
        while( c != -1 ){
            out.write(c);
            c = in.read();
        }
        out.close();
        in.close();
        return out.toString();
    }
    
    private String pruebaUTF8Comprimido(String file) {
        try{
            InputStreamReader in = new InputStreamReader( new GZIPInputStream( new FileInputStream(file)));
            return leeFichero(in);
        }
        catch( Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    private String pruebaUTF8(String file) {
        try{
            InputStreamReader in = new InputStreamReader( new FileInputStream(file));
            return leeFichero(in);
        }
        catch( Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    private String pruebaSerializadoComprimido(String file) {
        try{
            ObjectInputStream in = new ObjectInputStream( new GZIPInputStream( new FileInputStream(file)));
            Object o = in.readObject();
            in.close();
            return o.toString();
        }
        catch( Exception e ){
            e.printStackTrace();
            return null;
        }
    }

    private String pruebaSerializado(String file) {
        try{
            ObjectInputStream in = new ObjectInputStream( new FileInputStream(file));
            Object o = in.readObject();
            in.close();
            return o.toString();
        }
        catch( Exception e ){
            e.printStackTrace();
            return null;
        }
    }

}
