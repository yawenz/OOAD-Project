<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Success Form</title>
</head>
<body>
	<div align="center">
		<h1>System Log</h1>
		<c:if test="${ syslog != null }">
 		<table border="1">
        	<tr>
      		      <td>Username</td>
            	      <td>Rewards Earned So far</td>
        	</tr>
    	    	<c:forEach items="${syslog}" var="reminder">
    		<tr>      
       			<td>${reminder.getOwner()}</td>
       			<td>${reminder.getSumRewards()}</td>
       		</tr>
		</c:forEach>
    		</table> 
		</c:if>
	</div>
</body>
</html>
