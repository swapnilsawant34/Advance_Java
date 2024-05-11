package Cookie_Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveCookie
 */
@WebServlet("/save")
public class SaveCookie extends HttpServlet {
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			String username=request.getParameter("user");
			String password=request.getParameter("pass");
			Cookie c1 = new Cookie("u",username);
			c1.setMaxAge(60*60*24*90);
			response.addCookie(c1);
			Cookie c2 = new Cookie("p",password);
			c2.setMaxAge(60*60*24*90);
			response.addCookie(c2);
			out.println("<a href='view'>View Cooke</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

