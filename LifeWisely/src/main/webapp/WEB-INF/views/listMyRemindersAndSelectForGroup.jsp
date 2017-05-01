<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>    
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Your existing Reminders </h2>
	<c:if test="${ allReminders != null }">
 <table border="1">
        <tr>
            <td>Reminder title</td>
            <td>Category</td>
            <td>Frequency</td>
            <td>Start Time:</td>
            <td>End Time:</td>
            <td>Select: </td>
        </tr>
        <c:forEach items="${allReminders}" var="reminder">
    <tr>      
       <td>${reminder.getTitle()}</td>
       <td>${reminder.getCategory()}</td>
       <td>${reminder.getFrequency()}</td>
       <td>${reminder.getStartTime()}</td>
       <td>${reminder.getEndTime()}</td> 
       <td><a href="/LifeWisely/AddAsGroupReminder?getId=${reminder.getID()}">Select</a></td>
       </tr>
</c:forEach>
    </table> 
	</c:if>
</body>
</html>