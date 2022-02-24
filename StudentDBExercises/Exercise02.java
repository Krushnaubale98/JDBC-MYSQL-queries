package StudentDBExercises;
//2.	Display list of all projects.
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Exercise02 {

	public static void main(String[] args) {

		try {
			String sql = ("select * from project");
			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				String Id = rs.getString(1);
				String PrjName = rs.getString(2);
				System.out.println("Project Id:"+ Id +" " + "Name:"+PrjName);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
