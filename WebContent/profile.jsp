<%@page import="group.pro150.chatroom.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%User current = (User) session.getAttribute("user"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
<div class='panel'>
	<%=current.getUsername() + "'s Profile"%>
</div>

</body>
</html>