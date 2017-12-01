<!DOCTYPE html>
<html>
<head>
<link href='style.css' rel='stylesheet' />
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<h1>Index Page</h1>
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