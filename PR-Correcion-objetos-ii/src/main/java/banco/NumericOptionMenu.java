package banco;

import java.io.PrintStream;
import java.util.Scanner;

public class NumericOptionMenu extends Menu {

    public NumericOptionMenu(String c, Opcion[] os) {
        super(c, os);
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
    
    public void render( PrintStream out ){
        out.println( "Menu de " + nombre().toUpperCase() );
    }
    


    @Override
    public Pantalla execute(Scanner in, PrintStream out) {
        Opcion[] opciones = opciones();
        int option = readOption(in, out, 0, opciones.length-1);
        return opciones[option].menu();
    }

}
