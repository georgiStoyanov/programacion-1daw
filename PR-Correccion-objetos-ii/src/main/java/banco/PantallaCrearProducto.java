package banco;

import java.io.PrintStream;
import java.util.Scanner;

public class PantallaCrearProducto extends Pantalla {

    private Pantalla _anterior;
    private String _titular;
    private TerminalBancario _terminal;

    public PantallaCrearProducto(Pantalla menuDeCliente, String titular, TerminalBancario terminal) {
        _anterior = menuDeCliente;
        _titular = titular;
        _terminal = terminal;
    }

    @Override
    public String nombre() {
        return "Creación de producto para:" + _titular;
    }

    private String tipoProducto(Scanner in, PrintStream out) {
        String ret = "";
        do {
            out.print("Tipo de producto a crear ( (C)uenta,(T)arjeta,(D)eposito ):");
            ret = in.nextLine();
            ret = ret.toLowerCase();
        } while (!ret.equals("t") && !ret.equals("c") && !ret.equals("d"));
        return ret;
    }

    @Override
    public Pantalla execute(Scanner in, PrintStream out) {
        ProductoBancario pb;
        switch (tipoProducto(in, out)) {
        case "t":
            pb = _terminal.creaTarjeta(_titular);
            break;
        case "c":
            pb = _terminal.creaCuenta(_titular);
            break;
        case "d":
            double saldo = preguntarPorNumero("Saldo inicial", in, out);
            pb = _terminal.creaDeposito(_titular, saldo);
            break;
        default:
            throw new IllegalStateException();
        }
        out.println( "Producto creado. Pulse intro para continuar");
        in.nextLine();
        return _anterior;
    }
}
