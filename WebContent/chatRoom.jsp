<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='style.css' rel='stylesheet'>
<link href="https://fonts.googleapis.com/css?family=Nunito:400,900"
	rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Room</title>
</head>
<script type="text/javascript">
	function send() {
		//console.log("Hello")
		Chat.sendMessage();
	}
</script>
<body>
	<div id="leftPanel" class="panel2">
		<div id="friendsDiv">
			<label>Friends</label> <br>
			<textarea id="friendslist" readonly="readonly" rows="15" cols="22"></textarea>
		</div>
		<div id="usersDiv">
			<label>Online Users</label> <br>
			<textarea id="onlineUsers" readonly="readonly" rows="15" cols="22"></textarea>
		</div>
	</div>
	<div id="topBarDiv" class="panel2">
		<%
			String userName = (String) session.getAttribute("UserName");
		%>
		<div id="helloDiv">
			<label>Hello </label> <label id="userName"> <%
 	if (userName != null) {
 		out.print(userName);
 	}
 %>
			</label>
		</div>
		<!-- <a href="/Login">Login</a> -->
		<a href="/SmallChatRoom/Profile" id="profileLink"
			class="actionButton2">Profile</a>
	</div>
	<div id="roomNameDiv">
		<%
			String RoomName = (String) session.getAttribute("RoomName");
		%>
		<label>Room Name: </label> <label id="roomName"> <%
 	if (RoomName != null) {
 		out.print(RoomName);
 	}
 %>
		</label>
	</div>

	<a href="/Login">Login</a>

	<div id='mainMessageDiv'>
		<textarea id="messageOutput" readonly="readonly" rows="25" cols="90"></textarea>
		<div id="messageOutDiv">
			<input id="messageInput" type="text"
				placeholder="Type your message here"></input> <input id="sendButton"
				value="Send" type="submit" ondblclick="function send()">
		</div>
	</div>
	<script src="scripts/jquery.js"></script>
	<script src="scripts/ChatMain.js"></script>

</body>
</html>