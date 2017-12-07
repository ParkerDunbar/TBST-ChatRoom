<!DOCTYPE html>
<html>
<head>
<link href='${pageContext.request.contextPath}/style.css' rel='stylesheet' />
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chit Chat - Login/Register</title>
</head>
<body>
	<div class='panel' id='contentPanel'>
		<div class='panel' id='buttonPanel'>
			<!--<img id='logo' src="<%=request.getContextPath()%>/images/ChitChatLogo.png" /> -->
			<p>Welcome to Chit Chat!</p>
			<div class='panel' id='loginPanel'>
				<a href='/SmallChatRoom/Login'>
					<div id='btnLogin' class='actionButton'>
						<span>Login</span>
					</div>
				</a>
			</div>
			<div class='panel' id='registerPanel'>
				<a href='/SmallChatRoom/Register'>
					<div id='btnRegister' class='actionButton'>
						<span>Register</span>
					</div>
				</a>
			</div>
		</div>
	</div>
</body>
</html>