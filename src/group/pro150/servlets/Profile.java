package group.pro150.servlets;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.pro150.Datastore.DatabaseConnection;
import group.pro150.chatroom.model.User;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("profile.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String roomName = request.getParameter("RoomName");
		User u = (User) session.getAttribute("current");
		if (roomName == null || roomName.isEmpty()) {
			roomName = "TEST";
			System.out.println(roomName);
			session.setAttribute("UserName", u.getUsername());
			session.setAttribute("RoomName", roomName);
		} else {
			System.out.println(roomName);
			session.setAttribute("UserName", u.getUsername());
			session.setAttribute("RoomName", roomName);
		}
		response.sendRedirect("ChatRoom");
	}

}
