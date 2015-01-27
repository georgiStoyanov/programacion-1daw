package banco;

import java.io.PrintStream;
import java.util.Scanner;

public class PantallaDeProducto extends Menu {

    private TerminalBancario _terminal;
    private ProductoBancario _producto;
    private Pantalla _anterior;

    public PantallaDeProducto(Pantalla anterior, TerminalBancario terminal, ProductoBancario producto) {
        _producto = producto;
        _terminal = terminal;
        _anterior = anterior;
    }

    public String nombre() {
        return String.format( "%-20s (%03d) %10.2f€", _producto.getClass().getSimpleName(), _producto.getCodigo() ,_producto.getSaldo() );
    }

    @Override
    public String[] cabecera() {
        return new String[]{ String.format( "Operaciones sobre %s (%03d) del titular %s", _producto.getClass().getSimpleName(), _producto.getCodigo(), _producto.getTitular() )};
    }

    private boolean preguntarPorSiNo( String pregunta, Scanner in, PrintStream out ){
        String respuesta = "";
        do{
            out.print( pregunta + " (S/N):" );
            respuesta = in.nextLine();
            respuesta = respuesta.toUpperCase();
        }while( !respuesta.equals("S") && !respuesta.equals("N") );
        
        return respuesta.equals("S");
    }


    @Override
    public Opcion[] opciones() {
        return new Opcion[] {
                new Opcion(new Pantalla() {

                    @Override
                    public Pantalla execute(Scanner in, PrintStream out) {
                        boolean borrar = preguntarPorSiNo("¿Desea borrar realmente el producto?", in, out);
                        if( borrar ){
                            _terminal.cancelaProducto(_producto);
                            out.println( "Producto borrado. Pulse intro para continuar.");
                            in.nextLine();
                            return _anterior;
                        }
                        else{
                            return PantallaDeProducto.this;
                        }
                    }

                    @Override
                    public String nombre() {
                        return "Borrar producto";
                    }

                }),

                new Opcion(new Pantalla() {

                    @Override
                    public Pantalla execute(Scanner in, PrintStream out) {
                        double movimiento = preguntarPorNumero("Importe del movimiento", in, out);
                        try{
                            _producto.movimientoSaldo(movimiento);
                            out.println( "Movimiento realizado con exito. Pulse intro para continuar." );
                        }
                        catch( Exception e ){
                            out.println( "No se pudo realizar el movimiento. Pulse intro para continuar." );
                        }
                        in.nextLine();
                        return PantallaDeProducto.this;
                    }

                    @Override
                    public String nombre() {
                        return "Intentar movimiento";
                    }

                }),
                
                new Opcion( new Pantalla(){

                    @Override
                    public String nombre() {
                        return "Menú anterior";
                    }

                    @Override
                    public Pantalla execute(Scanner in, PrintStream out) {
                        return _anterior;
                    }
                    
                })

        };
    }

}
