<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet' />
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<div class='panel' id='contentPanel'>
	<div class='panel' id='buttonPanel'>
	<!--<img id='logo' src="<%=request.getContextPath()%>/images/ChitChatLogo.png" /> -->
		<p> Welcome to Chit Chat! </p>
		<div class='panel' id='loginPanel'>
			<a href='login.jsp'>
				<div id='btnLogin' class='actionButton'>	
					<span>Login</span>
				</div>
			</a>
		</div>
		<div class='panel' id='registerPanel'>
			<a href='register.jsp'>
				<div id='btnRegister' class='actionButton'>	
					<span>Register</span>	
				</div>
			</a>
		</div>
	</div>
</div>
</body>
</html>