package StatementAndResultSetInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//lsets see simle example of statemnt interface too insert ,update ,delete the record

public class Statementinterface {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "Kanha");
			Statement st = conn.createStatement();

//			PreparedStatement ps = con.prepareStatement(sql);
//			int rowsInserted = st.executeUpdate();
//			if (rowsInserted > 0) {
//				System.out.println("A new user was inserted succcessfully");
//			}

			// Add dtaa
			 int result= st.executeUpdate("Insert into emp values(36,'pk','60000')");
			
			 
			 // update data
			
			// int result = st.executeUpdate("update emp set Name='Ganesh',Salary=20000
			// where EmpId=34");

			// delete data
			//int result = st.executeUpdate("delete from emp where EmpId=33");

			System.out.println(result + "records affected ");
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
