<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring Login Form</title>
</head>
<body>
	<form:form name="submitForm" method="POST">

		<div align="center">
		<a href="/LifeWisely">
			<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
		</a>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			<button type="submit" name="userLogin">User Login</button>
 			<button type="submit" name="adminLogin">Admin Login</button>
			<div style="color: red">${error}</div>
		</div>
	</form:form>
</body>
</html>
