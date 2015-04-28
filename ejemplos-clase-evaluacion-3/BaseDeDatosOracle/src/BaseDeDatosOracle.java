import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

public class BaseDeDatosOracle {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; // "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:oracle:thin:@//10.111.86.238:1521/ORCL"; //"jdbc:oracle:thin:@//localhost:1521/XE";

	// Database credentials
	static final String USER = "scott"; //"alumno";
	static final String PASS = "tiger1"; //"alumno";

	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

	public static void ejemploEscrituraTabla(int columna1, Date columna2,
			int columna3, String columna4, String columna5) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = createConnection();

			String sql = "insert into unatabla(column1,column2,column3,column4,column5)"
					+ " values(?,?,?,?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, columna1);
			stmt.setDate(2, columna2);
			stmt.setInt(3, columna3);
			stmt.setString(4, columna4);
			stmt.setString(5, columna5);

			int filas = stmt.executeUpdate();
			System.out.printf("%d filas cambiadas\n", filas);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

	}
	
	public static java.sql.Date convertirASqlDate( java.util.Date d ){
		return new java.sql.Date( d.getTime() );
	}

	public static void main(String args[]) {
		//ejemploEscrituraTabla(7, convertirASqlDate( new java.util.Date() ), 5, "un' valor", "otro valor");
		ejemploLecturaTabla();
		//ejemploCreacionTabla();
	}
	public static void ejemploCreacionTabla() {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = createConnection();

			String sql = "create table otratabla(id numeric, nombre varchar2(50))";

			stmt = conn.prepareStatement(sql);
			int filas = stmt.executeUpdate();
			System.out.printf("%d filas cambiadas\n", filas);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try

	}
	public static void ejemploLecturaTabla() {
		Connection conn = null;
		Statement stmt = null;
		try {
			// STEP 2: Register JDBC driver
			conn = createConnection();

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT * FROM otratabla";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 5: Extract data from result set
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 1; i <= metaData.getColumnCount(); i++) {
				String label = metaData.getColumnLabel(i);
				System.out.print(label + "\t");
			}
			System.out.println();
			while (rs.next()) {
				// Retrieve by column name

				for (int i = 1; i <= metaData.getColumnCount(); i++) {
					String value = rs.getString(i);
					System.out.print(value + "\t");
				}
				System.out.println();
			}
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try
		}// end try
		System.out.println("Goodbye!");
	}// end main
}
