package serialize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiFabricaDeDatos {

    private static void log(String string) {
        System.out.println(string);
    }

    
    private static class MiDatoTexto implements DatoTexto{

        private String _nombre;
        private String _valor;

        public MiDatoTexto( String nombre, String valor ){
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
            log( this + " equals " + obj );
            if( !(obj instanceof DatoTexto) ){
                log( "  false");
                return false;
            }
            DatoTexto dt = (DatoTexto) obj;
            boolean ret = getNombre().equals(dt.getNombre()) && getValor().equals(dt.getValor());
            log( "  " + ret );
            return ret;
        }
        

        @Override
        public String toString() {
            return "[" + getNombre() +"=" + getValor()+"]";
        }
        
    }
    
    private static class MiCarpetaDatos implements CarpetaDatos{

        private String _nombre;
        private List<Dato> _datos;

        public MiCarpetaDatos(String nombre){
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
            DatoTexto dt = new MiDatoTexto(nombre,valor);
            _datos.add(dt);
            return dt;
        }

        @Override
        public CarpetaDatos addCarpetaDatos(String nombre) {
            CarpetaDatos cd = new MiCarpetaDatos( nombre );
            _datos.add(cd);
            return cd;
        }
        
        @Override
        public boolean equals(Object obj) {
            log( this + " equals " + obj );
            if( !(obj instanceof CarpetaDatos) ){
                log( "  false" );
                return false;
            }
            
            CarpetaDatos cd = (CarpetaDatos) obj;
            if( !getNombre().equals(cd.getNombre())){
                return false;
            }
            boolean ret = _datos.equals( Arrays.asList( cd.getDatos()) );
            log( "  " + ret );
            return ret;
        }
        
        @Override
        public String toString() {
            return _datos.toString();
        }
    }
    
    public static CarpetaDatos creaCarpetaDatos( String nombre ){
        return new MiCarpetaDatos(nombre);
    }
}
