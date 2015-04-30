package ejemploDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexiones {
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver"; // "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:oracle:thin:@//localhost:1521/XE";//"jdbc:oracle:thin:@//10.111.86.238:1521/ORCL"; //

	// Database credentials
	static final String USER = "alumno";//"scott"; //
	static final String PASS = "alumno"; //"tiger1"; //"alumno";

	public static Connection createConnection() throws ClassNotFoundException,
			SQLException {
		// STEP 2: Register JDBC driver
		Class.forName(JDBC_DRIVER);

		// STEP 3: Open a connection
		System.out.println("Connecting to database...");
		return DriverManager.getConnection(DB_URL, USER, PASS);
	}

}
