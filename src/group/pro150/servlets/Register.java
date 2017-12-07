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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");

		User u = null;
		try {
			u = new User(firstname, lastname, username, password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		

		String[] values = { u.getFirstName(), u.getLastName(), null, u.getUsername(), u.getPassword().getEncodedPass(),
				u.getPassword().getRandGenStr() };
		String[] columns = { "Firstname", "Lastname", "Friendlist", "Username", "Password", "RandPassword" };
		DatabaseConnection.InsertIntoTable("UserCredentials", values, columns);

		if (username != null) {
			session.setAttribute("current", u);
			response.sendRedirect("Profile");
		}
	}

}
