package StudentDBExercises;
//4.Display number of students who participated in more than one project.

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise04 {

	public static void main(String[] args) {
		try {
			String sql = ("Select count(st_no) Empprj_noCOUNT from studentproject GROUP BY prj_no ORDER BY prj_no>1 desc");

			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String total = rs.getString(1);
				System.out.println("Total student number that working more than one project =" + total);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}


		

	}

}
