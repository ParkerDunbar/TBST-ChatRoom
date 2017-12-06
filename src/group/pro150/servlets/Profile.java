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
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String user = (String) session.getAttribute("UserName");
//		String buffer = DatabaseConnection.SelectWithWhereFromTable("userCredential", "username", "user", "ALLCOLUMNS");
//		System.out.println(buffer);
		
		try {
			User current = new User("firstname", "lastname", "username", "password");
			session.setAttribute("user", current);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		
//		String buffer =	DatabaseConnection.SelectFromTable("userCredential", "FirstName", "LastName");
//		System.out.println(buffer);

	}

}
