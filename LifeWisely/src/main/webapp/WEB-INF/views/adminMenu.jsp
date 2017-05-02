<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>
	<font color="green">
		Hello
	</font>
	<h2>${msg}</h2> You have successfully logged in.
	<font color="green">
		Welcome to Life Wisely!
	</font>
	
	<p><a href="registration">Add User Account</a></p>
	<p><a href="suspendUser">Suspend/Revoke User Account</a></p>
	<p><a href="deleteUser">Delete User Account</a></p>
	<p><a href="userLog">Generate User Log</a></p>
	<p><a href="systemLog">Generate System Log</a></p>

	
</body>
</html>