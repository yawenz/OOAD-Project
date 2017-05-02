<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LifeWisely Registration Form</title>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
</head>

<body>
<div align="center">
    		<a href="/LifeWisely">
<img align="middle" style="width: auto; height: auto;max-width: 200px;max-height: 200px" src="http://www.colorado.edu/libraries/profiles/express/themes/expressbase/images/cu-logo.svg">
</a>
<h2 >LifeWisely</h2>
<h6 style="color:#DAA520">Manage things that matter, better</h6>

</div>
<div style="clear:both" class="form-group">
    <form:form method="POST" modelAttribute="User" cssClass="form-horizontal">
    	<div align="center">	
    		
			<table>
				<tr>
					<td>User Name</td>
					<td><input class="col-sm-8 control-label" type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input class="col-sm-8 control-label" type="password" name="password" /></td>
				</tr>
			</table>
		
        <button class="btn btn-primary" type="submit">Submit</button>
        </div>
        
    </form:form>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>