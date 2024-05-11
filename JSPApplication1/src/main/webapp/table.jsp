<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
  input{
    width:400px;
    height:40px;
  }
</style>
</head>
<body>
  <form name='frm' action='' method='POST'>
  <input type='text' name='n' value=''/>&nbsp;&nbsp;
  <input type='submit' name='s' value='Show Table'/>
  </form>
  <br>
  <%
     String btn=request.getParameter("s");
     if(btn!=null){
    	 int no=Integer.parseInt(request.getParameter("n"));
    	 out.println("<table  border='5' width='75%' height='500px'>");
    	 out.println("<tr><th>Number</th><th>X</th><th>Iteration</th><th>=</th><th>Result</th></tr>");
    	for(int i=1; i<=10;i++){
    		out.println("<tr>");
    		out.println("<td align='center'>"+no+"</td>");
    		out.println("<td align='center'>X</td>");
    		out.println("<td align='center'>"+i+"</td>");
    		out.println("<td align='center'>=</td>");
    		out.println("<td align='center'>"+(no*i)+"</td>");
    		
    		out.println("</tr>");
    	}
    	out.println("</table>");
     }
  %>
</body>
</html>
