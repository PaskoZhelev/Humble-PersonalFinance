package login;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.UserDbUtil;
import database.Database;
import models.users.User;
import utils.CurrencySymbolUtil;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getSession().getAttribute("username") != null){
			response.sendRedirect("/home");
		}
		else{
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		UserDbUtil userDbUtil = new UserDbUtil(database);

		boolean isLoginSuccessful = false;
		try {
			isLoginSuccessful = userDbUtil.isLoginSuccessful(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(isLoginSuccessful) {						
			try {
				user = userDbUtil.findUser(username);
				request.getSession().setAttribute("username", username);
				request.getSession().setAttribute("id", user.getId());
				request.getSession().setAttribute("cash", user.getCash());
				request.getSession().setAttribute("currency", CurrencySymbolUtil.getCurrency(user.getCurrency()));
				
			} catch (Exception e) {			
				e.printStackTrace();
			}
			response.sendRedirect("/home");
			System.out.println("Logged in!");
		} else {
			String unsuccessfulLogin = "Incorrect Username or Password!";
			request.setAttribute("unsuccessfulLogin", unsuccessfulLogin);
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);			
		}
		
	}

}
