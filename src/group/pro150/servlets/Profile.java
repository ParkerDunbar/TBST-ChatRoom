package group.pro150.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import group.pro150.Datastore.DatabaseConnection;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String columns = "FirstName";
		String buffer =	DatabaseConnection.SelectFromTable("userCredential", "FirstName", "LastName");
//		String buffer = DatabaseConnection.SelectWithWhereFromTable("userCredential", "FirstName", "Test1", "LastName");
		
	}

}
