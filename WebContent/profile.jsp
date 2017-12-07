<%@page import="group.pro150.chatroom.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	User current = (User) session.getAttribute("current");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>

	<H1><%=current.getUsername()%>'s Profile
	</H1>
	<H3>
		First Name:
		<%=current.getFirstName()%></H3>
	<H3>
		Last Name:
		<%=current.getLastName()%></H3>
		
		
	<H3>Friends List:</H3>
	<div>
		<textarea id="friendslist" rows="15" cols="10"></textarea>
	</div>
	
	<hr>
	
	<input type="button" id="mainroom" value="Main Room">
	<br>
	<label>Create a private chat room</label>
	<br>
	<input type="text" id="roomname" name="roomname">
	<input type="submit" id=submit value="Create Room">
	<input type="submit" id=submit value="Join Room">


</body>
</html>