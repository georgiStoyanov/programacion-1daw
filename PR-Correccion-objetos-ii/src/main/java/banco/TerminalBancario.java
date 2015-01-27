package banco;


/**
 * 
 */
public class TerminalBancario{

    private Lista _productos = new Lista();

    /**
     * Lista de todos los productos del banco
     */
    public Lista getProductos(){
       return _productos;
    }

    /**
     * Lista de los productos de un titular 
     */
    public Lista productosDeTitular( String titular ){
       Lista ret = new Lista();
       Lista p = getProductos();
       for( int i = 0 ; i < p.getNumero() ; i += 1 ){
         ProductoBancario pb = (ProductoBancario)p.getObjeto(i);
         if( pb.getTitular().equals( titular ) ){
           ret.agrega( pb );
         }
       }
       return ret;
    }

    /**
     * Saldo total del titular (la suma de los saldos de sus productos)
     */
    public double saldoDeTitular( String titular ){
       Lista p = productosDeTitular(titular);
       double ret = 0;
       for( int i = 0 ; i < p.getNumero(); i += 1 ){
         ret += ((ProductoBancario)p.getObjeto(i)).getSaldo();
       }
       return ret;
    }

    /**
     * Quita un producto de la lista de productos del banco (mirando que producto es equals al pasado) 
     * @returns Si el producto no existia, devuelve false.
     */
    public boolean cancelaProducto(ProductoBancario pb){
       Lista p = getProductos();
       boolean borrado = false;
       for( int i = 0 ; i < p.getNumero() && !borrado; i += 1 ){
         ProductoBancario candidato = (ProductoBancario)p.getObjeto(i);
         if( candidato.equals( pb ) ){
           p.borra(i);
           borrado = true;
         }
       }
       return borrado;
    }

    private int codigoLibrePara( String titular ){
       Lista p = productosDeTitular(titular);
       int maximo = 0;
       for( int i = 0 ; i < p.getNumero(); i += 1 ){
         ProductoBancario candidato = (ProductoBancario)p.getObjeto(i);
         maximo = Math.max( maximo, candidato.getCodigo() );
       }
       return maximo+1;
    }

    /**
     * Crea una nueva cuenta para un titular y la agrega a la lista de productos del banco.
     * La cuenta comienza con saldo 0. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public Cuenta creaCuenta(String titular){
       int codigo = codigoLibrePara(titular);
       Cuenta ret = new Cuenta( titular, codigo );
       _productos.agrega(ret);
       return ret;
    }


    /**
     * Crea una nueva tarjeta para un titular y la agrega a la lista de productos del banco.
     * La tarjeta comienza con saldo 0. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public TarjetaDeCredito creaTarjeta(String titular){
       int codigo = codigoLibrePara(titular);
       TarjetaDeCredito ret = new TarjetaDeCredito( titular, codigo );
       _productos.agrega(ret);
       return ret;    
    }

    /**
     * Crea un deposito para un titular y lo agrega a la lista de productos del banco.
     * El deposito tiene el saldo indicado. El codigo debera calcularlo el propio metodo, para que no coincida con otro del titular
     */
    public Deposito creaDeposito(String titular, double saldo){
       int codigo = codigoLibrePara(titular);
       Deposito ret = new Deposito( titular, codigo, saldo );
       _productos.agrega(ret);
       return ret;
    }
}
