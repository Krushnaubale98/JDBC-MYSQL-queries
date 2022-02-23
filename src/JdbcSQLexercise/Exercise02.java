package JdbcSQLexercise;

// WAP to insert 5 records in bank table with column ("AcBal,"AcName") using prepared statements.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class Exercise02 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			try (Scanner sc = new Scanner(System.in)) {
				System.out.println("Enter a  AC name");
				String name = sc.next();
				System.out.println("Enter Ac bal");
				int bal = sc.nextInt();

				String sql = ("insert into bank (ACName,AcBal) values(?,?)");
				PreparedStatement ps = conn.prepareStatement(sql);

				ps.setString(1, name);
				ps.setInt(2, bal);
				int rowsInserted = ps.executeUpdate();
				if (rowsInserted > 0) {
					System.out.println("data inserted succcessfully");
				}
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
