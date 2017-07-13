package register;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.UserDbUtil;
import database.Database;
import models.users.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		double cash = Double.valueOf(request.getParameter("cash"));
		int currency = Integer.valueOf(request.getParameter("currency"));
		
		User user = new User(username, password, cash, currency);
		UserDbUtil userDbUtil = new UserDbUtil(database);
		try {
			if (!userDbUtil.isUsernameTaken(username)) {
				try {
					userDbUtil.addUser(user);
					String successfulRegistration = "The Registration is Successful!";
					request.setAttribute("successfulRegistration", successfulRegistration);
					request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
			} else {
				String usernameTaken = "Username is already taken!";
				request.setAttribute("usernameTaken", usernameTaken);
				request.getRequestDispatcher("/WEB-INF/views/register.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}