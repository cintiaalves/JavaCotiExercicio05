package factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String CONNECTION = "jdbc:mysql://localhost:3306/exercicio02?useTimezone=true&serverTimezone=UTC&useSSL=false";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	
	public Connection getConnection() throws Exception {
		return DriverManager.getConnection(CONNECTION, USERNAME, PASSWORD);
	}

}
