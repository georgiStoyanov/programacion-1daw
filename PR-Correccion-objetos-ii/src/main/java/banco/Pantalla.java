package banco;

import java.io.PrintStream;
import java.util.Scanner;

public abstract class Pantalla {
    
    abstract public String nombre();
    
    abstract public Pantalla execute( Scanner in, PrintStream out );
    
    public static void ejecutaPantallaPrincipal( Pantalla m, Scanner in, PrintStream out ){
        Pantalla currentScreen = m;
        while( true ){
            currentScreen = currentScreen.execute(in, out);
            if( currentScreen == null ){
                currentScreen = m;
            }
        }
    }
    
    protected double preguntarPorNumero( String pregunta, Scanner in, PrintStream out ){
        boolean ok = false;
        String respuesta = "";
        do{
            out.print( pregunta + ":" );
            respuesta = in.nextLine();
            ok = true;
            try{
                Double.parseDouble(respuesta);
            }
            catch( NumberFormatException e ){
                ok = false;
            }
        }while( !ok );
        
        return Double.parseDouble(respuesta);
    }

}
