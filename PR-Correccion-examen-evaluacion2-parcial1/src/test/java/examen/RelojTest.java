package examen;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RelojTest {

	@Rule
	public Timeout globalTimeout = new Timeout(10000);

	@Test
	public void relojPorDefectoCreadoEnMedianoche() {
		Reloj r = new Reloj();

		assertTrue("El reloj por defecto se crea en medianoche",
				r.getHoras() == 0);
		assertTrue("El reloj por defecto se crea en medianoche",
				r.getMinutos() == 0);
		assertTrue("El reloj por defecto se crea en medianoche",
				r.getSegundos() == 0);
	}

	@Test
	public void relojCreadoEnHora() {
		for (int i = 0; i < 23; i++) {
			Reloj r = new Reloj(i, 0, 0);

			assertTrue("El reloj creado con hora " + i + " no tiene esa hora",
					r.getHoras() == i);
		}
	}

	@Test
	public void relojCreadoEnMinuto() {
		for (int i = 0; i < 60; i++) {
			Reloj r = new Reloj(0, i, 0);

			assertTrue("El reloj creado con minuto " + i
					+ " no tiene ese minuto", r.getMinutos() == i);
		}
	}

	@Test
	public void relojCreadoEnSegundo() {
		for (int i = 0; i < 60; i++) {
			Reloj r = new Reloj(0, 0, i);

			assertTrue("El reloj creado con segundo " + i
					+ " no tiene ese segundo", r.getSegundos() == i);
		}
	}
	
	@Test
	void creadoEnHoraMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  new Reloj( -1,0,0);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con hora negativa", exception);
	}

	@Test
	void cambiadoAHoraMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  Reloj r = new Reloj();
	    	  r.setHoras(-1);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con hora menor de 0", exception);
	}

	@Test
	void cambiadoAHoraMayorDe23(){
		  boolean exception = false;
	      try {
	    	  Reloj r = new Reloj();
	    	  r.setHoras(24);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con hora mayor de 23", exception);
	}

	@Test
	void cambiadoAMinutoMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  Reloj r = new Reloj();
	    	  r.setMinutos(-1);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con minuto negativo", exception);
	}

	@Test
	void cambiadoAMinutoMayorDe59(){
		  boolean exception = false;
	      try {
	    	  new Reloj().setMinutos(60);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con minuto mayor de 59", exception);
	}

	@Test
	void cambiadoASegundoMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  new Reloj().setSegundos(-1);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con segundo negativo", exception);
	}

	@Test
	void cambiadoASegundoMayorDe59(){
		  boolean exception = false;
	      try {
	    	  new Reloj().setSegundos(60);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia cambiarse un reloj con segundo mayor de 59", exception);
	}

	@Test
	void creadoEnHoraMayorDe23(){
		  boolean exception = false;
	      try {
	    	  new Reloj( 24,0,0);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con hora mayor de 23", exception);
	}

	@Test
	void creadoEnMinutoMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  new Reloj( 0,-1,0);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con minuto negativo", exception);
	}

	@Test
	void creadoEnMinutoMayorDe59(){
		  boolean exception = false;
	      try {
	    	  new Reloj( 0,60,0);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con minuto mayor de 59", exception);
	}

	@Test
	void creadoEnSegundoMenorDeCero(){
		  boolean exception = false;
	      try {
	    	  new Reloj( 0,0,-1);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con segundo negativo", exception);
	}

	@Test
	void creadoEnSegundoMayorDe59(){
		  boolean exception = false;
	      try {
	    	  new Reloj( 0,0,60);
	      }
	      catch (Exception e) {
	          exception = true;
	      }
	      assertTrue("No deberia crearse un reloj con segundo mayor de 59", exception);
	}
	
}
