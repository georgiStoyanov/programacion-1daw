package banco;


/**
 * 
 */
public class ProductoBancario{

    /**
     *
     */
    public ProductoBancario( String titular, int codigo ){
	_titular = titular;
	_codigo = codigo;
	_saldo = 0;
    }

    /**
     * Saldo actual del producto (positivo, a favor del cliente)
     */
    public double getSaldo(){
	return _saldo;
    }

    /**
     * El codigo del producto
     */
    public int getCodigo(){
	return _codigo;
    }
       
    /**
     * El titular del producto
     */
    public String getTitular(){
       return _titular;
    }


    /**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    public void movimientoSaldo( double movimiento ){
       _saldo += movimiento;
    }

    /**
     * Dos productos son iguales si tienen el mismo cliente, el mismo codigo y el mismo tipo (tarjeta, cuenta, deposito,...) 
     */
    @Override
    public boolean equals( Object o ){
       if( !(o instanceof ProductoBancario) ){
          return false;
       }
       ProductoBancario pb = (ProductoBancario)o;
       return o.getTitular().equals( getTitular() ) && o.getCodigo() == getCodigo() && o.getClass().equals( getClass() );
    }
}
