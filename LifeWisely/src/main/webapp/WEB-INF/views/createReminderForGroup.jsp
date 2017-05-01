<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
  <script>
  $(document).ready(function() {
   // $("#startdatepicker").datepicker();
    $("#enddatepicker").datepicker();
    
  });
  </script>
</head>
<body>
<p>You are here to ${purpose} Reminder for Group</p>
		<form:form modelAttribute="createReminderForGroup" method="POST">

		<div align="center">
			<table>
			<input type="hidden" name="Owner" value="__group_purpose__" />
				<tr>
				
					<td>Name</td>
					
					<td><input type="text" name="Name" /></td>
				</tr>
				<tr>
					<td>Category</td>
					<td><input type="text" name="Category" /></td>
				</tr>
				<tr>
					<td>Frequency</td>
					<td><input type="text" name="Frequency" /></td>
				</tr>
				<tr>
					<td>StartTime</td>
					<td><input type="datetime-local" name="StartTime" /></td>
				</tr>
				<tr>
					<td>EndTime</td>
					<td><input id="enddatepicker" type="date" name="EndTime" /></td>
				</tr>
				<tr>
					<td>NotifMode</td>
					<td><input type="text" name="NotifMode" /></td>
				</tr>
				<tr>
					<td>RewardPoints</td>
					<td><input type="number" name="RewardPoints" /></td>
				</tr>
				
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
			<div style="color: red">${error}</div>

		</div>
	</form:form>
	
</body>
</html>