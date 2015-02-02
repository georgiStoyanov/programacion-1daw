package banco;

import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ProductoBancarioTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();

    @Test
    public void productoBancarioDebeSerAbstract() {
        boolean abstracta = Modifier.isAbstract(ProductoBancario.class.getModifiers());
        assertTrue("La clase ProductoBancario debe ser abstracta", abstracta);
    }

    @Test
    public void equalsCuentaString() {
        ProductoBancario c = new Cuenta("a", 0);
        assertTrue( "Una cuenta y un String no deben ser iguales", !c.equals("hola") );
    }

    @Test
    public void equalsDepositoString() {
    	ProductoBancario c = new Deposito("a", 0, 10 );
        assertTrue( "Una cuenta y un String no deben ser iguales", !c.equals("hola") );
    }

    @Test
    public void equalsTarjetaString() {
    	ProductoBancario c = new TarjetaDeCredito("a", 0);
        assertTrue( "Una cuenta y un String no deben ser iguales", !c.equals("hola") );
    }
    
    @Test
    public void equalsCuentaDepositoTrue() {
        Cuenta c = new Cuenta("a", 0);
        Deposito d = new Deposito("a", 0, 1);
        assertTrue(String.format("Deberian ser equals:%s y  %s", c, d), c.equals(d));
    }

    @Test
    public void equalsCuentaDepositoFalseTitular() {
        Cuenta c = new Cuenta("a", 0);
        Deposito d = new Deposito("b", 0, 1);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void equalsCuentaDepositoFalseCodigo() {
        Cuenta c = new Cuenta("a", 0);
        Deposito d = new Deposito("a", 1, 1);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void equalsCuentaTarjetaTrue() {
        Cuenta c = new Cuenta("a", 0);
        TarjetaDeCredito d = new TarjetaDeCredito("a", 0);
        assertTrue(String.format("Deberian ser equals:%s y  %s", c, d), c.equals(d));
    }

    @Test
    public void equalsCuentaTarjetaFalseTitular() {
        Cuenta c = new Cuenta("a", 0);
        TarjetaDeCredito d = new TarjetaDeCredito("B", 0);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void equalsCuentaTarjetaFalseCodigo() {
        Cuenta c = new Cuenta("a", 0);
        TarjetaDeCredito d = new TarjetaDeCredito("a", 1);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void equalsDepositoTarjetaTrue() {
        Deposito c = new Deposito("a", 0, 10);
        TarjetaDeCredito d = new TarjetaDeCredito("a", 0);
        assertTrue(String.format("Deberian ser equals:%s y  %s", c, d), c.equals(d));
    }

    @Test
    public void equalsDepositoTarjetaFalseTitular() {
        Deposito c = new Deposito("a", 0, 10);
        TarjetaDeCredito d = new TarjetaDeCredito("B", 0);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void equalsDepositoTarjetaFalseCodigo() {
        Deposito c = new Deposito("a", 0, 10);
        TarjetaDeCredito d = new TarjetaDeCredito("a", 1);
        assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d), !c.equals(d));
    }

    @Test
    public void laCuentaSeCreaACero() {
        assertTrue("El saldo inicial de una cuenta es cero", new Cuenta("a", 0).getSaldo() == 0);
    }

    @Test
    public void laTarjetaSeCreaACero() {
        assertTrue("El saldo inicial de una tarjeta es cero", new TarjetaDeCredito("a", 0).getSaldo() == 0);
    }

    
    @Test
    public void elDepositoSeCreaConSaldoIndicado() {
        Deposito d = new Deposito( "pepe", 100, 100 );
        assertTrue("El saldo inicial se puso a 100:" + d , d.getSaldo() == 100);
    }

    @Test
    public void elDepositoNoSeCreaConSaldoNegativo() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "No se debe crear un deposito con saldo negativo" );
        new Deposito("a", 0, -1);
    }

    @Test
    public void elDepositoNoSePuedeModificarPositivo1() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "No se debe modificar el saldo de un deposito" );
        new Deposito("a", 0, 0).movimientoSaldo(1);
    }

    @Test
    public void elDepositoNoSePuedeModificarPositivo2() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "No se debe modificar el saldo de un deposito" );
        new Deposito("a", 0, 10).movimientoSaldo(1);
    }

    
    @Test
    public void elDepositoNoSePuedeModificarNegativo1() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "No se debe modificar el saldo de un deposito" );
        new Deposito("a", 0, 0).movimientoSaldo(-1);
    }

    @Test
    public void elDepositoNoSePuedeModificarNegativo2() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "No se debe modificar el saldo de un deposito" );
        new Deposito("a", 0, 10).movimientoSaldo(-1);
    }

    @Test
    public void laCuentaNoPuedeTenerDescubierto() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "La cuenta no puede tener descubierto" );
        new Cuenta("a", 0).movimientoSaldo(-1);
    }

    @Test
    public void laTarjetaNoPuedeModificarPositivo() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "La tarjeta no puede tener movimientos positivos" );
        new TarjetaDeCredito("a", 0).movimientoSaldo(1);
    }

    @Test
    public void laTarjetaPuedeModificarNegativo() {
        ProductoBancario b = new TarjetaDeCredito("a", 0);
        b.movimientoSaldo(-1);
        b.movimientoSaldo(-1);
        assertTrue("El saldo tras -1 y -1 deberia ser -2: " + b, b.getSaldo() == -2);
    }

    @Test
    public void laTarjetaSoloPuedeModificarNegativo() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "La tarjeta no puede tener movimientos positivos" );
        ProductoBancario b = new TarjetaDeCredito("a", 0);
        b.movimientoSaldo(-100);
        b.movimientoSaldo(1);
    }

    @Test
    public void laCuentaPuedeModificarPositivoYNegativo() {
        ProductoBancario b = new Cuenta("a", 0);
        b.movimientoSaldo(100);
        b.movimientoSaldo(-1);
        assertTrue("El saldo tras 100 y -1 deberia ser 99: " + b, b.getSaldo() == 99);
    }

    @Test
    public void laCuentaPuedeModificarPositivoYNegativoPeroNoDescubierto() {
    	thrown.expect( Exception.class );
    	//thrown.expectMessage( "La cuenta no puede tener descubiertos" );
    	
        ProductoBancario b = new Cuenta("a", 0);
        b.movimientoSaldo(100);
        b.movimientoSaldo(100);
        b.movimientoSaldo(-1);
        assertTrue("El saldo tras 100, 100 y -1 deberia ser 199: " + b, b.getSaldo() == 199);
        b.movimientoSaldo(-200);
    }

    @Test
    public void laCuentaPuedeQuedarACero() {
        ProductoBancario b = new Cuenta("a", 0);
        b.movimientoSaldo(100);
        b.movimientoSaldo(100);
        b.movimientoSaldo(-1);
        b.movimientoSaldo(-199);
        assertTrue("El saldo tras 100, 100 ,-1 , -199 deberia ser 0: " + b, b.getSaldo() == 0);
     }

}
