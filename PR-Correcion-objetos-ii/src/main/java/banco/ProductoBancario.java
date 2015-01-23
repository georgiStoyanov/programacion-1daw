package banco;


/**
 * 
 */
public class ProductoBancario{

    /**
     *
     */
    public ProductoBancario( String titular, int codigo ){
    }

    /**
     * Saldo actual del producto (positivo, a favor del cliente)
     */
    public double getSaldo(){
    }

    /**
     * El codigo del producto
     */
    public int getCodigo(){
    }

    /**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    public void movimientoSaldo( double movimiento ){
    }

    /**
     * Dos productos son iguales si tienen el mismo cliente, el mismo codigo y el mismo tipo (tarjeta, cuenta, deposito,...) 
     */
    @Override
    public boolean equals( Object o ){
    }

}
