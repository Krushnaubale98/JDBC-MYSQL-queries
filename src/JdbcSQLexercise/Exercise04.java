package JdbcSQLexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//  wap to get connection object using object hostname, user ,password sotred in external properties file.
public class Exercise04 {
	public static Connection conn;
	public static String Username;
	public static String Password;
	public static String Hostname;
	public static String url;
	public static String db;

	public static Connection con() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			System.out.println("Connection success");

			return conn;


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn.close();

		return null;


	}

	public static void main(String[] args) throws SQLException {

		con();
	}

}
