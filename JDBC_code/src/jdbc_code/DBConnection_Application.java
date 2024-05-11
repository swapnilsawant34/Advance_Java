package jdbc_code;
import java.sql.*;
public class DBConnection_Application {

	public static void main(String[] args) throws SQLException{
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver(); 
           DriverManager.registerDriver(d);
           
           System.out.println("Driver Registerd success...");
           
           Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/mysql","root","9134");
           
           if(conn!=null) {
        	   System.out.println("Database is connected");
           }else {
        	   System.out.println("Database is not connected");
           }
           
	}

}
