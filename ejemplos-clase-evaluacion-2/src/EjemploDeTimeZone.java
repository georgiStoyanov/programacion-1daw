import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class EjemploDeTimeZone {

	
	public static void todosLosTimezones(){
		String[] availableIDs = TimeZone.getAvailableIDs();
		Arrays.sort(availableIDs);
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();
		DateFormat formato = new SimpleDateFormat( "HH:mm ',' EEEE dd 'de' MMMM 'de' yyyy");
		
		for( String id : availableIDs ){
			TimeZone zone = TimeZone.getTimeZone(id);
			formato.setTimeZone(zone);
			System.out.printf( "%33s: %s\n", id, formato.format(date) );
		}
	}
	
	
	public static void main(String[] args) throws ParseException {
		//pruebaBogota();

		todosLosTimezones();
	}


	private static void pruebaBogota() throws ParseException {
		Calendar c = Calendar.getInstance();
		
		System.out.println( "Aqui:" + c.getTime() );
		
		TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		formato.setTimeZone(timeZone);
		
		System.out.println( "Bogota:" + formato.format(c.getTime()) );
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Dime una fecha:");
		String linea = in.nextLine();
		Date fecha = formato.parse(linea);
		
		System.out.println( "La fecha introducida es:" + fecha );
	}
}
