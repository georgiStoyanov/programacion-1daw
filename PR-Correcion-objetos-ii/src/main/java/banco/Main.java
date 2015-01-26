package banco;

import java.io.PrintStream;

import banco.Menu.Opcion;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TerminalBancario banco = crearTerminalBancario();

        Pantalla salir = new Pantalla() {
            @Override
            public Pantalla execute(Scanner in, PrintStream out) {
                out.println("Saliendo...");
                System.exit(0);
                return null;
            }

            @Override
            public String nombre() {
                return "Salir del programa";
            }
        };

        Pantalla clientes = new MenuDeCliente(null, banco);

        NumericOptionMenu root = new NumericOptionMenu(new Opcion[] {
                new Opcion(clientes),
                new Opcion(salir)
        }) {

            @Override
            public String nombre() {
                return "Menu principal";
            }

        };

        Pantalla.ejecutaPantallaPrincipal(root, new Scanner(System.in), System.out);
    }

    private static TerminalBancario crearTerminalBancario() {
        TerminalBancario ret = new TerminalBancario();

        Random r = new Random();
        String[] titulares = { "Alvaro", "Pepe", "Maria" };
        for (String titular : titulares) {
            Cuenta c = ret.creaCuenta(titular);
            c.movimientoSaldo(r.nextInt(1000));
            TarjetaDeCredito t = ret.creaTarjeta(titular);
            t.movimientoSaldo(-r.nextInt(100));
            ret.creaDeposito(titular, r.nextInt(500));
        }

        return ret;
    }
}
