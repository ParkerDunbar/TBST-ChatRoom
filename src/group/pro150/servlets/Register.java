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

	// comp ~ needs error msgs
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String firstname = request.getParameter("Firstname");
		String lastname = request.getParameter("Lastname");

		if (username == null || username.isEmpty() || password == null || password.isEmpty() || firstname == null
				|| firstname.isEmpty() || lastname == null || lastname.isEmpty()) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (username.length() > 16 || firstname.length() > 8 || lastname.length() > 8
				|| password.length() > 16) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			String[] columns = { "Firstname", "Lastname", "Friendlist", "Username", "Password" };
			String sql = DatabaseConnection.SelectWithWhereFromTable("Usercredentials", "UserName", username, columns);
			if (!sql.isEmpty()) {
				// useranme has been taken 
				System.out.println("HERE");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				String[] values = { firstname, lastname, null, username, password };
				DatabaseConnection.InsertIntoTable("UserCredentials", values, columns);
				try {
					User u = new User(firstname, lastname, username, password);
					session.setAttribute("current", u);
				} catch (NoSuchAlgorithmException e) {
					e.printStackTrace();

				}
				response.sendRedirect("Profile");
			}
		}
	}
}
