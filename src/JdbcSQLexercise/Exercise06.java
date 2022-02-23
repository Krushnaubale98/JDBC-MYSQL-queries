package JdbcSQLexercise;

import java.sql.SQLException;
import java.sql.Statement;

//WAp to alter table countries including columns CId,CName,RegionId, to add a column regionId.
public class Exercise06 {

	public static void main(String[] args) throws ClassNotFoundException {

		try {

			Statement st = Exercise04.con().createStatement();
			String sql = ("alter table countries add regionname  int(10) null");
			int result = st.executeUpdate(sql);

			if (result < 0) {
				System.out.println(result + ": records affected ");
			} else
				System.out.println("Dublicate Entry");

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
