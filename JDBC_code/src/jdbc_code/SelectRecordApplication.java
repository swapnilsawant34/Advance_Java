package jdbc_code;
import java.util.*;
import java.sql.*;
public class SelectRecordApplication {

	public static void main(String[] args) throws SQLException  {
		Scanner xyz=new Scanner(System.in);
		
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
		
		
		
		if(conn!=null) {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select *from details");
			
			while(rs.next()) {
				System.out.println(rs.getString("name")+"\t"+rs.getString("email")+"\t"+rs.getInt("contact"));
			}
		}else {
			System.out.println("Database not connected.....");
		}

	}

}
