package StudentDBExercises;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	public static Connection conn;

	public static Connection getconnection() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/studentproject", "root", "Kanha");
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

		getconnection();
	}

}
