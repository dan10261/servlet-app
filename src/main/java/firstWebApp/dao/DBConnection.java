package firstWebApp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnection {
	private static Connection connection;

	public static Connection getConnection() {
		DriverManagement.getDriver("mysql");
		try {
			System.out.println("Initialize DB connection.");
			if (connection == null)
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cav", "cav", "Cav@2021");
			else {
				System.out.println(DBConnection.class.getName() + ": connection already exists.");
			}
			return connection;
		} catch (SQLException e) {
			System.err.println(DBConnection.class.getName() + "SQL Connection error");
			e.printStackTrace();
		}
		return null;
	}
	
	public static void CloseConn() {
		try {

			//Unregister Driver 
			DriverManager.deregisterDriver(DriverManager.getDriver("jdbc:mysql://localhost:3306/cav"));
			//close DB connection upon app stop
			DBConnection.getConnection().close();
			System.out.println("DB connection closed");
		} catch (SQLException e) {
			System.err.println("Error during connection closed");
			e.printStackTrace();
		}
	}

	public static Connection getConnectionFromPool() {
		try {
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("jdbc/cav");
			connection = ds.getConnection("cav", "Cav@2021");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e2) {
			e2.printStackTrace();
		}
		return connection;
	}
}
