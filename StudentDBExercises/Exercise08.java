package StudentDBExercises;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//8.	Display the student who played the max designation(e.g. manager,programmer) in the same project.
public class Exercise08 {

	public static void main(String[] args) {

		try {
			String sql=(" select st_no,COUNT(designation)from studentproject where designation=(select max(designation) from studentproject) ");

			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String stno = rs.getString(1);
				String desi = rs.getString(2);
				System.out.println(
						"Student stno :" + stno + " " + "designation:" + desi  );
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
