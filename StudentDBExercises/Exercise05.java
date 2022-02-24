package StudentDBExercises;
//5.Find number of students who did not participate in any project.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise05 {

	public static void main(String[] args) {
		try {
			String sql = ("Select count(st_no)AS \"student count\" from  student where st_no IN (select st_no from student where st_no NOT IN(select st_no from studentproject ))");
			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String total = rs.getString(1);
				System.out.println("Total number  of student the not participate any project =" + total);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
