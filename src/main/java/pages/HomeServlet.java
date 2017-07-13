package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.EnumSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.TransactionDbUtils;
import DbUtils.UserDbUtil;
import database.Database;
import models.transactions.Transaction;
import models.users.User;
import utils.CategoryCalcUtil;
import utils.CurrencySymbolUtil;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int user_id = (Integer) request.getSession().getAttribute("id");
		CategoryCalcUtil calcUtil = new CategoryCalcUtil(database);
		TransactionDbUtils transactionDbUtils = new TransactionDbUtils(database);
		UserDbUtil userDbUtil = new UserDbUtil(database);
		User user;
		try {
			user = userDbUtil.findUser(user_id);
			request.getSession().setAttribute("currency", CurrencySymbolUtil.getCurrency(user.getCurrency()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
		double shoppingCategorySum = calcUtil.calculate(user_id, "Shopping");
		double foodCategorySum = calcUtil.calculate(user_id, "Food");
		double billsCategorySum = calcUtil.calculate(user_id, "Bills");
		double othersCategorySum = calcUtil.calculate(user_id, "Others");
		double cash = calcUtil.calculateAll(user_id);
		
		List<Transaction> transactions = transactionDbUtils.getTransactions(user_id);
		
		request.getSession().setAttribute("transactions", transactions);
		request.getSession().setAttribute("shoppingSum", shoppingCategorySum);
		request.getSession().setAttribute("foodSum", foodCategorySum);
		request.getSession().setAttribute("billsSum", billsCategorySum);
		request.getSession().setAttribute("othersSum", othersCategorySum);
		request.getSession().setAttribute("cash", cash);
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String purpose = request.getParameter("purpose");
		double sum = Double.valueOf(request.getParameter("sum"));
		String category = request.getParameter("i-category");
		String dateString = request.getParameter("date");
		SimpleDateFormat formatter;		
		formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date = null;
		try {
			date = formatter.parse(dateString);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		int userId = (Integer) request.getSession().getAttribute("id");		
		Transaction transaction = new Transaction(userId, category, purpose, sum, date);
		TransactionDbUtils transactionDbUtils = new TransactionDbUtils(database);
		
		
		try {
			transactionDbUtils.addTransaction(transaction);
			String succesfulTransaction = "Successful Transaction";
			request.setAttribute("succesfulTransaction", succesfulTransaction);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("/home");
	}

}
