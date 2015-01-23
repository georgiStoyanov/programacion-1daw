package banco;

import java.io.PrintStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Pantalla salir = new Pantalla("Salir del programa"){
            @Override
            public Pantalla execute(Scanner in, PrintStream out) {
                out.println( "Saliendo...");
                System.exit(0);
                return null;
            }
        };
        
        Pantalla nada = new Pantalla("Nada de nada"){
            public Pantalla execute(Scanner in, PrintStream out) {
                out.println( "Nada que ver");
                return null;
            };
        };
        
        NumericOptionMenu root = new NumericOptionMenu( "Menu principal", new Menu.Opcion[]{ 
                new Menu.Opcion( nada ),
                new Menu.Opcion( salir )
        } );
        
        Pantalla.ejecutaPantallaPrincipal(root, new Scanner(System.in),System.out);
    }
}
