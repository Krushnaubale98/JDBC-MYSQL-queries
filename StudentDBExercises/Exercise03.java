package StudentDBExercises;
//3.	Display the number of students who are working on project “P01”.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise03 {

	public static void main(String[] args) {
		try {
			String sql = ("Select count(*)from studentproject where prj_no ='P01' ");

			Statement st = dbconnection.getconnection().createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String total = rs.getString(1);
				System.out.println("Total student count =" + total);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
