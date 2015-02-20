import static java.util.Calendar.*;
import static java.util.Calendar.DATE;
import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.DAY_OF_WEEK;
import static java.util.Calendar.FEBRUARY;
import static java.util.Calendar.FRIDAY;
import static java.util.Calendar.MONDAY;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.SATURDAY;
import static java.util.Calendar.SUNDAY;
import static java.util.Calendar.THURSDAY;
import static java.util.Calendar.TUESDAY;
import static java.util.Calendar.WEDNESDAY;
import static java.util.Calendar.YEAR;

import java.util.Calendar;

public class EjemploDeCalendar {

	public static void main(String[] args) {
		int anyo = 2015;
		System.out.printf("Cambio de horario a verano de %d: %s\n", anyo,
				diaDeCambioDeHorarioInviernoAVerano(anyo).getTime());
	}

	private static Calendar diaDeCambioDeHorarioInviernoAVerano(int anyo) {
		// EL ULTIMO DOMINGO DE MARZO DE ESE AÑO
		Calendar c = getInstance();

		c.set(YEAR, anyo);
		c.set(MONTH, MARCH);
		c.set(DAY_OF_MONTH, 31);

		while (c.get(DAY_OF_WEEK) != SUNDAY) {
			c.add(DAY_OF_MONTH, -1);
		}

		return c;
	}

	private static void mueveAProximo28FebreroEnDomingo(Calendar c) {

		mueveAProximoDomingo(c);
		while (!es28DeFebrero(c)) {
			c.add(DATE, 1);
			mueveAProximoDomingo(c);
		}
	}

	private static boolean es28DeFebrero(Calendar c) {
		return c.get(MONTH) == FEBRUARY && c.get(DAY_OF_MONTH) == 28;
	}

	private static void mueveAProximoDomingo(Calendar c) {
		while (c.get(DAY_OF_WEEK) != SUNDAY) {
			c.add(DATE, 1);
		}
	}

	private static void queCaeEl15DeAbrilDel22() {
		Calendar c = Calendar.getInstance();

		c.set(YEAR, 2022);
		c.set(MONTH, APRIL);
		c.set(DAY_OF_MONTH, 15);

		int diaDeLaSemana = c.get(DAY_OF_WEEK);
		String dia = diaDeLaSemana(diaDeLaSemana);

		System.out.println(dia);
	}

	private static String diaDeLaSemana(int diaDeLaSemana) {
		switch (diaDeLaSemana) {
		case SUNDAY:
			return "Domingo";
		case MONDAY:
			return "Lunes";
		case TUESDAY:
			return "Martes";
		case WEDNESDAY:
			return "Miércoles";
		case THURSDAY:
			return "Jueves";
		case FRIDAY:
			return "Viernes";
		case SATURDAY:
			return "Sábado";
		default:
			throw new IllegalArgumentException();

		}
	}

}
