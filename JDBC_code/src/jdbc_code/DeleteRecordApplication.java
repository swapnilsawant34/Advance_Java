
//Q.JDBC program to input email of user and delete its record by using its email address.

package jdbc_code;
import java.util.*;
import java.sql.*;
public class DeleteRecordApplication {

	public static void main(String[] args) throws SQLException {
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
		
		if(conn!=null) {
			System.out.println("Enter the email");
			String e=xyz.nextLine();
			Statement stmt=conn.createStatement();
			int value=stmt.executeUpdate("delete from details where email='"+e+"'");
			
			if(value>0) {
				System.out.println("Record is deleted...");
			}else {
				System.out.println("Some problem...");
			}
			
		}else {
			System.out.println("Database is not connected.");
		}
		

	}

}
