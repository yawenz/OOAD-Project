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
<div align="center">
<a href="/LifeWisely/login">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
</div>
<div align="center">
		
	<h2 style="float:left"> Welcome ${UserName} </h2>
	<h4 style="float: right"><a href="/LifeWisely/logout">Logout</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/CreateReminder">Create Reminder</a></h4>
	<h4 class="text-center"><a href="/LifeWisely/CreateGroup">Create Group</a></h4>
	</div>
<div align="center">	
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
       <td><a href="/LifeWisely/EditReminder?getId=${reminder.getID()}">Edit</a></td>
       <td><a href="/LifeWisely/DeleteReminder?getId=${reminder.getID()}">Delete</a></td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
	</div>
</body>
</html>