<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Declaration_Scriptlet tag</title>
</head>
<body>
<%!
int a,b,c;  //1.Declaration tag
%>
<%
a=30;        //2.Scriptlet tag
b=20;
c=a+b;
//out.println("<h1>Addition is:"+c+" </h1>");
                  
 //3.Expression \|/
%>
<h1>Addition is &nbsp;<%=c%></h1>  
                          
</body>
</html>