package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	private static final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String MYSQL_URL = "jdbc:mysql://localhost:3306/humble";
	private static final String MYSQL_USERNAME = "root";
	private static final String MYSQL_PASSWORD = "";
	private Connection conn;
	
	public void connect() throws ClassNotFoundException{
		Class.forName(MYSQL_DRIVER);		
		try {
			conn = DriverManager.getConnection(MYSQL_URL, MYSQL_USERNAME, MYSQL_PASSWORD);
			System.out.println("Successfully connected to the Database!");			
		} catch (Exception ex) {
			System.out.println("SQLException: " + ex.getMessage());
			conn = null;
		}
	}
	
	public void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Database connection closed");
			} catch (SQLException e) {
				System.out.println("Can't close connection");
			}
		}
		
		conn = null;
	}

	public Connection getConnection() {
		return conn;
	}

		
}
