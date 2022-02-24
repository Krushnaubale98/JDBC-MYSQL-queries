package StudentDBExercises;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//10.	Display the info of the student who participated in the project where total no 
//of the student should be exact three.
public class Exercise10 {

	public static void main(String[] args) {

		try {
			String sql=("select * from student where st_no IN(select st_no from ( select count(st_no),prj_no from studentproject GROUP BY prj_no HAVING COUNT(st_no)=3) k,studentproject b where k.prj_no=b.prj_no);");
			Statement st = dbconnection.getconnection().createStatement();

			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				String stno = rs.getString(1);
				String stname = rs.getString(2);
				Date dob = rs.getDate(3);
				Date doj = rs.getDate(4);
				System.out.println(
						"Student stno :" + stno + " " + "name:" + stname + "   " +"DOB:" + dob + "   " + "DOJ:" + doj);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
