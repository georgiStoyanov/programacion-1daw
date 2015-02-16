import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.TimeZone;


public class EjemploDeTimeZone {

	
	public static void main(String[] args) throws ParseException {
		Calendar c = Calendar.getInstance();
		
		System.out.println( "Aqui:" + c.getTime() );
		
		TimeZone timeZone = TimeZone.getTimeZone("America/Bogota");
		Calendar cBogota = Calendar.getInstance(timeZone);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		formato.setTimeZone(timeZone);
		
		System.out.println( "Bogota:" + cBogota.getTime() );
		System.out.println( "Bogota:" + formato.format(cBogota.getTime()) );
		
		
		Scanner in = new Scanner(System.in);
		System.out.println("Dime una fecha:");
		String linea = in.nextLine();
		Date fecha = formato.parse(linea);
		
		System.out.println( "La fecha introducida es:" + fecha );
		
	}
}
