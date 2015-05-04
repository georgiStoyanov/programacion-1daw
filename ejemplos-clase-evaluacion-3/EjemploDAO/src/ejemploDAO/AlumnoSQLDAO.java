package ejemploDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AlumnoSQLDAO implements AlumnoDAO {

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public AlumnoSQLDAO(Connection conn) {
		connection = conn;
	}

	@Override
	public void createDataBase() throws Exception {
		String[] sqlS = { "drop table alumnos",
				"create table alumnos(" + "idAlumno number," 
	+ "nombre varchar(50),"
				+ "apellidos varchar(50)," + "fechaNacimiento Date,"
				+ "calificacion Numeric," + "nota varchar(500) )",
				"alter table alumnos add primary key(idAlumno)", 
				"create sequence ID_ALUMNO_SEQ increment by 1" };

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			for( String sql : sqlS ){
				stmt = conn.prepareStatement(sql);
				stmt.executeUpdate();
			}
			conn.commit();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}


	@Override
	public void update(Alumno a) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "update alumnos set fechaNacimiento=?, calificacion=?, nota=?, nombre=?, apellidos=? where idAlumno=?";

			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, convertirASqlDate(a.getFechaNacimiento()));
			stmt.setDouble(2, a.getCalificacion());
			stmt.setString(3, a.getNota());
			stmt.setString(4, a.getNombre());
			stmt.setString(5, a.getApellidos());
			stmt.setInt(6, a.getIdAlumno());

			int filas = stmt.executeUpdate();
			System.out.printf("%d filas cambiadas\n", filas);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}

	private static java.sql.Date convertirASqlDate(java.util.Date d) {
		return new java.sql.Date(d.getTime());
	}

	@Override
	public void insert(Alumno a) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "insert into alumnos(idAlumno,nombre,apellidos,fechaNacimiento,calificacion,nota)"
					+ " values(?,?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getIdAlumno());
			stmt.setString(2, a.getNombre());
			stmt.setString(3, a.getApellidos());
			stmt.setDate(4, convertirASqlDate(a.getFechaNacimiento()));
			stmt.setDouble(5, a.getCalificacion());
			stmt.setString(6, a.getNota());

			int filas = stmt.executeUpdate();
			System.out.printf("%d filas cambiadas\n", filas);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try

	}

	@Override
	public void delete(Alumno a) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "delete from alumnos where idAlumno=?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getIdAlumno());

			int filas = stmt.executeUpdate();
			System.out.printf("%d filas cambiadas\n", filas);
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}

	@Override
	public Alumno findByPrimaryKey(Alumno a) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "select nombre,apellidos,fechaNacimiento,calificacion,nota from alumnos where idAlumno=?";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, a.getIdAlumno());

			ResultSet rs = stmt.executeQuery();
			Alumno ret = null;
			if (rs.next()) {
				String nombre =rs.getString(1);
				String apellidos = rs.getString(2);
				
				Date fechaNacimiento = rs.getDate(3);
				double calificacion = rs.getDouble(4);
				String nota = rs.getString(5);
				ret = new Alumno(a.getIdAlumno(),nombre,apellidos,
						fechaNacimiento, calificacion, nota);
			}

			// STEP 6: Clean-up environment
			rs.close();

			return ret;
		} finally {

			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}

	@Override
	public List<Alumno> findByBirthDay(Date min, Date max) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "select idAlumno,nombre,apellidos,fechaNacimiento,calificacion,nota from alumnos where fechaNacimiento between ? and ?";

			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, convertirASqlDate(min));
			stmt.setDate(2, convertirASqlDate(max));

			ResultSet rs = stmt.executeQuery();
			List<Alumno> ret = new ArrayList<Alumno>();
			while (rs.next()) {
				int idAlumno = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				Date fechaNacimiento = rs.getDate(4);
				double calificacion = rs.getDouble(5);
				String nota = rs.getString(6);
				Alumno a = new Alumno(idAlumno,nombre,apellidos,
						fechaNacimiento, calificacion, nota);
				ret.add(a);
			}

			// STEP 6: Clean-up environment
			rs.close();

			return ret;
		} finally {

			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}

	@Override
	public List<Alumno> findAll() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "select idAlumno,nombre,apellidos,fechaNacimiento,calificacion,nota from alumnos";

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			List<Alumno> ret = new ArrayList<Alumno>();
			while (rs.next()) {
				int idAlumno = rs.getInt(1);
				String nombre = rs.getString(2);
				String apellidos = rs.getString(3);
				Date fechaNacimiento = rs.getDate(4);
				double calificacion = rs.getDouble(5);
				String nota = rs.getString(6);
				Alumno a = new Alumno(idAlumno,nombre,apellidos,
						fechaNacimiento, calificacion, nota);
				ret.add(a);
			}

			// STEP 6: Clean-up environment
			rs.close();

			return ret;
		} finally {

			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
	}

	@Override
	public void commit() throws SQLException {
		System.out.println("Haciendo commit");
		getConnection().commit();
	}

	@Override
	public int siguienteIdAlumno() throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();

			String sql = "select ID_ALUMNO_SEQ.nextval from dual";

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			rs.next();
			int next = rs.getInt(1);

			// STEP 6: Clean-up environment
			rs.close();

			return next;
		} finally {

			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
				throw se2;
			}// nothing we can do
		}// end try
		
	}

}
