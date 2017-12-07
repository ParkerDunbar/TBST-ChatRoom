<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
	<div class='panel' id='contentPanel2'>
		<div class='panel' id='formPanel'>
			<form method="Post" action="Login">
				<div id="UsernameDiv"><label>Username: </label> <input id="Username" type="text" name="Username"></div>	
				<div id="PasswordDiv"><label>Password: </label> <input id="Password" type="password" name="Password"></div>
				<input id="btnLogin" type="submit" value="Login">
			</form>
		</div>
	</div>
</body>
</html>