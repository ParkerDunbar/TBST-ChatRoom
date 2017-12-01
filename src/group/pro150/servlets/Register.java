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
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		String firstname = request.getParameter("Firstname");
		String lastname = request.getParameter("Lastname");

			for (int i = 0; i < ChatRoom.users.size(); i++) {
				if (ChatRoom.users.get(i).getUsername().equals(username)) {
					throw new IllegalArgumentException();
				}
			}
			User u = null;
			try {
				u = new User(firstname, lastname, username, password);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ChatRoom.users.add(u);
			String[] values = {u.getFirstName(), u.getLastName(), null, u.getUsername(), u.getPassword().getEncodedPass(), u.getPassword().getRandGenStr()};
			String[] columns = {"Firstname", "Lastname", "Friendslist", "Username", "Password", "RandPassword"};
			DatabaseConnection.InsertIntoTable("Users", values, columns);
			session.setAttribute("Username", username);
			request.getRequestDispatcher("ChatRoom").forward(request, response);
			// String[] values = { UserName };
			// String[] columns = { "UserId", "UserName" };
			//
			// if (DatabaseConnection.InsertIntoTable("UserCredentials", values, columns)) {
			// //request.getRequestDispatcher("login.jsp").forward(request, response);
			// }

	}

}
