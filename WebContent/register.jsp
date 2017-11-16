<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

	<%
		String errmsg = null;
		if (session != null && (errmsg = (String) session.getAttribute("error-msg")) != null) {
	%>
	<dir style="color: red">
		<%
			out.print(errmsg);
				session.removeAttribute("error-msg");
		%>

	</dir>
	<%
		}
	%>
	<form method="POST" action="RegisterUser">
		<label>First Name</label> <input type="text" name="firstName">
		<label>Last Name</label> <input type="text" name="lastName"> <label>User
			Name</label> <input type="text" name="userName"> <label>Password</label>
		<input type="password" name="password"> <label>
			Confirm Password</label> <input type="password" name="conPassword"> <input
			type="submit" value="Register" name="submit">
	</form>


</body>
</html>