<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html >

<html>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<a href="/LifeWisely/welcome">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
<h2 >LifeWisely</h2>
<h6 style="color:#DAA520">Manage things that matter, better</h6>

</div>

		<form:form name="EditReminder" method="POST">

		<div align="center">
			<table>
				<tr>
				
					<td>Title</td>
					
					<td>${Reminder.getTitle()}</td>
				</tr>
					<tr>
				
					<td>Name</td>
					
					<td>${Reminder.getName()}</td>
				</tr>
			
				<tr>
					<td>Category</td>
					 <td>${Reminder.getCategory()}</td>
				</tr>
				<tr>
					<td>Frequency</td>
					<td><input type="text" name="Frequency" value="${Reminder.getFrequency()}" /></td>
				</tr>
				<tr>
					<td>StartTime</td>
					<td><input type="text" name="StartTime" value=${Reminder.getStartTime()} /></td>
				</tr>
				<tr>
					<td>EndTime</td>
					<td><input id="text" type="date" name="EndTime" value=${Reminder.getEndTime()} /></td>
				</tr>
				<tr>
					<td>NotifMode</td>
					<td><input type="text" name="NotifMode" value=${Reminder.getNotifMode()} /></td>
				</tr>
				<tr>
					<td>Reward Points</td>
					<td><input type="text" name="RewardPoints" value=${Reminder.getRewardPoints()} /></td>
				</tr>
				<tr>
					<td>Completed</td>
					<td> <select name="isCompleted">
  <option value="0">Not Completed</option>
  <option value="1">Completed</option>
</select> </td>
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