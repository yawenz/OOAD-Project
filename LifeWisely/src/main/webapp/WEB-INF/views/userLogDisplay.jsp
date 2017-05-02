<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>
		<div align="center">
		<h1>User Log</h1>
	<c:if test="${ allReminders != null }">
 <table border="1">
        <tr>
            <td>Reminder title</td>
            <td>Description</td>
            <td>Category</td>
            <td>Frequency</td>
            <td>Notification Mode</td>
            <td>Start Time</td>
            <td>End Time</td>
            <td>Rewards Earned</td>
        </tr>
        <c:forEach items="${allReminders}" var="reminder">
    <tr>      
       <td>${reminder.getTitle()}</td>
       <td>${reminder.getName()}</td>
       <td>${reminder.getCategory()}</td>
       <td>${reminder.getFrequency()}</td>
       <td>${reminder.getNotifMode()}</td>
       <td>${reminder.getStartTime()}</td>
       <td>${reminder.getEndTime()}</td>
       <td>${reminder.getRewardPoints()}</td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
	</div>
</body>
</html>