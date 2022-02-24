package StudentDBExercises;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//6.	Display the information (no,name,age) of student  who made the project in java.
public class Exercise06 {

	public static void main(String[] args) {

		try {
			String sql = (" Select st_no,st_name,Round((utc_date-st_dob)/365) as age from student where st_no IN("
					+ " select st_no from studentproject where prj_no IN(select prj_no from project where prj_platform='JAVA'))");
			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String stno = rs.getString(1);
				String stname = rs.getString(2);
				int stage = rs.getInt(3);
				System.out.println("Student stno :" + stno+ " "+ "name:" + stname + " "+ "age:" + stage);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
