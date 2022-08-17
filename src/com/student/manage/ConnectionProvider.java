package com.student.manage;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	
	static Connection connection;
	
	public static Connection createConnection() {
		try {
			// Step 1: Load the driver
			Class.forName("org.mariadb.jdbc.Driver");
			
			// Step 2: Create the connection
			String user = "chromiumhead";
			String password = "aftaab2507";
			String url = "jdbc:mariadb://localhost:3306/student_management";
			
			connection = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
}
