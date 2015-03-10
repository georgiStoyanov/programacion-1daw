package ficheros;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import static org.junit.Assert.*;

import org.junit.Test;

public class ContarBytesTest {

    @Test
    public void contarNingunByte(){
        InputStream in = new ByteArrayInputStream( new byte[0] );
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, (byte) 0);
        assertTrue( "Si no hay bytes, la cuenta debería ser cero:" + contar, contar == 0 );
    }

    @Test
    public void contarUnByte_si() throws UnsupportedEncodingException{
        byte buscado = "a".getBytes("UTF-8")[0];
        InputStream in = new ByteArrayInputStream( "a".getBytes("UTF-8") );
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, buscado);
        assertTrue( "La cuenta debería ser 1:" + contar, contar == 1 );
    }

    @Test
    public void contarUnByte_no() throws UnsupportedEncodingException{
        byte buscado = "b".getBytes("UTF-8")[0];
        InputStream in = new ByteArrayInputStream( "a".getBytes("UTF-8") );
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, buscado);
        assertTrue( "La cuenta debería ser 0:" + contar, contar == 0 );
    }
    
    @Test
    public void contarVariosBytes() throws UnsupportedEncodingException{
        byte buscado = "a".getBytes("UTF-8")[0];
        InputStream in = new ByteArrayInputStream( "Hola que tal".getBytes("UTF-8") );
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, buscado);
        assertTrue( "La cuenta debería ser 2:" + contar, contar == 2 );
    }

    private static class InputStreamConError extends InputStream{

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
            throw new IOException("Error leyendo de InputStream en el byte número:" + contador );
        }
        
    }
    
    @Test
    public void contar_excepcionInicial() throws UnsupportedEncodingException{
        InputStream in = new InputStreamConError(0);
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, (byte)0);
        assertTrue( "La cuenta debería ser -1:" + contar, contar == -1 );
    }
    
    @Test
    public void contar_excepcionTardia() throws UnsupportedEncodingException{
        InputStream in = new InputStreamConError(1000);
        ContarBytes cb = new ContarBytes();
        int contar = cb.contarBytesConValor(in, (byte)0);
        assertTrue( "La cuenta debería ser -1:" + contar, contar == -1 );
    }


}
