<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<title>Insert title here</title>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
</head>
<body>
<div align="center">
<a href="/LifeWisely/welcome">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
<h2 >LifeWisely</h2>
<h6 style="color:#DAA520">Manage things that matter, better</h6>

</div>
		<form:form name="createReminder" method="POST" cssClass="form-horizontal">

		<div align="center">
			<table>
			<input type="hidden" name="Owner" value="${purpose}" />
				<tr>
				
					<td>Title</td>
					
					<td><input class="col-sm-8 control-label" type="text" name="Title" /></td>
				</tr>
				<tr>
				
					<td>Description</td>
					
					<td><input class="col-sm-8 control-label" type="text" name="Name" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><select name="Category">
  <option value="health-Drink water">Drink water</option>
  <option value="hygiene-Cut nails">Cut nails</option>
</select>
					</td>
				</tr>
				<tr>
					<td>Frequency</td>
					<td><select name="Frequency">
  <option value="0.5">30 mins</option>
  <option value="1">1 hour</option>
  <option value="12">12 hours</option>
</select>
					</td>
				</tr>
				<tr>
					<td>StartTime</td>
					<td><input class="col-sm-8 control-label" type="datetime-local" name="StartTime" /></td>
				</tr>
				<tr>
					<td>EndTime</td>
					<td><input class="col-sm-8 control-label" type="datetime-local" name="EndTime" /></td>
				</tr>
				<tr>
					<td>NotifMode</td>
					<td><select name="NotifMode">
					<option value="Email">Email</option>
					</select></td>
				</tr>
				<tr>
					<td>RewardPoints</td>
					<td><input class="col-sm-8 control-label" type="number" name="RewardPoints" /></td>
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