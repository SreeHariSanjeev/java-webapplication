<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
    <body>
        <%
        String email=(String)session.getAttribute("mailid");
        
        //redirect user to login page if not logged in
        if(email==null){
        	response.sendRedirect("index.html");
        }
        %>
        <p>Welcome <%=email%></p>    
        <a href="logout.jsp">Logout</a>
    </body>
</html>