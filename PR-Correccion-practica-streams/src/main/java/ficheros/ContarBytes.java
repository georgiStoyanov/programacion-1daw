package ficheros;

import java.io.IOException;
import java.io.InputStream;

public class ContarBytes {

    /**
     * 
     * @param in No debe cerrarse al terminar el método, es responsabilidad del método que nos llame
     * @param byteBuscado
     * @return El número de veces que el byteBuscado aparece en el InputStream. Si se produce un error de
     *          entrada/salida, se devolverá -1
     * 
     */
    public int contarBytesConValor( InputStream in, byte byteBuscado ){
        try {
            //throw new RuntimeException("Hay que acabar este método");
            int contador = 0;
            int leido = in.read();
            while (leido != -1) {
                if (leido == byteBuscado) {
                    contador += 1;
                }
                leido = in.read();
            }
            return contador;
        }
        catch (IOException e) {
            return -1;
        }
    }
 
}
