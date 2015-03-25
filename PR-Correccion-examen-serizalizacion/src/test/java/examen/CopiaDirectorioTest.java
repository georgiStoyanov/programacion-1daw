package examen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Random;

import org.junit.Test;
import static org.junit.Assert.*;

public class CopiaDirectorioTest {

    static class ComparadorDirectorios {

        public String compararFicheros(File original, File copia) throws IOException {
            if (!original.isFile()) {
                throw new IllegalArgumentException();
            }
            if (original.isFile() != copia.isFile()) {
                return original + " no es fichero como " + copia;
            }

            InputStream ino = null;
            InputStream inc = null;
            try {
                ino = new FileInputStream(original);
                inc = new FileInputStream(copia);
                int bo = ino.read();
                while (bo != -1) {
                    int bc = inc.read();
                    if (bc != bo) {
                        return original + " no es igual que " + copia;
                    }
                    bo = ino.read();
                }
                if (inc.read() != -1) {
                    return copia + " es más largo que " + original;
                }
            }
            finally {
                if (ino != null)
                    ino.close();
                if (inc != null)
                    inc.close();
            }
            return null;
        }

        /**
         * 
         * @param dir1
         * @param dir2
         * @return
         * @throws IOException
         */
        public String compararDirectorios(File original, File copia) throws IOException {
            File[] oFiles = original./* getAbsoluteFile(). */listFiles();
            File[] cFiles = copia./* getAbsoluteFile(). */listFiles();

            if (oFiles.length != cFiles.length) {
                return original + " tiene un número diferente de ficheros que " + copia;
            }

            Arrays.sort(oFiles);
            Arrays.sort(cFiles);

            for (int i = 0; i < oFiles.length; i++) {
                File fo = oFiles[i];
                File fc = cFiles[i];
                if (fo.isFile()) {
                    String ret = compararFicheros(fo, fc);
                    if (ret != null) {
                        return ret;
                    }
                }
                if (fo.isDirectory()) {
                    String ret = compararDirectorios(fo, fc);
                    if (ret != null) {
                        return ret;
                    }
                }
            }

            return null;
        }
    }

    static class CreadorDeDirectoriosAlAzar {

        private File _dir;
        private long _bytesTotales;
        private Random _r = new Random();

        public CreadorDeDirectoriosAlAzar(int niveles) throws IOException {
            this(new File("."), niveles);
        }

        public CreadorDeDirectoriosAlAzar(File parent, int niveles) throws IOException {
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

    private void borrar(File f) throws IOException {
        if (f.isDirectory()) {
            for (File c : f.listFiles())
                borrar(c);
        }
        f.delete();
    }

    private void prueba(int nivel, int padresDeDestino ) throws IOException {
        CreadorDeDirectoriosAlAzar cdd = new CreadorDeDirectoriosAlAzar(nivel);
        File destino = new File("destino-" + System.currentTimeMillis() + "-" + System.identityHashCode(cdd));
        for( int i = 0 ; i < padresDeDestino; i++ ){
            destino = new File(destino,"padre-" + i );
        }
        try {
            CopiaDirectorio copia = new CopiaDirectorio();
            copia.copia(cdd.dir().getPath(), destino.getPath());
            String res = new ComparadorDirectorios().compararDirectorios(cdd.dir(), destino);
            assertTrue(res, res == null);
        }
        finally {
            cdd.borrar();
            borrar(destino);
        }
    }

    
    @Test
    public void ningunNivel() throws IOException {
        prueba(0,0);
    }

    @Test
    public void unNivel() throws IOException {
        prueba(1,0);
    }

    @Test
    public void dosNiveles() throws IOException {
        prueba(2,0);
    }

    @Test
    public void tresNiveles() throws IOException {
        prueba(3,0);
    }

    @Test
    public void ningunNivel_dos() throws IOException {
        prueba(0,2);
    }

    @Test
    public void unNivel_dos() throws IOException {
        prueba(1,2);
    }

    @Test
    public void dosNiveles_dos() throws IOException {
        prueba(2,2);
    }

    @Test
    public void tresNiveles_dos() throws IOException {
        prueba(3,2);
    }

    @Test
    public void directorioOrigenNoExiste() throws IOException {
        CopiaDirectorio copia = new CopiaDirectorio();
        String directorioQueNoExiste = "" + System.currentTimeMillis() + "-" + System.identityHashCode(copia);
        String destino = "destino-" + System.identityHashCode(copia);
        new File(directorioQueNoExiste).delete();
        try {
            int ret = copia.copia(directorioQueNoExiste, destino);
            assertTrue("El directorio origen no existe y devuelve:" + ret, ret == -1);
        }
        finally {
            new File(destino).delete();
        }
    }

    @Test
    public void directorioOrigenEsUnFichero() throws IOException {
        CopiaDirectorio copia = new CopiaDirectorio();
        File directorioQueEsUnFichero = new File("" + System.currentTimeMillis() + "-" + System.identityHashCode(copia));
        directorioQueEsUnFichero.createNewFile();
        String destino = "destino-" + System.identityHashCode(copia);
        try {
            int ret = copia.copia(directorioQueEsUnFichero.getPath(), destino);
            assertTrue("El directorio origen es un fichero y devuelve:" + ret, ret == -1);
        }
        finally {
            new File(destino).delete();
            directorioQueEsUnFichero.delete();
        }
    }

    @Test
    public void destinoYaExiste() throws IOException {
        CopiaDirectorio copia = new CopiaDirectorio();
        CreadorDeDirectoriosAlAzar cdd = new CreadorDeDirectoriosAlAzar(0);
        File destino = new File("destino-" + System.identityHashCode(copia));
        destino.mkdirs();
        try {
            int ret = copia.copia(cdd.dir().getPath(), destino.getPath());
            assertTrue("El directorio destino ya existe y devuelve:" + ret, ret == -2);
        }
        finally {
            destino.delete();
            cdd.borrar();
        }
    }

    @Test
    public void destinoNoPuedeCrearse() throws IOException {
        CopiaDirectorio copia = new CopiaDirectorio();
        CreadorDeDirectoriosAlAzar cdd = new CreadorDeDirectoriosAlAzar(1);
        File destino = new File("/etc/destino-" + System.identityHashCode(copia));
        try {
            int ret = copia.copia(cdd.dir().getPath(), destino.getPath());
            assertTrue("El directorio destino no puede crearse y devuelve:" + ret, ret == -3);
        }
        finally {
            cdd.borrar();
        }
    }

}
