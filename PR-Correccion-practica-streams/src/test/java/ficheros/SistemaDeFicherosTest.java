package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.junit.Test;

import static org.junit.Assert.*;

public class SistemaDeFicherosTest {

    static class Prueba {

        private File _dir;
        private long _bytesTotales;
        private Random _r = new Random();

        public Prueba(int niveles) throws IOException {
            this(new File("."), niveles);
        }

        public Prueba(File parent, int niveles) throws IOException {
            _bytesTotales = 0;
            _dir = hazDirectorio(parent);
            hazPrueba(niveles, _dir);
        }

        public File dir() {
            return _dir;
        }

        public long bytesTotales() {
            return _bytesTotales;
        }

        private void hazPrueba(int niveles, File dir) throws IOException {
            if (niveles == 0) {
                return;
            }

            int ficheros = 5 + _r.nextInt(5);
            for (int i = 0; i < ficheros; i += 1) {
                if (_r.nextBoolean() && niveles > 1) {
                    File d = hazDirectorio(dir);
                    hazPrueba(niveles - 1, d);
                }
                else {
                    long longitud = 10 + _r.nextInt(10);
                    hazFicheroConLongitud(dir, longitud);
                    _bytesTotales += longitud;
                }
            }
        }

        public void borrar() throws IOException {
            borrar(_dir);
        }

        private void borrar(File f) throws IOException {
            if (f.isDirectory()) {
                for (File c : f.listFiles())
                    borrar(c);
            }
            if (!f.delete())
                throw new FileNotFoundException("Failed to delete file: " + f);
        }

        private File hazFicheroConLongitud(File parent, long longitud) throws IOException {
            File file = File.createTempFile("prefix", "sufix", parent);
            FileOutputStream out = new FileOutputStream(file);
            for (int i = 0; i < longitud; i++) {
                out.write(1);
            }
            out.close();
            return file;
        }

        private File hazDirectorio(File parent) throws IOException {
            File file = File.createTempFile("prefix", "sufix", parent);
            file.delete();
            file.mkdirs();
            return file;
        }
    }

    @Test
    public void bytesEnDirectorio() throws IOException {
        Prueba p = new Prueba(1);
        try {
            SistemaDeFicheros f = new SistemaDeFicheros();
            long b = f.bytesEnDirectorio(p.dir().getAbsolutePath());
            assertTrue("Bytes incorrectos, eran " + p.bytesTotales() + ":" + b, p.bytesTotales() == b);
        }
        finally {
            p.borrar();
        }
    }

    @Test
    public void bytesEnDirectorioVacio() throws IOException {
        File f = new File("esundirectorionounfichero");
        f.mkdirs();
        SistemaDeFicheros fs = new SistemaDeFicheros();
        long b = fs.bytesEnDirectorio(f.getAbsolutePath());
        assertTrue("Bytes incorrectos, eran " + 0 + ":" + b, 0 == b);
    }

    @Test
    public void noExisteDirectorio() {
        SistemaDeFicheros f = new SistemaDeFicheros();
        long l = f.bytesEnDirectorio("noexisteseguroquenoquevaqueva");
        assertTrue("Si el directorio no existe tiene que dar -1:" + l, l == -1);
    }

    @Test
    public void noExisteFichero() {
        SistemaDeFicheros fs = new SistemaDeFicheros();
        File f = new File("noexisteseguroquenoquevaqueva");
        f.delete();
        long l = fs.bytesDeFichero(f.getAbsolutePath());
        assertTrue("Si el fichero no existe tiene que dar -1:" + l, l == -1);
    }

    @Test
    public void esUnFichero() throws IOException {
        File f = new File("esunficheronoundirectorio");
        f.createNewFile();
        SistemaDeFicheros sf = new SistemaDeFicheros();
        long l = sf.bytesEnDirectorio(f.getAbsolutePath());
        assertTrue("Si es un fichero tiene que dar -1:" + l, l == -1);
    }

    @Test
    public void esUnDirectorio() throws IOException {
        File f = new File("esundirectorionounfichero");
        f.mkdirs();
        SistemaDeFicheros sf = new SistemaDeFicheros();
        long l = sf.bytesDeFichero(f.getAbsolutePath());
        assertTrue("Si es un directorio tiene que dar -1:" + l, l == -1);
    }

    public static void main(String[] args) throws IOException {
        Prueba p = new Prueba(1);
        System.out.println(p.dir() + ": " + p._bytesTotales);
        // p.borrar();
    }
}
