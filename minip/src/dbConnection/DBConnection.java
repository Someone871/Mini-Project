package dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	// Define Database Properties
	
	private static final String url = "jdbc:mysql://localhost:3306/dbms";
	
	private static final String username = "Rushi";
	
	private static final String password = "pict123";
	
	private static final String driver = "com.mysql.jdbc.Driver";
	
	private static Connection connection = null;
	
	// Static method to get database connection
	
	public static Connection openConnection() {
		
		// Check the connection 
		if (connection!=null)
			return connection;
		else {
			try {
				// Load the driver
				Class.forName(driver);
				// Get the connection
				connection = DriverManager.getConnection(url,username,password);
			}
			catch(ClassNotFoundException e){
				e.printStackTrace();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			
			// Return Connection
			return connection;
		}
	}
}
