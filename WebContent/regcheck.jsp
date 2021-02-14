<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.db.DBConnection" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String user = request.getParameter("username");
String password = request.getParameter("password");
String mailid = request.getParameter("mailid");
DBConnection dbconnect = new DBConnection();
Connection con = dbconnect.connect();

PreparedStatement preparedStatement = con.prepareStatement("Select * from Users where mailid= ?");
preparedStatement.setString(1,mailid);
ResultSet rs = preparedStatement.executeQuery();
if(rs.next())
{
	JOptionPane.showMessageDialog(null,"User Already exists");
	response.sendRedirect("reg.jsp");
	return;
}


preparedStatement = con.prepareStatement("insert into Users (name,password,mailid)values(?,?,?)");
preparedStatement.setString(1,user);
preparedStatement.setString(2,password);
preparedStatement.setString(3,mailid);
int result = preparedStatement.executeUpdate();
if(result != 0)
{ 
	JOptionPane.showMessageDialog(null,"success");
	response.sendRedirect("index.html");
}
else
{
	JOptionPane.showMessageDialog(null, "failed");
	response.sendRedirect("reg.jsp");
}
%>
</body>
</html>