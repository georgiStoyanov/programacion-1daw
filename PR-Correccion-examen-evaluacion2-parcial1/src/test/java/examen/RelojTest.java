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
	void cambiadoAHoraMenorDeCero() {
		boolean exception = false;
		try {
			Reloj r = new Reloj();
			r.setHoras(-1);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con hora menor de 0",
				exception);
	}

	@Test
	void cambiadoAHoraMayorDe23() {
		boolean exception = false;
		try {
			Reloj r = new Reloj();
			r.setHoras(24);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con hora mayor de 23",
				exception);
	}

	@Test
	void cambiadoAMinutoMenorDeCero() {
		boolean exception = false;
		try {
			Reloj r = new Reloj();
			r.setMinutos(-1);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con minuto negativo",
				exception);
	}

	@Test
	void cambiadoAMinutoMayorDe59() {
		boolean exception = false;
		try {
			new Reloj().setMinutos(60);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con minuto mayor de 59",
				exception);
	}

	@Test
	void cambiadoASegundoMenorDeCero() {
		boolean exception = false;
		try {
			new Reloj().setSegundos(-1);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con segundo negativo",
				exception);
	}

	@Test
	void cambiadoASegundoMayorDe59() {
		boolean exception = false;
		try {
			new Reloj().setSegundos(60);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia cambiarse un reloj con segundo mayor de 59",
				exception);
	}

	@Test
	void creadoEnHoraMenorDeCero() {
		boolean exception = false;
		try {
			new Reloj(-1, 0, 0);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con hora negativa", exception);
	}

	@Test
	void creadoEnHoraMayorDe23() {
		boolean exception = false;
		try {
			new Reloj(24, 0, 0);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con hora mayor de 23",
				exception);
	}

	@Test
	void creadoEnMinutoMenorDeCero() {
		boolean exception = false;
		try {
			new Reloj(0, -1, 0);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con minuto negativo", exception);
	}

	@Test
	void creadoEnMinutoMayorDe59() {
		boolean exception = false;
		try {
			new Reloj(0, 60, 0);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con minuto mayor de 59",
				exception);
	}

	@Test
	void creadoEnSegundoMenorDeCero() {
		boolean exception = false;
		try {
			new Reloj(0, 0, -1);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con segundo negativo",
				exception);
	}

	@Test
	void creadoEnSegundoMayorDe59() {
		boolean exception = false;
		try {
			new Reloj(0, 0, 60);
		} catch (Exception e) {
			exception = true;
		}
		assertTrue("No deberia crearse un reloj con segundo mayor de 59",
				exception);
	}

	private static String cadena(int hora, int minuto, int segundo) {
		return String.format("%02d:%02d:%02d", hora, minuto, segundo);
	}

	@Test
	void segundosRotanConUnTick() {
		Reloj r = new Reloj(0, 0, 59);
		r.tick();
		assertTrue("Los segundos deben rotar de 59 a 0 con tick",
				r.getSegundos() == 0);
		assertTrue(
				"Los minutos deben avanzar al rotar los segundos de 59 a 0 con tick",
				r.getMinutos() == 1);
	}

	@Test
	void minutosRotanConUnTick() {
		Reloj r = new Reloj(0, 59, 59);
		r.tick();
		assertTrue("Los minutos deben rotar de 59 a 0 con tick ",
				r.getMinutos() == 0);
		assertTrue(
				"Las horas deben avanzar al rotar los minutos de 59 a 0 con tick",
				r.getHoras() == 1);
	}

	@Test
	void horasRotanConUnTick() {
		Reloj r = new Reloj(23, 59, 59);
		r.tick();
		assertTrue("Las horas deben rotar de 23 a 0 con tick",
				r.getHoras() == 0);
	}

	@Test
	void representacionComoCadenaEnCreacion() {
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					Reloj r = new Reloj(h, m, s);
					assertTrue(
							"Representacion de cadena incorrecta al crear un reloj con h:"
									+ h + " m:" + m + " s:" + s,
							cadena(h, m, s).equals(r.toString()));
				}
			}
		}
	}
	
	@Test
	void representacionComoCadenaConSet() {
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					Reloj r = new Reloj();
					r.setHoras(h);
					r.setMinutos(m);
					r.setSegundos(s);
					assertTrue(
							"Representacion de cadena incorrecta al cambiar un reloj con h:"
									+ h + " m:" + m + " s:" + s,
							cadena(h, m, s).equals(r.toString()));
				}
			}
		}
	}

	@Test
	void representacionComoCadenaConTick() {
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					Reloj r = new Reloj();
					r.tick(h,m,s);
					assertTrue(
							"Representacion de cadena incorrecta al avanzar  un reloj con tick h:"
									+ h + " m:" + m + " s:" + s,
							cadena(h, m, s).equals(r.toString()));
				}
			}
		}
	}

	@Test
	void representacionComoCadenaConTickSimple() {
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				for (int s = 0; s < 60; s++) {
					Reloj r = new Reloj();
					for( int t = 0 ; t < h*60*60 + m*60 + s ; t ++ ){
						r.tick();
					}
					assertTrue(
							"Representacion de cadena incorrecta al avanzar un reloj varias veces con tick h:"
									+ h + " m:" + m + " s:" + s,
							cadena(h, m, s).equals(r.toString()));
				}
			}
		}
	}
	
}
