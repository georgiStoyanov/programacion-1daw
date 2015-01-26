package banco;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Menu extends Pantalla{
    
    private static int ALTO = 20;
    private static int ANCHO = 80;
    
    public static class Opcion{
        private Pantalla _accion;
        private String _msg;

        public Opcion( String nombre, Pantalla accion){
            _msg = nombre;
            _accion = accion;
        }

        public Opcion( Pantalla accion){
            this( accion.nombre(), accion );
        }

        public String nombre(){
            return _msg;
        }

        
        public Pantalla menu(){
            return _accion;
        }
    }

    private Opcion[] _opciones;
    
    protected int readOption(Scanner in, PrintStream out, int min, int max) {
        int ret;
        do {
            render(out);
            out.printf("Introduzca una opción (%d-%d): ", min, max);
            String s = in.nextLine();
            ret = toInt(s);

        } while (ret < min || ret > max);
        
        return ret;
    }

    private int toInt(String s) {
        try {
            return Integer.parseInt(s);
        }
        catch (Exception e) {
            return -1;
        }
    }

    abstract public String[] cabecera();
    
    public void render( PrintStream out ){
        borrarPantalla(out);
        inicioMarco( nombre(), out );

        lineaEnMarco( " ", out );

        String[] cs = cabecera();
        for( int i = 0 ; cs != null && i < cs.length ; i++ ){
            lineaEnMarco( cs[i], out );
        }

        lineaEnMarco( " ", out );

        Opcion[] ops = opciones();
        for( int i = 0 ; i < ops.length ; i++ ){
            lineaEnMarco( String.format( "%d .- %s", i, ops[i].nombre()), out );
        }

        lineaEnMarco( " ", out );

        
        
        finMarco(out);
        
        out.println();
        out.println();
        out.println();
    }
    
    private void lineaEnMarco( String s, PrintStream out ){
        int anchoInterior = ANCHO-4;
        String linea = String.format( "|  %-" + (anchoInterior) + "s |", s.substring(0, Math.min(anchoInterior,s.length())) );
        out.println( linea );
    }

    private void inicioMarco( String s, PrintStream out ){
        int margen = (ANCHO - s.length())/2;
        String linea = "/";
        for( int i = 0 ; i < margen-2 ; i++ ){
            linea += "-";
        }
        linea += " " + s.toUpperCase() + " ";
        for( int i = 0 ; linea.length() < ANCHO-1 ; i++ ){
            linea += "-";
        }
        linea += "\\";
        out.println( linea );
    }

    private void finMarco( PrintStream out ){
        out.print( "\\" );
        for( int i = 0 ; i < ANCHO-2; i++ ){
            out.print( "-" );
        }
        out.println( "/");
    }

    
    private void borrarPantalla(PrintStream out) {
        for( int i = 0 ; i < ALTO*2 ; i++ ){
            out.println();
        }
    }

    @Override
    public Pantalla execute(Scanner in, PrintStream out) {
        Opcion[] opciones = opciones();
        int option = readOption(in, out, 0, opciones.length-1);
        return opciones[option].menu();
    }

    
    abstract public Opcion[] opciones();
}
