<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
</head>
<body>
<form action="regcheck.jsp" method="post">
<table border="0">
 <tr>
 	 <th> Registration Page </th></tr>
 <tr>
  	<td>UserName</td>
  	<td><input type="text" name="username" value="" placeholder="enter name" required></td>
 </tr>
 <tr>
  	<td>Email</td>
  	<td><input type="email" name="mailid" value="" placeholder="enter email id" required></td>
 </tr>
 <tr>
	<td>Password</td>
	<td><input type="password" name="password" value="" placeholder="enter password" id="pwd" required></td>
 </tr>

</table>
<input type="submit" value="submit">
</form>

</body>
</html>