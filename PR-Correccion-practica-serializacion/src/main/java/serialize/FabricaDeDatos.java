package serialize;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FabricaDeDatos {

    
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
            if( !(obj instanceof DatoTexto) ){
                return false;
            }
            DatoTexto dt = (DatoTexto) obj;
            return getNombre().equals(dt.getNombre()) && getValor().equals(dt.getValor());
        }
        
    }
    
    private static class MiCarpetaDatos implements CarpetaDatos{

        private String _nombre;
        private Set<Dato> _datos;

        public MiCarpetaDatos(String nombre){
            _nombre = nombre;
            _datos = new HashSet<Dato>();
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
            if( !(obj instanceof CarpetaDatos) ){
                return false;
            }
            CarpetaDatos cd = (CarpetaDatos) obj;
            Set<Dato> set = new HashSet<Dato>( Arrays.asList( cd.getDatos()) );
            return set.equals( _datos );
        }
    }
    
    public static CarpetaDatos creaCarpetaDatos( String nombre ){
        return new MiCarpetaDatos(nombre);
    }
}
