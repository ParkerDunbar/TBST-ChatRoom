package group.pro150.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import group.pro150.database.DatabaseConnection;

@WebServlet("/Register")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String firstName, lastName, userName, password, conPassword;
		firstName = request.getParameter("firstName");
		lastName = request.getParameter("lastName");
		userName = request.getParameter("userName");
		password = request.getParameter("password");
		conPassword = request.getParameter("conPassowrd");
		if (firstName == null || firstName.isEmpty()) {
			session.setAttribute("error-msg", "Please Enter Your First Name");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (lastName == null || lastName.isEmpty()) {
			session.setAttribute("error-msg", "Please Enter Your Last Name");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (userName == null || userName.isEmpty()) {
			session.setAttribute("error-msg", "Please Enter Your User Name");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (password == null || password.isEmpty()) {
			session.setAttribute("error-msg", "Please Enter Your Password");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (conPassword == null || conPassword.isEmpty()) {
			session.setAttribute("error-msg", "Please Enter Your Confermation Password");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			String isusedUserName = DatabaseConnection.SelectWithWhereFromTable("users", "userName", userName,
					"userName");
			if (isusedUserName.equals(userName)) {
				session.setAttribute("error-msg", "User Name Has Been Taken");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			} else {
				// add to data base
			}

		}

	}

}
