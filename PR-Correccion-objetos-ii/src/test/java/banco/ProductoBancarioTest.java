package banco;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;

import org.junit.Test;

public class ProductoBancarioTest {

	@Test
	public void productoBancarioDebeSerAbstract() {
		boolean abstracta = Modifier.isAbstract(ProductoBancario.class
				.getModifiers());
		assertTrue("La clase ProductoBancario debe ser abstracta", abstracta);
	}

	@Test
	public void equalsCuentaString() {
		ProductoBancario c = new Cuenta("a", 0);
		assertTrue("Una cuenta y un String no deben ser iguales",
				!c.equals("hola"));
	}

	@Test
	public void equalsDepositoString() {
		ProductoBancario c = new Deposito("a", 0, 10);
		assertTrue("Una cuenta y un String no deben ser iguales",
				!c.equals("hola"));
	}

	@Test
	public void equalsTarjetaString() {
		ProductoBancario c = new TarjetaDeCredito("a", 0);
		assertTrue("Una cuenta y un String no deben ser iguales",
				!c.equals("hola"));
	}

	@Test
	public void equalsCuentaDepositoTrue() {
		Cuenta c = new Cuenta("a", 0);
		Deposito d = new Deposito("a", 0, 1);
		assertTrue(String.format("Deberian ser equals:%s y  %s", c, d),
				c.equals(d));
	}

	@Test
	public void equalsCuentaDepositoFalseTitular() {
		Cuenta c = new Cuenta("a", 0);
		Deposito d = new Deposito("b", 0, 1);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void equalsCuentaDepositoFalseCodigo() {
		Cuenta c = new Cuenta("a", 0);
		Deposito d = new Deposito("a", 1, 1);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void equalsCuentaTarjetaTrue() {
		Cuenta c = new Cuenta("a", 0);
		TarjetaDeCredito d = new TarjetaDeCredito("a", 0);
		assertTrue(String.format("Deberian ser equals:%s y  %s", c, d),
				c.equals(d));
	}

	@Test
	public void equalsCuentaTarjetaFalseTitular() {
		Cuenta c = new Cuenta("a", 0);
		TarjetaDeCredito d = new TarjetaDeCredito("B", 0);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void equalsCuentaTarjetaFalseCodigo() {
		Cuenta c = new Cuenta("a", 0);
		TarjetaDeCredito d = new TarjetaDeCredito("a", 1);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void equalsDepositoTarjetaTrue() {
		Deposito c = new Deposito("a", 0, 10);
		TarjetaDeCredito d = new TarjetaDeCredito("a", 0);
		assertTrue(String.format("Deberian ser equals:%s y  %s", c, d),
				c.equals(d));
	}

	@Test
	public void equalsDepositoTarjetaFalseTitular() {
		Deposito c = new Deposito("a", 0, 10);
		TarjetaDeCredito d = new TarjetaDeCredito("B", 0);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void equalsDepositoTarjetaFalseCodigo() {
		Deposito c = new Deposito("a", 0, 10);
		TarjetaDeCredito d = new TarjetaDeCredito("a", 1);
		assertTrue(String.format("No Deberian ser equals:%s y  %s", c, d),
				!c.equals(d));
	}

	@Test
	public void laCuentaSeCreaACero() {
		assertTrue("El saldo inicial de una cuenta es cero",
				new Cuenta("a", 0).getSaldo() == 0);
	}

	@Test
	public void laTarjetaSeCreaACero() {
		assertTrue("El saldo inicial de una tarjeta es cero",
				new TarjetaDeCredito("a", 0).getSaldo() == 0);
	}

	@Test
	public void elDepositoSeCreaConSaldoIndicado() {
		Deposito d = new Deposito("pepe", 100, 100);
		assertTrue("El saldo inicial se puso a 100:" + d, d.getSaldo() == 100);
	}

	@Test
	public void elDepositoNoSeCreaConSaldoNegativo() {
		try {
			new Deposito("a", 0, -1);
			fail("No se debe crear un deposito con saldo negativo");
		} catch (Exception e) {
		}
	}

	@Test
	public void elDepositoNoSePuedeModificarPositivo1() {
		try {
			new Deposito("a", 0, 0).movimientoSaldo(1);
			fail("No se debe modificar el saldo de un deposito");
		} catch (Exception e) {
		}
	}

	@Test
	public void elDepositoNoSePuedeModificarPositivo2() {
		try {
			new Deposito("a", 0, 10).movimientoSaldo(1);
			fail("No se debe modificar el saldo de un deposito");
		} catch (Exception e) {
		}
	}

	@Test
	public void elDepositoNoSePuedeModificarNegativo1() {
		try {
			new Deposito("a", 0, 0).movimientoSaldo(-1);
			fail("No se debe modificar el saldo de un deposito");
		} catch (Exception e) {
		}

	}

	@Test
	public void elDepositoNoSePuedeModificarNegativo2() {

		try {
			new Deposito("a", 0, 10).movimientoSaldo(-1);
			fail("No se debe modificar el saldo de un deposito");
		} catch (Exception e) {
		}

	}

	@Test
	public void laCuentaNoPuedeTenerDescubierto() {
		try {
			new Cuenta("a", 0).movimientoSaldo(-1);
			fail("La cuenta no puede tener descubierto");
		} catch (Exception e) {
		}
	}

	@Test
	public void laTarjetaNoPuedeModificarPositivo() {
		try {
			new TarjetaDeCredito("a", 0).movimientoSaldo(1);
			fail("La tarjeta no puede tener movimientos positivos");
		} catch (Exception e) {

		}
	}

	@Test
	public void laTarjetaPuedeModificarNegativo() {
		ProductoBancario b = new TarjetaDeCredito("a", 0);
		b.movimientoSaldo(-1);
		b.movimientoSaldo(-1);
		assertTrue("El saldo tras -1 y -1 deberia ser -2: " + b,
				b.getSaldo() == -2);
	}

	@Test
	public void laTarjetaSoloPuedeModificarNegativo() {
		try {
			ProductoBancario b = new TarjetaDeCredito("a", 0);
			b.movimientoSaldo(-100);
			b.movimientoSaldo(1);
		} catch (Exception e) {
		}
	}

	@Test
	public void laCuentaPuedeModificarPositivoYNegativo() {
		ProductoBancario b = new Cuenta("a", 0);
		b.movimientoSaldo(100);
		b.movimientoSaldo(-1);
		assertTrue("El saldo tras 100 y -1 deberia ser 99: " + b,
				b.getSaldo() == 99);
	}

	@Test
	public void laCuentaPuedeModificarPositivoYNegativoPeroNoDescubierto() {

		try {
			ProductoBancario b = new Cuenta("a", 0);
			b.movimientoSaldo(100);
			b.movimientoSaldo(100);
			b.movimientoSaldo(-1);
			assertTrue("El saldo tras 100, 100 y -1 deberia ser 199: " + b,
					b.getSaldo() == 199);
			b.movimientoSaldo(-200);
			fail("La cuenta no puede tener descubiertos");
		} catch (Exception e) {

		}

	}

	@Test
	public void laCuentaPuedeQuedarACero() {
		ProductoBancario b = new Cuenta("a", 0);
		b.movimientoSaldo(100);
		b.movimientoSaldo(100);
		b.movimientoSaldo(-1);
		b.movimientoSaldo(-199);
		assertTrue("El saldo tras 100, 100 ,-1 , -199 deberia ser 0: " + b,
				b.getSaldo() == 0);
	}

}
