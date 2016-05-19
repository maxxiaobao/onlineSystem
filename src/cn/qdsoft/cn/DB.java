package cn.qdsoft.cn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

	private static String url = "jdbc:mysql://localhost:3306/onlinesystem"
			+ "?useUnicode=true&characterEncoding=utf8";
	private static String user = "root";
	private static String password = "";

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

}
