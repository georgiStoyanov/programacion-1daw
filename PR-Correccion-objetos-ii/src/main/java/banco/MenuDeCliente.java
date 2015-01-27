package banco;

import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class MenuDeCliente extends Menu {

    private TerminalBancario _terminal;
    private Pantalla _anterior;

    public MenuDeCliente(Pantalla anterior, TerminalBancario terminal ) {
        _terminal = terminal;
        _anterior = anterior;
    }

    private Lista getTitulares(){
        Lista ret = new Lista();
        Lista l = _terminal.getProductos();
        for( int i = 0 ; i < l.getNumero() ; i++ ){
            String titular = ((ProductoBancario)l.getObjeto(i)).getTitular();
            if( ret.indiceDe(titular) == -1 ){
                ret.agrega(titular);
            }
        }
        return ret;
    }
    

    private class MenuTitular extends Menu{
        private String _titular;
        public MenuTitular(String titular){
            _titular = titular;
        }

        @Override
        public String[] cabecera(){
            double saldo = _terminal.saldoDeTitular(_titular);
            return new String[]{ String.format( "Saldo disponible: %.2f", saldo ) };
        }

        @Override 
        public Opcion[] opciones(){
            Lista productos = _terminal.productosDeTitular(_titular);
            Opcion[] ret = new Opcion[productos.getNumero()+2];
            for( int i = 0 ; i < productos.getNumero() ; i++ ){
                ProductoBancario pb = (ProductoBancario) productos.getObjeto(i);
                ret[i] = new Opcion( new PantallaDeProducto(MenuTitular.this, _terminal, pb) );
            }
            ret[ret.length-2] = new Opcion( "Crear un producto", new PantallaCrearProducto(MenuTitular.this,_titular,_terminal) );
            ret[ret.length-1] = new Opcion( "Pantalla anterior", MenuDeCliente.this );
            return ret;
        }

        @Override
        public String nombre() {
            return "Menu del cliente: " + _titular;
        }

    }

    @Override
    public String[] cabecera(){
        return new String[]{ "Estos son todos los clientes existentes en el banco" };
    }

    private class PantallaNuevoCliente extends Pantalla{

        @Override
        public String nombre() {
            return "Crear producto para nuevo titular";
        }

        @Override
        public Pantalla execute(Scanner in, PrintStream out) {
            out.print( "Nombre del nuevo titular:" );
            String nuevo = in.nextLine();
            return new MenuTitular(nuevo);
        }
        
    }
    
    @Override 
    public Opcion[] opciones(){
        Lista titulares = getTitulares();
        Opcion[] ret = new Opcion[titulares.getNumero()+2];
        for( int i = 0 ; i < titulares.getNumero() ; i++ ){
            String t = (String) titulares.getObjeto(i);
            ret[i] = new Opcion(t, new MenuTitular(t));
        }
        ret[titulares.getNumero()] = new Opcion(  new PantallaNuevoCliente() );
        ret[titulares.getNumero()+1] = new Opcion( "Volver al menú anterior", _anterior );

        return ret;
    }

    @Override
    public String nombre() {
        return "Todos los clientes";
    }

}
