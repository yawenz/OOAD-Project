<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>You are here to ${purpose} group</p>
	<form:form  modelAttribute="UserGroup" method="POST">
		<div align="center">
			<table>
				<tr>
					<td>Group Name</td>
					<td><input type="text" name="GroupName" /></td>
				</tr>
				<tr>
					<td>Simple Description </td>
					<td><input type="text" name="GroupDescription"></td>
				</tr>
				<tr>
					<td>Member's username</td>
					<td><input type="text" name="GroupMember1"></td>
				</tr>
				<tr>
					<td> <input type="submit" value="add more member"> </td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>	
			</table>
		</div>
	</form:form>

</body>
</html>