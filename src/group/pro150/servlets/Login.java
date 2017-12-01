package group.pro150.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.pro150.Datastore.DatabaseConnection;
import group.pro150.chatroom.model.GhostMethods;
import group.pro150.chatroom.model.User;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Cookie[] cookies = request.getCookies();
		String username = null;
		for (Cookie c : cookies) {
			if ("_username".equals(c.getName())) {
				username = c.getValue();
				break;
			}
		}

		if (username == null) {
			// Not Logged in. Redirect to Login
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		session.setAttribute("Username", username);
		request.getRequestDispatcher("chatRoom.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");

		User u;
		int spot = -1;
		for (int i = 0; i < ChatRoom.users.size(); i++) {
			if (ChatRoom.users.get(i).getUsername().equals("usernameInput")) {
				spot = i;
			}
		}
		if (spot == -1) {
			throw new IllegalArgumentException();
		}
		u = ChatRoom.users.get(spot);
		try {
			if (!u.checkPassword(password)) {
				throw new IllegalArgumentException();
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Cookie cookie = new Cookie("Username", username);
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);

		session.setAttribute("Username", username);
		request.getRequestDispatcher("chatRoom.jsp").forward(request, response);

	}

}
