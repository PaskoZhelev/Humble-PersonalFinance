package DbUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale.Category;

import database.Database;
import models.transactions.Transaction;
import models.users.User;

public class TransactionDbUtils {
	private Database database;
	private Connection conn;

	public TransactionDbUtils(Database database) {
		this.database = database;
	}

	public void addTransaction(Transaction transaction) throws SQLException {
		try {
			database.connect();
			conn = database.getConnection();

			int user_id = transaction.getUser_id();
			String category = transaction.getCategory();
			double sum = transaction.getSum();
			ResultSet rs = null;
			double cash = 0.0;
			PreparedStatement pst = conn.prepareStatement(
					"INSERT INTO transactions (user_id, category, sum, date, purpose) VALUES(?,?,?,?,?)");
			Date dateSQL = new Date(transaction.getDate().getTime());

			pst.setInt(1, user_id);
			pst.setString(2, category);
			pst.setDouble(3, sum);
			pst.setDate(4, dateSQL);
			pst.setString(5, transaction.getPurpose());

			pst.executeUpdate();

			String sql = "SELECT * FROM users WHERE id ='" + user_id + "'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			if (rs.next()) {
				cash = rs.getDouble("cash");
			}

			if (!category.equals("Revenue")) {
				cash -= sum;
			} else {
				cash += sum;
			}

			pst = conn.prepareStatement("UPDATE users SET cash = ? WHERE id = ?");
			pst.setDouble(1, cash);
			pst.setInt(2, user_id);
			pst.executeUpdate();

			pst.close();

			System.out.println("Transaction Added");
		} catch (Exception e) {
			e.printStackTrace();
		}
		database.disconnect();
	}

	public List<Transaction> getTransactions(int id) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		try {
			database.connect();
			conn = database.getConnection();
			
			ResultSet rs = null;
			PreparedStatement pst = null;
			Transaction transaction = null;
			String sql = "SELECT * FROM transactions WHERE user_id ='" + id + "'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			
			while (rs.next()) {
				String purpose = rs.getString("purpose");
				String category = rs.getString("category");
				double sum = rs.getDouble("sum");
				Date date = rs.getDate("date");
				
				transaction = new Transaction(category, purpose, sum, date);
				transactions.add(transaction);
			}
			
			Collections.reverse(transactions);
			database.disconnect();
			return transactions;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			database.disconnect();
			return null;
		}
	}
}
