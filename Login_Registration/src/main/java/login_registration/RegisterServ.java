package login_registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class RegisterServ
 */
@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_registration","root","9134");
			if(conn!=null) {
				PreparedStatement stmt=conn.prepareStatement("insert into login_details values('0',?,?,?,?,?)");
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, contact);
				stmt.setString(4, username);
				stmt.setString(5, password);
				int value=stmt.executeUpdate();
				if(value>0) {
					RequestDispatcher r=request.getRequestDispatcher("Login.html");
					r.include(request,response);
				}
				else {
					
					out.println("<h1>Registrtion Failed........</h1>");
					
				}	
				
			}else {
				out.println("Database not connected.....");
			}	
			
		}
		catch(Exception ex){
			out.println("Exception is:"+ex);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


/*Question
You have to design registration and login module for web site 
Your task is design login page and provide one hyperlink on login page name as register when user click on register hyperlink then 
register.html page should call and display 
registration page with field name,email,contact,username and password and when we submit register.html page then 
you have to submit page on RegisterServ.java file and save in database table name as 
servregister and in servregister table contain field id, name, email , contact ,username , password after successfully register user then you have to redirect user 
on login page and when user input username and password in 
login page then you have to submit login page to ValidateServ and check username and password present in database or not if username and password present
in database then redirect user on welcome.html page and
if username and password not present in database then 
show message invalid username and password.

 * 
 * 
 */
