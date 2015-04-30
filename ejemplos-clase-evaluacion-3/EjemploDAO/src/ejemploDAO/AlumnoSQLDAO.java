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
		String sql = "create table alumnos(" + "nombre varchar(50),"
				+ "apellidos varchar(50)," + "fechaNacimiento Date,"
				+ "calificacion Numeric," + "nota varchar(500) )";

		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.executeUpdate();
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

			String sql = "update alumnos set fechaNacimiento=?, calificacion=?, nota=? where nombre=? and apellidos=?";

			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, convertirASqlDate(a.getFechaNacimiento()));
			stmt.setDouble(2, a.getCalificacion());
			stmt.setString(3, a.getNota());
			stmt.setString(4, a.getNombre());
			stmt.setString(5, a.getApellidos());

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

			String sql = "insert into alumnos(nombre,apellidos,fechaNacimiento,calificacion,nota)"
					+ " values(?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getNombre());
			stmt.setString(2, a.getApellidos());
			stmt.setDate(3, convertirASqlDate(a.getFechaNacimiento()));
			stmt.setDouble(4, a.getCalificacion());
			stmt.setString(5, a.getNota());

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

			String sql = "delete from alumnos where nombre=? and apellidos=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getNombre());
			stmt.setString(2, a.getApellidos());

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

			String sql = "select fechaNacimiento,calificacion,nota from alumnos where nombre=? and apellidos=?";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, a.getNombre());
			stmt.setString(2, a.getApellidos());

			ResultSet rs = stmt.executeQuery();
			Alumno ret = null;
			if (rs.next()) {
				Date fechaNacimiento = rs.getDate(1);
				double calificacion = rs.getDouble(2);
				String nota = rs.getString(3);
				ret = new Alumno(a.getNombre(), a.getApellidos(),
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

			String sql = "select nombre,apellidos,fechaNacimiento,calificacion,nota from alumnos where fechaNacimiento between ? and ?";

			stmt = conn.prepareStatement(sql);
			stmt.setDate(1, convertirASqlDate(min));
			stmt.setDate(2, convertirASqlDate(max));

			ResultSet rs = stmt.executeQuery();
			List<Alumno> ret = new ArrayList<Alumno>();
			while (rs.next()) {
				String nombre = rs.getString(1);
				String apellidos = rs.getString(2);
				Date fechaNacimiento = rs.getDate(3);
				double calificacion = rs.getDouble(4);
				String nota = rs.getString(5);
				Alumno a = new Alumno(nombre,apellidos,
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

			String sql = "select nombre,apellidos,fechaNacimiento,calificacion,nota from alumnos";

			stmt = conn.prepareStatement(sql);

			ResultSet rs = stmt.executeQuery();
			List<Alumno> ret = new ArrayList<Alumno>();
			while (rs.next()) {
				String nombre = rs.getString(1);
				String apellidos = rs.getString(2);
				Date fechaNacimiento = rs.getDate(3);
				double calificacion = rs.getDouble(4);
				String nota = rs.getString(5);
				Alumno a = new Alumno(nombre,apellidos,
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
		getConnection().commit();
	}

}
