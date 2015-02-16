import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.*;

public class EjemploDeCalendar {
	// 15 de abril del 2022

	public static void main(String[] args) {
		queCaeEl15DeAbrilDel22();
		
		
		Calendar c = Calendar.getInstance();
		
		mueveAProximo28FebreroEnDomingo(c);
		
		System.out.println(c.getTime());
		
	}
	
	private static void mueveAProximo28FebreroEnDomingo(Calendar c){
		
		mueveAProximoDomingo(c);
		while( !es28DeFebrero(c) ){
			c.add( DATE, 1 );
			mueveAProximoDomingo(c);
		}
	}

	private static boolean es28DeFebrero(Calendar c){
		return c.get(MONTH) == FEBRUARY && c.get(DAY_OF_MONTH) == 28;
	}
	
	private static void mueveAProximoDomingo(Calendar c) {
		while( c.get(DAY_OF_WEEK) != SUNDAY ){
			c.add( DATE, 1 );
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
