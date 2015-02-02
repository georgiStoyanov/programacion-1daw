package banco;


/**
 * 
 */
public class Cuenta extends ProductoBancario{

    /**
     *
     */
    public Cuenta( String titular, int codigo ){
        super(titular,codigo);    
    }

    /**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    @Override
    public void movimientoSaldo( double movimiento ){
        double saldo = getSaldo();
        if( saldo + movimiento < 0 ){
            throw new IllegalArgumentException();
        }
        super.movimientoSaldo(movimiento);
    }
}
