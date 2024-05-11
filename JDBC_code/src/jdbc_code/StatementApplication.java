package jdbc_code;
import java.util.*;
import java.sql.*;
public class StatementApplication  {

	public static void main(String[] args)throws SQLException {
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
		
		if(conn!=null) {
			
			System.out.println("Enter the name,email and contact");  //to accept input from keyboard and then save in database 
			String name=xyz.nextLine();
			String email=xyz.nextLine();
			int contact=xyz.nextInt();
			System.out.println("Database is connected....");
			Statement stmt=conn.createStatement();
			int value=stmt.executeUpdate("insert into details values('"+name+"','"+email+"','"+contact+"')"); //SQLInjection
			if(value>0) {
				System.out.println("Data inserted in table.......");
			}
			else {
				System.out.println("Data is not inserted in table.......");
			}
		}
		else {
			System.out.println("Database is not connected....");
		}

	}

}








/*
 * public class StatementApplication  {

	public static void main(String[] args)throws SQLException {
		Scanner xyz=new Scanner(System.in);
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
		
		if(conn!=null) {
			System.out.println("Database is connected....");
			Statement stmt=conn.createStatement();
			int value=stmt.executeUpdate("insert into details values('ram','ram@gmail.com','123456')");
			if(value>0) {
				System.out.println("Data inserted in table.......");
			}
			else {
				System.out.println("Data is not inserted in table.......");
			}
		}
		else {
			System.out.println("Database is not connected....");
		}

	}

}
 * 
 * 
 */
