<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suspend User Form</title>
</head>
<body>
	<form:form name="suspendUser" method="POST">

		<div align="center">
		<h1> Suspend/Revoke User Account</h1>
			<table>
				<tr>
					<td>User Name</td>
					<td><input type="text" name="username" /></td>
				</tr>
				</table>
				<p> </p>
				  <button type="submit" name="suspendUser">Suspend</button>
				  <button type="submit" name="revokeUser">Revoke</button>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>