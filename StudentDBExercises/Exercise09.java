package StudentDBExercises;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//9.	Display details of the youngest student.
public class Exercise09 {

	public static void main(String[] args) {

		try {
			String sql = ("select * from student  where st_dob=(select MAX(st_dob) from student)");

			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String stno = rs.getString(1);
				String stname = rs.getString(2);
				Date dob = rs.getDate(3);
				Date doj = rs.getDate(4);
				System.out.println(
						"Student stno :" + stno + " " + "name:" + stname + " " + "DOB:" + dob + " " + "DOJ:" + doj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
