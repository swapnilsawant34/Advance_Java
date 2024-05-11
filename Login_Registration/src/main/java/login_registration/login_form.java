package login_registration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class login_form
 */
@WebServlet("/login_form")
public class login_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_form() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/login_registration","root","9134");
			
			if(conn!=null) {
				PreparedStatement stmt=conn.prepareStatement("select *from login_details where username=? && password=?");
				stmt.setString(1,username);
				stmt.setString(2,password);
				
				ResultSet rs=stmt.executeQuery();
				
				if(rs.next()) {
					RequestDispatcher r=request.getRequestDispatcher("welcome.html");
					r.include(request, response);				
				}
				else {
					RequestDispatcher r=request.getRequestDispatcher("Login.html");
					r.include(request, response);
					out.println("<h1>Invalid username and Password...</h1>");
				}
			}
			else {
				out.println("Database not connected.....");
			}
			
			
		}catch(Exception ex) {
			out.println("Error is"+ex);
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
