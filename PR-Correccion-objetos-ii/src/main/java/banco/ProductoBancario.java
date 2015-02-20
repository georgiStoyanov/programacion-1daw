package banco;

/**
 * 
 */
public abstract class ProductoBancario {

    private String _titular;
    private int _codigo;
    private double _saldo;

    /**
     *
     */
    public ProductoBancario(String titular, int codigo) {
        _titular = titular;
        _codigo = codigo;
        _saldo = 0;
    }

    /**
     * Saldo actual del producto (positivo, a favor del cliente)
     */
    public double getSaldo() {
        return _saldo;
    }

    /**
     * El codigo del producto
     */
    public int getCodigo() {
        return _codigo;
    }

    /**
     * El titular del producto
     */
    public String getTitular() {
        return _titular;
    }
    
    @Override
    public String toString() {
    	return String.format( "(titular %s) (codigo %d) (tipo %s) (saldo %f)", getTitular(), getCodigo(), getTipo(), getSaldo() );
    }
    
    

    private String getTipo(){
    	return getClass().getSimpleName();
    }

	/**
     * Movimiento de saldo, a sumar al saldo. del producto.
     */
    public void movimientoSaldo(double movimiento) {
        _saldo += movimiento;
    }

    /**
     * Dos productos son iguales si tienen el mismo cliente, el mismo codigo y
     * el mismo tipo (tarjeta, cuenta, deposito,...)
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProductoBancario)) {
            return false;
        }
        ProductoBancario pb = (ProductoBancario) o;
        return pb.getTitular().equals(getTitular()) && pb.getCodigo() == getCodigo();
    }
    
    public static void main(String[] args) {
		System.out.println( new Cuenta("pepe", 1 ) );
		System.out.println( new TarjetaDeCredito("pepe", 1 ) );
	}
}
