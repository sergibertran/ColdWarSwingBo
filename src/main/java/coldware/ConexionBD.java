
package coldware;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

	public static void addGanador(String ganador) { // funcion para a�adir un ganador

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


	public static void addPlanetas(List <Planeta> planetas) { // funcion para a�adir un ganador

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
                        
                        
			for (int i = 0; i < (planetas.size()); i++) {
                            
                        sql = "INSERT INTO coldware (idPartida,NPlaneta,TPlaneta,Vidas,Misiles) VALUES ('" + fecha  + "','" + planetas.get(i).getNombre()+ "','"+ planetas.get(i).getTipoplaneta() + "','" + planetas.get(i).getVidas()+ "','"+ planetas.get(i).getMisiles_ronda()+ "')";
			// ejecutamos el comando
			stmt.executeUpdate(sql);
				 
			}
			// insertamos nombre y fecha en la tabla
		

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

	public static List Ranking() { // funcion que printa ranking
         List ll = new LinkedList();
		try {
			// STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");

			// STEP 3: Open a connection

			conn = DriverManager.getConnection(DB_URL, USER, PASS);

			// STEP 4: Execute a query
			System.out.println("Printando resultados...");
			stmt = conn.createStatement();


			// create the java statement
			Statement st = conn.createStatement();

			// execute the query, and get a java resultset
			// contamos la cantidad de nombres iguales para saber cuantos registros hay de
			// un usuario=a partidas ganadas
			ResultSet rs = st.executeQuery(
					"select distinct idPartida from coldware  ");

                       
              

                // Fetch each row from the result set
                while (rs.next()) {
          
                 String str = rs.getString("idPartida");

                    //Assuming you have a user object
             

                     ll.add(str);
            }
			
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

                
                return ll;
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

			sql = "CREATE TABLE IF NOT EXISTS coldwar (idPartida varchar(40), NPlaneta varchar(20), TPlaneta int, Vidas int, Misiles int, primary key (idPartida, NPlaneta));";
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
