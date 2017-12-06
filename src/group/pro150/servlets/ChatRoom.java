package group.pro150.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.pro150.chatroom.model.User;

@WebServlet("/ChatRoom")
public class ChatRoom extends HttpServlet {
	public static List<User> users;
	public static Map<String, User> cookies;
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("chatRoom.jsp").forward(request, response);
	}

}
