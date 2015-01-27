package banco;

import java.io.PrintStream;
import java.util.*;

public class ClientsMenu extends Menu {

    private TerminalBancario _terminal;

    public ClientsMenu(String c, TerminalBancario terminal ) {
        super(c);
        _terminal = terminal;
    }

    private String[] getTitulares(){
        Set s = new HashSet<String>();
        Lista l = _terminal.getProductos();
        for( int i = 0 ; i < l.getNumero() ; i++ ){
            s.add( ((ProductoBancario)l.getObjeto(i)).getTitular() );
        }
        return (String[])s.toArray(new String[0]);
    }

    private class MenuTitular extends Menu{
        private String _titular;
        public MenuTitular(String titular){
            super( "Menu del cliente: " + titular );
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
            ret[0] = new 
        }

    }

    @Override
    public String[] cabecera(){
        return new String[0];
    }

    @Override 
    public Opcion[] opciones(){
        String[] titulares = getTitulares();
        Opcion[] ret = new Opcion[titulares.length];
        for( int i = 0 ; i < ret.length ; i++ ){
            String t = titulares[i];
            ret[i] = new Opcion(t, MenuTitular(t));
        }

        return _opciones.clone();
    }

}
