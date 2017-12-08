<%@page import="group.pro150.chatroom.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%-- <%
	User current = (User) session.getAttribute("current");
%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile</title>
</head>
<body>
	<div id='profileContent' class='panel'>
		<div id='userInfoPanel' class='panel2'>
			<%-- <span><%=current.getUsername()%>'s Profile</span>--%>
			<label>First Name: </label><%--<label id="firstNameLabel><%=current.getFirstName()%></label>--%>
			<br>
			<label>Last Name: </label><%--<label id="lastNameLabel"><%=current.getLastName()%></label>--%>
		</div>
		<br>
		<div id="friendsDiv">
			<label>Friends</label> <br>
			<textarea id="friendslist" readonly="readonly" rows="15" cols="22"></textarea>
		</div>
	<!-- <hr>
	<br> -->
		<br>
		<div id='newRoomDiv'>
			<label>Create a private chat room</label>
			<br>
			<form method="Post" action="Profile">
				<input type="text" id="RoomName" name="RoomName">
				<input type="submit" id=submit value="Create Room">
				<input type="submit" id=submit value="Join Room">
			</form>
		</div>
	</div>
</body>
</html>