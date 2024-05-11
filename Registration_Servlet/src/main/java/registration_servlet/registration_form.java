package registration_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/registration_form")
public class registration_form extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String branch=request.getParameter("branch");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","9134");
			if(conn!=null) {
				PreparedStatement stmt=conn.prepareStatement("insert into registration values('0',?,?,?,?)");
				stmt.setString(1, name);
				stmt.setString(2, email);
				stmt.setString(3, contact);
				stmt.setString(4, branch);
				
				int value=stmt.executeUpdate();
				if(value>0) {
					out.println("<h1>Registration succefully......</h1>");
				}
				else {
					out.println("<h1>Registration failed......</h1>");
				}
			}
			else {
				out.println("<h1>Not connected...</h1>");
			}
			
		}catch(Exception ex){
			out.println("error is "+ex);
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
