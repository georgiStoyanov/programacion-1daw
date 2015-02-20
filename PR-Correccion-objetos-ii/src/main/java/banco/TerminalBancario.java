package banco;


/**
 * 
 */
public class TerminalBancario{

    private Lista<ProductoBancario> _productos = new Lista<ProductoBancario>();

    /**
     * Lista de todos los productos del banco
     */
    public Lista<ProductoBancario> getProductos(){
       return _productos;
    }

    /**
     * Lista de los productos de un titular 
     */
    public Lista<ProductoBancario> productosDeTitular( String titular ){
       Lista<ProductoBancario> ret = new Lista<ProductoBancario>();
       Lista<ProductoBancario> p = getProductos();
       for( int i = 0 ; i < p.getNumero() ; i += 1 ){
         ProductoBancario pb = p.getObjeto(i);
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
       Lista<ProductoBancario> p = productosDeTitular(titular);
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
       Lista<ProductoBancario> p = getProductos();
       
       int indice = p.indiceDe(pb);
       if( indice == -1 ){
    	   return false;
       }
       p.borra(indice);
       return true;
    }

    private int codigoLibrePara_basadoEnLoQueHay( String titular ){
       Lista<ProductoBancario> p = productosDeTitular(titular);
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

    private int _ultimoCodigoDado = 0;

    private int codigoLibrePara(String titular) {
		_ultimoCodigoDado += 1;
		return _ultimoCodigoDado;
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
