package banco;


/**
 * 
 */
public class TerminalBancario{


    /**
     * Lista de todos los productos del banco
     */
    public Lista productos(){
    }

    /**
     * Lista de los productos de un titular 
     */
    public Lista productosDeTitular( String titular ){
    }

    /**
     * Saldo total del titular (la suma de los saldos de sus productos)
     */
    public double saldoDeTitular( String titular ){
    }

    /**
     * Quita un producto de la lista de productos del banco (mirando que producto es equals al pasado) 
     * @returns Si el producto no existia, devuelve false.
     */
    public boolean cancelaProducto(ProductoBancario pb){
    }

    /**
     * Crea una nueva cuenta para un titular y la agrega a la lista de productos del banco.
     * La cuenta comienza con saldo 0. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public Cuenta creaCuenta(String titular){
    }


    /**
     * Crea una nueva tarjeta para un titular y la agrega a la lista de productos del banco.
     * La tarjeta comienza con saldo 0. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public TarjetaDeCredito creaTarjeta(String titular){
    }

    /**
     * Crea un deposito para un titular y lo agrega a la lista de productos del banco.
     * El deposito tiene el saldo indicado. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public Deposito creaDeposito(String titular, double saldo){
    }
}
