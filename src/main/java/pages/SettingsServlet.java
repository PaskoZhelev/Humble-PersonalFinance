package pages;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.UserDbUtil;
import database.Database;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/settings.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String button = request.getParameter("submit-button");
		int id = (Integer) request.getSession().getAttribute("id");
		UserDbUtil userDbUtil = new UserDbUtil(database);
		
		if (button.equals("password")) {
			String password = request.getParameter("password");
			userDbUtil.updatePassword(id, password);
			String successfulPasswordChange = "successfulPasswordChange";
			request.setAttribute("successfulPasswordChange", successfulPasswordChange);
		} else{
			int currency = Integer.valueOf(request.getParameter("currency"));
			userDbUtil.updateCurrency(id, currency);
			String successfulCurrencyChange = "successfulCurrencyChange";
			request.setAttribute("successfulCurrencyChange", successfulCurrencyChange);
		}
				
		request.getRequestDispatcher("/WEB-INF/views/settings.jsp").forward(request, response);
	}

}
