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
import group.pro150.chatroom.model.User;

//Comp ~needs Error 
/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			String[] columns = { "Firstname", "Lastname", "Friendlist", "Username", "Password" };
			String sql = DatabaseConnection.SelectWithWhereFromTable("userCredentials", "UserName", username, columns);
			if (!sql.isEmpty()) {
				String c = "Password";
				String p = DatabaseConnection.SelectWithWhereFromTable("UserCredentials", "Password", password, c);
				if (p.equals(password)) {
					String[] s = { "FirstName" };
					String firstName = DatabaseConnection.SelectWithWhereFromTable("UserCredentials", "UserName",
							username, s);
					String[] l = { "lastname" };
					String lastname = DatabaseConnection.SelectWithWhereFromTable("UserCredentials", "UserName",
							username, l);
					try {
						User u = new User(firstName, lastname, username, password);
						session.setAttribute("current", u);
					} catch (NoSuchAlgorithmException e) {
						e.printStackTrace();
					}
					response.sendRedirect("Profile");
				}
			} else {
				request.getRequestDispatcher("register.jsp");
			}
		}
	}

}
