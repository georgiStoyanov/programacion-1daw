package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class MiFabricaDeDatos {

    private static void log(String string) {
        System.out.println(string);
    }

    private static class MiDatoTexto implements DatoTexto {

        private String _nombre;
        private String _valor;

        public MiDatoTexto(String nombre, String valor) {
            _nombre = nombre;
            _valor = valor;
        }

        @Override
        public String getNombre() {
            return _nombre;
        }

        @Override
        public String getValor() {
            return _valor;
        }

        @Override
        public boolean equals(Object obj) {
            log(this + " equals " + obj);
            if (!(obj instanceof DatoTexto)) {
                log("  false");
                return false;
            }
            DatoTexto dt = (DatoTexto) obj;
            boolean ret = getNombre().equals(dt.getNombre()) && getValor().equals(dt.getValor());
            log("  " + ret);
            return ret;
        }

        @Override
        public String toString() {
            return getNombre() + "=" + getValor();
        }

    }

    private static class MiCarpetaDatos implements CarpetaDatos {

        private String _nombre;
        private List<Dato> _datos;

        public MiCarpetaDatos(String nombre) {
            _nombre = nombre;
            _datos = new ArrayList<Dato>();
        }

        @Override
        public String getNombre() {
            return _nombre;
        }

        @Override
        public Dato[] getDatos() {
            return (Dato[]) _datos.toArray(new Dato[_datos.size()]);
        }

        @Override
        public DatoTexto addDatoTexto(String nombre, String valor) {
            DatoTexto dt = new MiDatoTexto(nombre, valor);
            _datos.add(dt);
            return dt;
        }

        @Override
        public CarpetaDatos addCarpetaDatos(String nombre) {
            CarpetaDatos cd = new MiCarpetaDatos(nombre);
            _datos.add(cd);
            return cd;
        }

        @Override
        public boolean equals(Object obj) {
            log(this + " equals " + obj);
            if (!(obj instanceof CarpetaDatos)) {
                log("  false");
                return false;
            }

            CarpetaDatos cd = (CarpetaDatos) obj;
            if (!getNombre().equals(cd.getNombre())) {
                return false;
            }
            boolean ret = _datos.size() == cd.getDatos().length &&
            		      _datos.containsAll(Arrays.asList(cd.getDatos()));
            log("  " + ret);
            return ret;
        }

        @Override
        public String toString() {
            return getNombre() + _datos.toString();
        }
    }

    public static CarpetaDatos creaCarpetaDatos(String nombre) {
        return new MiCarpetaDatos(nombre);
    }

    public static void escribeDatoEnFichero(String fichero, Dato dato) throws IOException {
        escribeDatoEnFichero(fichero, dato, false);
    }

    public static void escribeDatoEnFichero(String fichero, Dato dato, boolean gzip) throws IOException {
        OutputStream os = null;
        ObjectOutputStream oos = null;

        try {
            os = new FileOutputStream(fichero);
            if (gzip) {
                os = new GZIPOutputStream(os);
            }
            oos = new ObjectOutputStream(os);
            oos.writeObject(dato);
        }
        finally {
            if (oos != null) {
                oos.close();
            }
            if (os != null) {
                os.close();
            }
        }
    }

    public static Dato leeDatoDeFichero(String fichero) throws IOException {
        return leeDatoDeFichero(fichero, false);
    }

    public static Dato leeDatoDeFichero(String fichero, boolean gzip) throws IOException {
        InputStream is = null;
        ObjectInputStream ois = null;

        try {
            is = new FileInputStream(fichero);
            if (gzip) {
                is = new GZIPInputStream(is);
            }

            ois = new ObjectInputStream(is);
            Object o = ois.readObject();
            return (Dato) o;
        }
        catch( ClassCastException e ){
            return null;
        }
        catch (ClassNotFoundException e) {
            return null;
        }
        finally {
            if (ois != null) {
                ois.close();
            }
            if (is != null) {
                is.close();
            }
        }
    }

}
