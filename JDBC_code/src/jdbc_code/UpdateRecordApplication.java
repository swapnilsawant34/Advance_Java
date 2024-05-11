package jdbc_code;
import java.util.*;
import java.sql.*;
public class UpdateRecordApplication {

	public static void main(String[] args) throws SQLException {
		Scanner xyz=new Scanner(System.in);
		
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
		
		if(conn!=null) {
			Statement stmt=conn.createStatement();
			
			System.out.println("Enter the name,email and contact");
			String name=xyz.nextLine();
			String email=xyz.nextLine();
			int contact=xyz.nextInt();
			
			int value=stmt.executeUpdate("update details set name='"+name+"',contact='"+contact+"'where email='"+email+"' ");
			
			if(value>0) {
				System.out.println("Record updated.......");
			}else {
				System.out.println("Some problem............");
			}
		}else {
			System.out.println("Data base is connected..");
		}

	}

}
