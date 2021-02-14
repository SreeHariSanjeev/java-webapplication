<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
	<table border="0">
	<tr>
		<th> Login Page </th></tr>
	<tr>
		<td>Email</td>
		<td> <input type="email" name="mailid" value="" placeholder="enter mailid" required></td>
	</tr>
	<tr>
		<td>Password</td>
		<td> <input type="password" name="password" value="" placeholder="enter password" required></td>
	</tr>
	<tr><td colspan="1" align="center"><input type="submit" value="submit"></td></tr>
	</table>
</form>
</body>
</html>