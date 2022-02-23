package JdbcSQLexercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// wap to to update the rocords in bank table using statement.executeUpdate
public class exercise03 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter a  AC name");
//		String name = sc.next();
//		System.out.println("Enter Ac bal");
//		int bal = sc.nextInt();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			String sql = ("update bank set AcName='Radha',AcBal=25000 where AcName='Sham'");
			Statement st = conn.createStatement();
			int rowinserted = st.executeUpdate(sql);

			if (rowinserted > 0) {
				System.out.println("data updated succcessfully");
			}
			else
				System.out.println("Data allready updated");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
