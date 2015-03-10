package ficheros;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConversionDeCharsetTest {

    private static class InputStreamConError extends InputStream{

        public static class MiExcepcion extends IOException{
            public MiExcepcion(String message, Throwable cause) {
                super(message, cause);
                // TODO Auto-generated constructor stub
            }

            public MiExcepcion(String message) {
                super(message);
                // TODO Auto-generated constructor stub
            }
        }
        
        private Random r = new Random();
        private int totalBytes;
        private int contador = 0;
        
        public InputStreamConError(int bytes){
            totalBytes = bytes;
        }
        
        @Override
        public int read() throws IOException {
            if( contador < totalBytes){
                contador += 1;
                return r.nextInt(255);
            }
            throw new MiExcepcion("Error leyendo de InputStream en el byte número:" + contador );
        }
        
    }
    
    private InputStream fromString(String s, String charset) throws UnsupportedEncodingException {
        return new ByteArrayInputStream(s.getBytes(charset));
    }

    private void testImpl(String s, String inCS, String outCS) throws IOException {
        InputStream in = fromString(s, inCS);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ConversionDeCharset c = new ConversionDeCharset();
        c.convertir(in, inCS, out, outCS);
        String sOut = new String(out.toByteArray(), outCS);
        assertTrue("No se obtiene la cadena esperada: |" + s + "| != |" + sOut + "|", s.equals(sOut));

    }

    @Test(expected=IllegalArgumentException.class)
    public void charsetNoSoportadoEntrada() throws IOException {
        InputStream in = fromString("Hola", "UTF-8");
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ConversionDeCharset c = new ConversionDeCharset();
        c.convertir(in, "Inventado-no-existe", out, "UTF-8");
    }

    @Test(expected=IllegalArgumentException.class)
    public void charsetNoSoportadoSalida() throws IOException {
        testImpl("Hola", "UTF-8", "Inventado-no-existe");
    }
    
    @Test
    public void soloASCII_lw() throws IOException{
        testImpl("Hola", "UTF-8", "ISO-8859-1");
    }

    @Test
    public void soloASCII_wl() throws IOException{
        testImpl("Hola", "ISO-8859-1", "UTF-8");
    }

    @Test
    public void soloASCII_ww() throws IOException{
        testImpl("Hola", "ISO-8859-1", "ISO-8859-1");
    }
    
    @Test
    public void caracteresNoASCII_lw() throws IOException{
        testImpl("Hola adiós Íñigo Raúl pingüino", "UTF-8", "ISO-8859-1");
    }

    @Test
    public void caracteresNoASCII_wl() throws IOException{
        testImpl("Hola adiós Íñigo Raúl pingüino", "ISO-8859-1", "UTF-8");
    }

    
    @Test
    public void caracteresNoASCII_dl() throws IOException{
        testImpl("Hola adiós Íñigo Raúl pingüino", "IBM850", "UTF-8");
    }

    @Test
    public void caracteresNoASCII_ld() throws IOException{
        testImpl("Hola adiós Íñigo Raúl pingüino", "UTF-8", "IBM850");
    }

    @Test(expected=InputStreamConError.MiExcepcion.class)
    public void errorDeConversion() throws IOException{
        InputStream in = new InputStreamConError(1234);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ConversionDeCharset c = new ConversionDeCharset();
        c.convertir(in, "IBM850", out, "UTF-8");
    }

    
    public static void main(String[] args) {
        for( String s: Charset.availableCharsets().keySet() ){
            System.out.println(s);
        }
    }

}
