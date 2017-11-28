<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
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
	<textarea id="messagelist" readonly="readonly" rows="15" cols="10"></textarea>
	<input id="usertextentry" type="text">


	<script src="scripts/jquery.js"></script>
	<script src="scripts/ChatMain.js"></script>
	<script type="scripts/MessageHandiler"></script>

	<a href="/SmallChatRoom/Login">LOGIN</a>

</body>
</html>

