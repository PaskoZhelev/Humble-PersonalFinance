package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.Database;

public class CategoryCalcUtil {
	private Database database;
	private Connection conn;

	public CategoryCalcUtil(Database database) {
		this.database = database;
	}
	
	public double calculateAll(int id) {
		try {
			database.connect();
			conn = database.getConnection();
			ResultSet rs = null;
			PreparedStatement pst = null;
			String sql = "SELECT * FROM users WHERE id ='" + id + "'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			double cash = 0;
			while (rs.next()) {
				cash = rs.getDouble("cash");				
			}	
			
			return cash;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0.0;
		}
	}
	
	public double calculate(int id, String category) {
		try {
			database.connect();
			conn = database.getConnection();
			ResultSet rs = null;
			PreparedStatement pst = null;
			String sql = "SELECT * FROM transactions WHERE user_id ='" + id + "' AND category ='" + category + "'";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery(sql);
			double sum = 0;
			while (rs.next()) {
				sum += rs.getDouble("sum");				
			}	
			
			return sum;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0.0;
		}
	}
}
