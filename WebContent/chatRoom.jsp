<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chatroom</title>
</head>
<script type="text/javascript">
	function send() {
		Chat.sendMessage();
	}
</script>
<body>
	<%
		String userName = (String) session.getAttribute("UserName");
	%>
	<label id="userName"> <%
 	if (userName != null) {
 		out.print(userName);
 	}
 %>
	</label>

	<textarea id="messageOutput" readonly="readonly" rows="10" cols="15"></textarea>
	<textarea id="onlineUsers" readonly="readonly" rows="10" cols="15"></textarea>
	<input id="messageInput" type="text">
	<input id="sendButton" value="Send" type="submit"
		ondblclick="function send()">

</body>
</html>

