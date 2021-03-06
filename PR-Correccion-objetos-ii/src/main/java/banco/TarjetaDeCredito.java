package banco;


/**
 * 
 */
public class TarjetaDeCredito extends ProductoBancario{

    /**
     *
     */
    public TarjetaDeCredito( String titular, int codigo ){
        super(titular,codigo);    
    }

    /**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    @Override
    public void movimientoSaldo( double movimiento ){
        if( movimiento > 0 ){
            throw new IllegalArgumentException();
        }
        super.movimientoSaldo(movimiento);
    }
}
