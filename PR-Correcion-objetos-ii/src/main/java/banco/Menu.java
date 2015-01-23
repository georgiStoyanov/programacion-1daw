package banco;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Menu extends Pantalla{
    
    public static class Cabecera{
        private String[] _ss;

        public Cabecera( String[] ss ){
            _ss = ss;
        }
    }
    
    
    public static class Opcion{
        private Pantalla _accion;
        private String _msg;

        public Opcion( String msg, Pantalla accion){
            _msg = msg;
            _accion = accion;
        }

        public Opcion( Pantalla accion){
            this( accion.nombre(), accion );
        }

        
        public Pantalla menu(){
            return _accion;
        }
    }

    private Opcion[] _opciones;
    
    public Menu( String nombre, Opcion[] os ){
        super(nombre);
        _opciones = os;
    }
    
    public Opcion[] opciones(){
        return _opciones.clone();
    }    
}