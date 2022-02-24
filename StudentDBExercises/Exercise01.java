package StudentDBExercises;
//1.	Display list of all student .
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise01 {

	public static void main(String[] args) {

		try {
			String sql = ("Select * from student");
			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			//String name=rs.getString(1);
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				System.out.println("Student id: "+id +" ," +"name :"+ name);
				

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
