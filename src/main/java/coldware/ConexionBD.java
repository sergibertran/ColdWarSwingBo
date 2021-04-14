
package coldware;

import java.sql.*;
import java.text.SimpleDateFormat;

public class ConexionBD {

	// JDBC driver name and database URL
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // driver
	final static String DB_URL = "jdbc:mysql://oracle.ilerna.com/test";// EN CASA ES EL 6 EN CLASE ES UN 7

	// Database credentials
	final static String USER = "DAW2_GamifikG6";
	final static String PASS = "aGamifikG61";

	static Connection conn = null;
	static Statement stmt = null;

	public ConexionBD() { // constructor

	}

	static void addGanador(String ganador) { // funcion para a�adir un ganador

		// STEP 1. Import required packages

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection

			System.out.println(" Conectandote a la Base de datos");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Insertando datos...");
			stmt = conn.createStatement();
			String sql;
			// obtenemos fecha de la victoria
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

			Date date = new Date(System.currentTimeMillis());
			// guardamos la fecha en una string y la printa
			String fecha = formatter.format(date);

			// insertamos nombre y fecha en la tabla
			sql = "INSERT INTO coldwar (nombre, fecha) " + "VALUES ('" + ganador + "','" + fecha + "')";
			// ejecutamos el comando
			stmt.executeUpdate(sql);

			// STEP 6: Clean-up environment

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
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}
	// end main
	// end FirstExample

	static void Ranking() { // funcion que printa ranking

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Printando resultados...");
			stmt = conn.createStatement();

			// our SQL SELECT query.
			// if you only need a few columns, specify them by name instead of using "*"
			// String query = "SELECT * FROM coldwar ";

			//// CONTAR
			// contamos la cantidad de nombres iguales para saber cuantos registros hay de
			//// un usuario=a partidas ganadas

			//// CONTAR

			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			// contamos la cantidad de nombres iguales para saber cuantos registros hay de
			// un usuario=a partidas ganadas
			ResultSet rs = st.executeQuery(
					"SELECT COUNT(nombre) AS CONTADOR, nombre,MAX(fecha) FROM coldwar GROUP BY nombre ORDER BY CONTADOR DESC ");

			// iterate through the java resultset
			System.out.println("______________________________________________________________");
			System.out.println(" Victorias \t Nombre \t Fecha ultima victoria");

			while (rs.next()) // printa hasta que no haya rs.next
			{
				String num = rs.getString(1);
				String nombre = rs.getString("nombre");
				String fecha = rs.getString("MAX(fecha)");
				// print the results

				System.out.println("\t" + num + " \t" + nombre + " \t\t" + fecha);
			}
			System.out.println("______________________________________________________________");

			// STEP 6: Clean-up environment
			st.close();
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
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}

	public static void crearBD() { // funcion para crear la tabla, en el caso de que no este creada
		

		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection

			System.out.println(" Conectandote a la Base de datos");
			// creamos la conexion con los datos guardados
			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			System.out.println("Creando tabla si no existe...");

			stmt = conn.createStatement();
			String sql;

			// se crea la tabla si no existe

			sql = "CREATE TABLE IF NOT EXISTS coldwar (nombre VARCHAR(30), fecha VARCHAR(30));";
			stmt.execute(sql);

			// STEP 6: Clean-up environment

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
			} // nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

	}
	// end main
	// end FirstExample

}// end main
