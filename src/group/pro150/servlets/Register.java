package group.pro150.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.pro150.Datastore.DatabaseConnection;

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
		String UserName = request.getParameter("UserName");
		if (UserName == null || UserName.isEmpty()) {

		} else {
			session.setAttribute("UserName", UserName);
			request.getRequestDispatcher("ChatRoom").forward(request, response);
			// String[] values = { UserName };
			// String[] columns = { "UserId", "UserName" };
			//
			// if (DatabaseConnection.InsertIntoTable("UserCredentials", values, columns)) {
			// //request.getRequestDispatcher("login.jsp").forward(request, response);
			// }

		}
	}

}
