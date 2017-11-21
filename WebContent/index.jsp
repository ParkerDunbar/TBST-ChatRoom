<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" uri="/WEB-INF/pages" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<t:layoutPage>
	<jsp:attribute name="header">
		<h1>Register</h1>
	</jsp:attribute>
	<jsp:attribute name="footer">
		<p>Copyright 2017, The Broken Spirit Tribe</p>
	</jsp:attribute>
	<jsp:body>
		<form method="post" action="registeruser">
		<label>User Name</label> <input type="text" name="UserName"> <input
			type="submit" name="register">
	</form>
	</jsp:body>
</t:layoutPage>
	
</body>
</html>