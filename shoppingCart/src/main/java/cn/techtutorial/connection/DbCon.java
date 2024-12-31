package cn.techtutorial.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	private static Connection connection = null;

	public static Connection getConnection() throws Exception {
		if (connection == null) {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/commerce", "root", "1234");
			System.out.println("connected : " + connection);
		}
		return connection;
	}

}
