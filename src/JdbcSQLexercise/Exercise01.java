package JdbcSQLexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Write a java program to update the bank table with column ("Accountant","AccountantBal") using resultSet object.

public class Exercise01 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);

			// Create table
			// String sql = ("Create table bank (Acc VARCHAR (25) not null, AccBal int (10) not null)");
			
			 //alter table
			 
			 String sql = ("alter table bank rename  column Acc to Accountant , rename column AccBal to AccountantBal ");
				
			 
			// Add data into a table
			//String sql = ("update table bank values('c',40)");
			int result = st.executeUpdate(sql);

			if (result > 0) {
				System.out.println(result + ": records affected ");
			}else
				System.out.println("Dublicate Entry");

			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
