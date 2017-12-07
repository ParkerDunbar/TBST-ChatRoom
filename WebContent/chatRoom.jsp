<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chat Room</title>
</head>
<script type="text/javascript">
	function send() {
		console.log("Hello")
		Chat.sendMessage();
	}
</script>
<body>
	<%
		String userName = (String) session.getAttribute("UserName");
	%>
	<label> User Name</label>
	<label id="userName"> <%
 	if (userName != null) {
 		out.print(userName);
 	}
 %>
	</label>

	<%
		String RoomName = (String) session.getAttribute("RoomName");
	%>
	<label>Room Name</label>
	<label id="roomName"> <%
 	if (RoomName != null) {
 		out.print(RoomName);
 	}
 %>
	</label>

	<div>
		<textarea id="messageOutput" readonly="readonly" rows="15" cols="10"></textarea>
	</div>
	<div>
		<input id="messageInput" type="text"></input> <input id="sendButton"
			value="Send" type="submit" ondblclick="function send()">
	</div>
	<div>
		<textarea id="onlineUsers" readonly="readonly" rows="15" cols="10"></textarea>
	</div>

	<a href="/Login">Login</a>

	<script src="scripts/jquery.js"></script>
	<script src="scripts/ChatMain.js"></script>

</body>
</html>