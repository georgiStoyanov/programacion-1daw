package ficheros;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.Charset;

public class ConversionDeCharset {

    
    /**
     * Convierte los caracteres de una entrada con un charset, a una salida con otro charset
     * @param in
     * @param inCharset
     * @param out
     * @param outCharset
     * @throws IllegalArgumentException Si alguno de los charsets no está soportado
     * @throws IOException Si se produce un error de entrada/salida
     */
    public void convertir( InputStream in, String inCharset, OutputStream out, String outCharset ) throws IOException{
        if( !Charset.isSupported(inCharset) ){
            throw new IllegalArgumentException( "No soportado entrada:" + inCharset );
        }
        if( !Charset.isSupported(outCharset) ){
            throw new IllegalArgumentException( "No soportado salida:" + outCharset );
        }
        Reader reader = new InputStreamReader(in,inCharset);
        Writer writer = new OutputStreamWriter(out,outCharset);
        int leido = reader.read();
        while( leido != -1 ){
            writer.write(leido);
            leido = reader.read();
        }
        writer.flush();
        
    }
}
