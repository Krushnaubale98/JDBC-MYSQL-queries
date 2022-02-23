package JdbcSQLexercise;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Exercise07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			String sql = ("insert into countries (CountryId,CountryName,regionId,regionName)values (?,?,?,?)");
			PreparedStatement ps = Exercise04.con().prepareStatement(sql);

			System.out.println("Enter country Id");
			int CId = sc.nextInt();
			System.out.println("Enter country name");
			String Cname = sc.next();
			System.out.println("Enter region Id name");
			int RId = sc.nextInt();
			System.out.println("Enter region name");
			String Rname = sc.next();

			String[] a = { Integer.toString(CId), "Cname", Integer.toString(RId), "RName" };
			ps.setInt(1, (Integer.parseInt(a[0])));
			ps.setString(2, a[1]);
			ps.setInt(3, Integer.parseInt(a[2]));
			ps.setString(4,a[3]);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A data inserted succcessfully");
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
