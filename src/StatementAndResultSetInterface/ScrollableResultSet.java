package StatementAndResultSetInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ScrollableResultSet {
	
	

	public static void main(String[] args) {
		Connection con;
		ResultSet rs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

			rs = st.executeQuery("select * from emp");

			// getting the record of 3rd row
			rs.absolute(1);
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3));

			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
