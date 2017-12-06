<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet' />
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div id='nav'>
		<div class='panel' id='backButton'>
			<a href='index.jsp'>
				<div id='btnBack' class='actionButton'>	
					<span>Back</span>
				</div>
			</a>
		</div>
	</div>
<div id='contentPanel3' class='panel'>
	<div id='regFormPanel' class='panel'>
	<form method="Post" action="Register">
		<label>Username: </label> <input type="text" id="Username" name="Username">
		<br>
		<label>Password: </label> <input type="password" id="Password" name="Password">
		<br>
		<label>First Name: </label> <input type="text" id="Firstname" name="Firstname">
		<br>
		<label>Last Name: </label> <input type="text" id="Lastname" name="Lastname">
		<br>
		 <input type="submit" id=submit value="Register">
	</form>
	</div>
	
</div>
	
</body>
</html>