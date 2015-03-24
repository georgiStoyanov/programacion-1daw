package examen;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.junit.Test;

public class FicheroSorpresaTest {

    public 
    
    
    @Test
    public void pruebaUTF8_1(){
        File destino = new File( "" + System.currentTimeMillis() + "-" + System.identityHashCode(this) );
        Writer w = new OutputStreamWriter( new FileOutputStream(destino));
        w.write(UTF8);
    }
}
