<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Success Form</title>
</head>
<body>
	<h2> Welcome ${UserName} </h2>
	<h4 class="text-center"><a href="/LifeWisely/CreateReminder">Create Reminder</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/DeleteReminder">Delete Reminder</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/EditReminder">Edit Reminder</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/CreateGroup">Create Group</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/DeleteGroup">Delete Group</a></h4>
	<c:if test="${ allReminders != null }">
 <table border="1">
        <tr>
            <td>Reminder title</td>
            <td>Category</td>
            <td>Frequency</td>
            <td>Start Time:</td>
            <td>End Time:</td>
            <td>Edit Reminder:</td>
            <td>Delete Reminder:</td>
        </tr>
        <c:forEach items="${allReminders}" var="reminder">
    <tr>      
       <td>${reminder.getTitle()}</td>
       <td>${reminder.getCategory()}</td>
       <td>${reminder.getFrequency()}</td>
       <td>${reminder.getStartTime()}</td>
       <td>${reminder.getEndTime()}</td> 
       <td><a href="/LifeWisely/EditReminder?getId=${reminder.getID()}">Edit Reminder</a></td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
</body>
</html>