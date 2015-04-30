package ejemploDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AlumnoSQLDAOTest {
	
	public static void main(String[] args) throws Exception {
		Connection c = Conexiones.createConnection();
		
		AlumnoSQLDAO dao = new AlumnoSQLDAO(c);
		//dao.createDataBase();

		List<Alumno> alumnos = dao.findByBirthDay( fecha(1970,Calendar.JANUARY,1), fecha(1980,Calendar.JANUARY,1) );
		System.out.println(alumnos);

		Alumno a = dao.findByPrimaryKey( new Alumno("Álvaro", "González") );
		a.setCalificacion(40);
		dao.update(a);
		
		alumnos = dao.findByBirthDay( fecha(1970,Calendar.JANUARY,1), fecha(1980,Calendar.JANUARY,1) );
		System.out.println(alumnos);
		
	}

	private static Date fecha(int year, int month, int date) {
		Calendar c = Calendar.getInstance();
		c.set(year, month, date);
		return c.getTime();
	}
}
