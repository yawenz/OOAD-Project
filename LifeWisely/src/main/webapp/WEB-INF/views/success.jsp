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
	<h4 class="text-center"><a href="/LifeWisely/CreateGroup">Create Group</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/DeleteReminder">Delete Reminder</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/EditReminder">Edit Reminder</a></h4>
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
	<!--  group reminder -->
		<c:if test="${ allGroupReminders != null }">
 <table border="1">
 		<tr> <td> Group Reminders </td> </tr>
        <tr>
            <td>Reminder title</td>
            <td>Category</td>
            <td>Frequency</td>
            <td>Start Time:</td>
            <td>End Time:</td>
			<td>Group Name:</td>
			<td>Group Description:</td>
			<td>Leave Group:</td>
        </tr>
        <c:forEach items="${allGroupReminders}" var="reminder">
    <tr>      
       <td>${reminder.getRem().getTitle()}</td>
       <td>${reminder.getRem().getCategory()}</td>
       <td>${reminder.getRem().getFrequency()}</td>
       <td>${reminder.getRem().getStartTime()}</td>
       <td>${reminder.getRem().getEndTime()}</td> 
       <td>${reminder.getGroupName()}</td>
       <td>${reminder.getGroupDescription()}</td>
       <td><a href="/LifeWisely/LeaveGroup?getId=${reminder.getId()}">Leave</a></td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
</body>
</html>