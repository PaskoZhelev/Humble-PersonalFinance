package pages;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DbUtils.TransactionDbUtils;
import database.Database;
import models.transactions.Transaction;

@WebServlet("/add-cash")
public class AddCashServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Database database = new Database();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/add-cash.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String purpose = request.getParameter("purpose");
		double sum = Double.valueOf(request.getParameter("sum"));
		String category = "Revenue";
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
