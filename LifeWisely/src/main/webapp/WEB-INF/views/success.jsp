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
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<title>Home Page</title>
</head>
<body>
<div align="center">
<a href="/LifeWisely/welcome">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
<h2 >LifeWisely</h2>
<h6 style="color:#DAA520">Manage things that matter, better</h6>

</div>
<div align="center">
	<h2 style="float:left"> Welcome ${UserName} </h2>
	<h4 style="float: right"><a class="btn btn-primary" href="/LifeWisely/logout">Logout</a></h4>
</div>
<br>

<div class="container" align="center">	
	<a style="display:inline" class="btn btn-primary" href="/LifeWisely/CreateReminder">Create Reminder</a>
	<a style="display:inline" class="btn btn-primary" href="/LifeWisely/CreateExistingReminder">Create Existing Reminder</a>
	<a style="display:inline" class="btn btn-primary" href="/LifeWisely/CreateGroup">Create Group</a>
	<a style="display:inline" class="btn btn-success" href="/LifeWisely/UndoDelete">Undo delete reminder</a>
	
	</div>
<div align="center">	
	<c:if test="${ allReminders != null }">
 <table class="table table-hover" border="1">
        <tr>
            <th>Reminder title</th>
            <th>Category</th>
            <th>Frequency</th>
            <th>Start Time</th>
            <th>End Time</th>
            <th>Edit Reminder</th>
            <th>Delete Reminder</th>
        </tr>
        <c:forEach items="${allReminders}" var="reminder">
    <tr>      
       <td>${reminder.getTitle()}</td>
       <td>${reminder.getCategory()}</td>
       <td>${reminder.getFrequency()}</td>
       <td>${reminder.getStartTime()}</td>
       <td>${reminder.getEndTime()}</td> 
       <td><a class="btn btn-info" href="/LifeWisely/EditReminder?getId=${reminder.getID()}">Edit</a></td>
       <td><a class="btn btn-danger" href="/LifeWisely/DeleteReminder?getId=${reminder.getID()}">Delete</a></td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
	<!--  group reminder -->
		<c:if test="${ allGroupReminders != null }">
 <table class="table table-hover" border="1">
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
       </tr>
</c:forEach>
    </table> 
	</c:if>
	</div>
</body>
</html>
