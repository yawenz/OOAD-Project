<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >
<html>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeWisely Login Form</title>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
</head>
<body>
	<form:form name="submitForm" method="POST" cssClass="form-horizontal">

		<div align="center">
		<a href="/LifeWisely">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
<div align="center" class="container">
<h2 >LifeWisely</h2>
<h6 style="color:#DAA520">Manage things that matter, better</h6>
</div>
			<table >
				<tr>
					<td>User Name</td>
					<td><input class="col-sm-8 control-label" type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input class="col-sm-8 control-label" type="password" name="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="btn btn-primary" type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
</body>
</html>