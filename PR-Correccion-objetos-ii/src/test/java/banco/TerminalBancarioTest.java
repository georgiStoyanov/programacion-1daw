package banco;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;


import org.junit.Test;

public class TerminalBancarioTest {

	@Test
	public void terminalComienzaSinProductos(){
		TerminalBancario tb = new TerminalBancario();
		assertTrue( "Un terminal bancario nuevo no debe tener productos", tb.getProductos().getNumero() == 0 );
	}
	
	@Test
	public void terminalCreaCuentaConTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario c = tb.creaCuenta("pepe");
		assertTrue( "la cuenta creada para pepe debe tener titular pepe:" + c, c.getTitular().equals("pepe") );
	}

	@Test
	public void terminalCreaTarjetaConTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario c = tb.creaTarjeta("pepe");
		assertTrue( "la tarjeta creada para pepe debe tener titular pepe:" + c, c.getTitular().equals("pepe") );
	}

	@Test
	public void terminalCreaDepositoConTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario c = tb.creaDeposito("pepe", 10);
		assertTrue( "el deposito creado para pepe debe tener titular pepe:" + c, c.getTitular().equals("pepe") );
	}
	
	@Test
	public void terminalCreaVariasCuentasParaTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario pb1 = tb.creaCuenta("pepe");
		ProductoBancario pb2 = tb.creaCuenta("pepe");
		
		assertTrue( "Dos cuentas para pepe deben no ser equals:" + pb1 + " -- " + pb2, !pb1.equals(pb2) );
		assertTrue( "Dos cuentas para pepe deben tener codigos distintos:" + pb1 + " -- " + pb2, pb1.getCodigo() != pb2.getCodigo() );
	}
	
	@Test
	public void terminalCreaVariasTarjetasParaTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario pb1 = tb.creaTarjeta("pepe");
		ProductoBancario pb2 = tb.creaTarjeta("pepe");
		
		assertTrue( "Dos tarjetas para pepe deben no ser equals:" + pb1 + " -- " + pb2, !pb1.equals(pb2) );
		assertTrue( "Dos tarjetas para pepe deben tener codigos distintos:" + pb1 + " -- " + pb2, pb1.getCodigo() != pb2.getCodigo() );
	}
	
	@Test
	public void terminalCreaVariosDepositosParaTitular(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario pb1 = tb.creaDeposito("pepe",10);
		ProductoBancario pb2 = tb.creaDeposito("pepe",10);
		
		assertTrue( "Dos depositos para pepe deben no ser equals:" + pb1 + " -- " + pb2, !pb1.equals(pb2) );
		assertTrue( "Dos depositos para pepe deben tener codigos distintos:" + pb1 + " -- " + pb2, pb1.getCodigo() != pb2.getCodigo() );
	}
	
	@Test
	public void terminalCreaVariosProductos(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("a");
		tb.creaCuenta("a");
		tb.creaCuenta("a");
		assertTrue( "Tras crear 3 productos hay:" + tb.getProductos().getNumero(), 3 == tb.getProductos().getNumero() );
	}
	
	@Test
	public void terminalCreaVariosProductosParaCliente(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaTarjeta("pepe");
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepe",10);
		Lista l = tb.productosDeTitular("pepe");
		assertTrue( "Tras crear 6 productos para pepe, pepe tiene:" + l, 6 == l.getNumero() );
	}
	
	@Test
	public void terminalCreaVariosProductosParaClienteSaldo(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe").movimientoSaldo(10);
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaTarjeta("pepe").movimientoSaldo(-10);
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepe",10);
		double s = tb.saldoDeTitular("pepe");
		assertTrue( "pepe tendria que tener saldo 20:" + s, 20 == s );
	}
	
	@Test
	public void terminalCreaVariosProductosParaClientesSaldo(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe").movimientoSaldo(10);
		tb.creaCuenta("pepa");
		tb.creaCuenta("pepe");
		tb.creaTarjeta("pepa").movimientoSaldo(-10);
		tb.creaTarjeta("pepe").movimientoSaldo(-10);
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepa",10);
		double s = tb.saldoDeTitular("pepe");
		assertTrue( "pepe tendria que tener saldo 10:" + s, 10 == s );
	}

	@Test
	public void terminalCreaVariosProductosParaClientes(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepa");
		tb.creaTarjeta("pepa");
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepe",10);
		Lista l = tb.productosDeTitular("pepe");
		assertTrue( "Tras crear 4 productos para pepe, pepe tiene:" + l, 4 == l.getNumero() );
	}

	
	@Test
	public void terminalSinClientes(){
		TerminalBancario tb = new TerminalBancario();
		Lista l = tb.productosDeTitular("pepe");
		assertTrue( "Si no hay productos, pepe no deberia tener productos:" + l, l.getNumero() == 0 );
	}
	
	@Test
	public void terminalSinClientesSaldo(){
		TerminalBancario tb = new TerminalBancario();
		double s = tb.saldoDeTitular("pepe");
		assertTrue( "Si no hay productos, pepe no deberia tener saldo:" + s, s == 0 );
	}
	
	@Test
	public void cancelarProductoIgual(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepa");
		ProductoBancario pb = tb.creaTarjeta("pepa");
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepe",10);
		int n = tb.getProductos().getNumero();
		assertTrue( "Tras crear 6 productos hay:" + n, n == 6 );
		tb.cancelaProducto(pb);
		n = tb.getProductos().getNumero();
		assertTrue( "Tras crear 6 productos y cancelar uno hay:" + n, n == 5 );
	}

	@Test
	public void cancelarProductoYLuegoCrear(){
		TerminalBancario tb = new TerminalBancario();
		ProductoBancario pb1 = tb.creaCuenta("pepe");
		ProductoBancario pb2 = tb.creaCuenta("pepe");
		ProductoBancario pb3 = tb.creaCuenta("pepa");
		
		tb.cancelaProducto(pb1);
		ProductoBancario pb4 = tb.creaCuenta("pepa");
		assertTrue( "parece que se reutilizan codigos para los productos, y se acaban creando duplicados",
				!pb3.equals(pb4) );
		
	}

	@Test
	public void cancelarProductoEquals(){
		TerminalBancario tb = new TerminalBancario();
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepe");
		tb.creaCuenta("pepa");
		ProductoBancario pb = tb.creaTarjeta("pepa");
		tb.creaDeposito("pepe",10);
		tb.creaDeposito("pepe",10);
		int n = tb.getProductos().getNumero();
		assertTrue( "Tras crear 6 productos hay:" + n, n == 6 );
		tb.cancelaProducto( new TarjetaDeCredito("pepa", pb.getCodigo() ) );
		n = tb.getProductos().getNumero();
		assertTrue( "Tras crear 6 productos y cancelar uno hay:" + n, n == 5 );
	}
	
}
