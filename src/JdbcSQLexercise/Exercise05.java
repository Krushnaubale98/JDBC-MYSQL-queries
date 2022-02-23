package JdbcSQLexercise;

import java.sql.SQLException;
import java.sql.Statement;

//WRP to get create a tablle countries including columns country_id,country_name,region_id.
public class Exercise05 {

	public static void main(String[] args) {

		try {
			Statement st = Exercise04.con().createStatement();

			String sql = ("Create table countries(CountryId int not null,CountryName varchar(20) not null,regionId varchar(20) not null,primary key(CountryId))");

			int rowInserted = st.executeUpdate(sql);
			if (rowInserted < 0) {
				System.out.println("Table created");
			} 
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
