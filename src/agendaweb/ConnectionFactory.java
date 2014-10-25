package agendaweb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionFactory {

	public Connection getConnection(){
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/agenda", "root", "banco");
		} catch (SQLException e) {
			throw new RuntimeException (e);
					}
	}
	
}