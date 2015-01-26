package banco;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Pantalla {
    
    abstract public String nombre();
    
    abstract public Pantalla execute( Scanner in, PrintStream out );
    
    public static void ejecutaPantallaPrincipal( Pantalla m, Scanner in, PrintStream out ){
        Pantalla currentMenu = m;
        while( true ){
            currentMenu = currentMenu.execute(in, out);
            if( currentMenu == null ){
                currentMenu = m;
            }
        }
    }
}
