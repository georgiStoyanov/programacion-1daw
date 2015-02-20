package banco;


/**
 * 
 */
public class Deposito extends ProductoBancario{

    /**
     *
     */
    public Deposito( String titular, int codigo, double saldo ){
        super(titular,codigo);
        if( saldo < 0 ){
            throw new IllegalArgumentException();
        }
        super.movimientoSaldo( saldo );
    }

    /**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    @Override
    public void movimientoSaldo( double movimiento ){
        throw new IllegalArgumentException();
    }
}
