package banco;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Menu extends Pantalla {

    private static int ALTO = 20;
    private static int ANCHO = 60;

    abstract class Caja{
        abstract char ESQUINA_ARRIBA_IZQUIERDA();
        abstract char ESQUINA_ARRIBA_DERECHA();
        abstract char ESQUINA_ABAJO_IZQUIERDA();
        abstract char ESQUINA_ABAJO_DERECHA();
        abstract char LADO_VERTICAL();
        abstract char LADO_HORIZONTAL();
    }
    
    class CajaAscii extends Caja{
        char ESQUINA_ARRIBA_IZQUIERDA(){return '/';};
        char ESQUINA_ARRIBA_DERECHA(){return '\\';};
        char ESQUINA_ABAJO_IZQUIERDA(){return'\\';};
        char ESQUINA_ABAJO_DERECHA(){return'/';};
        char LADO_VERTICAL(){return '|';};
        char LADO_HORIZONTAL(){return '-';};
    }

    class CajaUnicode extends Caja{
        char ESQUINA_ARRIBA_IZQUIERDA(){return '\u250c';};
        char ESQUINA_ARRIBA_DERECHA(){return '\u2510';};
        char ESQUINA_ABAJO_IZQUIERDA(){return'\u2514';};
        char ESQUINA_ABAJO_DERECHA(){return'\u2518';};
        char LADO_VERTICAL(){return '\u2502';};
        char LADO_HORIZONTAL(){return '\u2500';};
    }
    
    
    private Caja caja = new CajaUnicode();

    public static class Opcion {
        private Pantalla _accion;
        private String _msg;

        public Opcion(String nombre, Pantalla accion) {
            _msg = nombre;
            _accion = accion;
        }

        public Opcion(Pantalla accion) {
            this(accion.nombre(), accion);
        }

        public String nombre() {
            return _msg;
        }

        public Pantalla menu() {
            return _accion;
        }
    }

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

    public void render(PrintStream out) {
        borrarPantalla(out);
        inicioMarco(nombre(), out);

        lineaEnMarco(" ", out);

        String[] cs = cabecera();
        for (int i = 0; cs != null && i < cs.length; i++) {
            lineaEnMarco(cs[i], out);
        }

        lineaEnMarco(" ", out);

        Opcion[] ops = opciones();
        for (int i = 0; i < ops.length; i++) {
            lineaEnMarco(String.format("%d .- %s", i, ops[i].nombre()), out);
        }

        lineaEnMarco(" ", out);

        finMarco(out);

        out.println();
        out.println();
        out.println();
    }

    private void lineaEnMarco(String s, PrintStream out) {
        int anchoInterior = ANCHO - 5;
        String linea = String.format("%c  %-" + (anchoInterior) + "s %c",
                caja.LADO_VERTICAL(),
                s.substring(0, Math.min(anchoInterior, s.length())),
                caja.LADO_VERTICAL());
        out.println(linea);
    }

    private void inicioMarco(String s, PrintStream out) {
        int margen = (ANCHO - s.length()) / 2;
        String linea = "" + caja.ESQUINA_ARRIBA_IZQUIERDA();
        for (int i = 0; i < margen - 2; i++) {
            linea += caja.LADO_HORIZONTAL();
        }
        linea += " " + s.toUpperCase() + " ";
        for (int i = 0; linea.length() < ANCHO - 1; i++) {
            linea += caja.LADO_HORIZONTAL();
        }
        linea += caja.ESQUINA_ARRIBA_DERECHA();
        out.println(linea);
    }

    private void finMarco(PrintStream out) {
        out.print(caja.ESQUINA_ABAJO_IZQUIERDA());
        for (int i = 0; i < ANCHO - 2; i++) {
            out.print(caja.LADO_HORIZONTAL());
        }
        out.println(caja.ESQUINA_ABAJO_DERECHA());
    }

    private void borrarPantalla(PrintStream out) {
        for (int i = 0; i < ALTO * 2; i++) {
            out.println();
        }
    }

    @Override
    public Pantalla execute(Scanner in, PrintStream out) {
        Opcion[] opciones = opciones();
        int option = readOption(in, out, 0, opciones.length - 1);
        return opciones[option].menu();
    }

    abstract public Opcion[] opciones();
    

}
