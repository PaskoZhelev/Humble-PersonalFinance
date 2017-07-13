package DbUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;
import models.users.User;

public class UserDbUtil {
	private Database database;
	private Connection conn;

	public UserDbUtil(Database database) {
		this.database = database;
	}

	public void addUser(User person) throws SQLException {
		try {
			database.connect();
			conn = database.getConnection();
			PreparedStatement pst = conn
					.prepareStatement("INSERT INTO users(username, password, cash, currency) VALUES(?,MD5(?),?,?)");

			pst.setString(1, person.getUsername());
			pst.setString(2, person.getPassword());
			pst.setDouble(3, person.getCash());
			pst.setInt(4, person.getCurrency());

			pst.executeUpdate();

			pst.close();

			System.out.println("User Added");
		} catch (Exception e) {
			e.printStackTrace();
		}
		database.disconnect();
	}

	public boolean isLoginSuccessful(User user) throws Exception {

		boolean isSuccessful = false;
		try {
			database.connect();
			conn = database.getConnection();
			String username = user.getUsername();
			String password = user.getPassword();
			ResultSet rs = null;
			PreparedStatement pst = null;
			if (username != null && password != null) {
				String sql = "SELECT * FROM users WHERE username ='" + username + "' AND password = MD5('" + password
						+ "')";
				pst = conn.prepareStatement(sql);
				rs = pst.executeQuery(sql);
				if (rs.next()) {
					isSuccessful = true;
					System.out.println("Login successful!");
				} else {
					System.out.println("Login unsuccessful!");
					isSuccessful = false;
				}
			}
		} catch (Exception err) {
			System.out.println(err.getMessage());
			isSuccessful = false;
		}
		database.disconnect();
		return isSuccessful;
	}

	public boolean isUsernameTaken(String username) throws Exception {
		boolean isTaken = false;
		try {
			database.connect();
			conn = database.getConnection();
			ResultSet rs = null;
			PreparedStatement stmt = null;
			if (username != null) {
				String sql = "SELECT * FROM users WHERE username ='" + username + "'";
				stmt = conn.prepareStatement(sql);
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					isTaken = true;
				} else {
					isTaken = false;
				}
			}

		} catch (Exception err) {
			err.getMessage();
			isTaken = false;
		}
		database.disconnect();
		return isTaken;
	}

	public User findUser(String username) throws ClassNotFoundException, SQLException {

		database.connect();
		conn = database.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		User user = null;
		String sql = "SELECT * FROM users WHERE username ='" + username + "'";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			int id = rs.getInt("id");
			double cash = rs.getDouble("cash");
			int currency = rs.getInt("currency");

			user = new User(id, username, cash, currency);
		}
		rs.close();
		stmt.close();

		return user;
	}

	public User findUser(int id) throws ClassNotFoundException, SQLException {

		database.connect();
		conn = database.getConnection();
		ResultSet rs = null;
		PreparedStatement stmt = null;
		User user = null;
		String sql = "SELECT * FROM users WHERE id ='" + id + "'";
		stmt = conn.prepareStatement(sql);
		rs = stmt.executeQuery(sql);
		if (rs.next()) {
			String username = rs.getString("username");
			double cash = rs.getDouble("cash");
			int currency = rs.getInt("currency");

			user = new User(id, username, cash, currency);
		}
		rs.close();
		stmt.close();

		return user;
	}

	public void updatePassword(int id, String password) {
		try {
			database.connect();
			conn = database.getConnection();
			ResultSet rs = null;
			PreparedStatement pst = null;

			pst = conn.prepareStatement("UPDATE users SET password = MD5(?) WHERE id = ?");
			pst.setString(1, password);
			pst.setInt(2, id);
			pst.executeUpdate();

			System.out.println("Successfully updated password!");
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void updateCurrency(int id, int currency) {
		try {
			database.connect();
			conn = database.getConnection();
			ResultSet rs = null;
			PreparedStatement pst = null;

			pst = conn.prepareStatement("UPDATE users SET currency = ? WHERE id = ?");
			pst.setInt(1, currency);
			pst.setInt(2, id);
			pst.executeUpdate();

			System.out.println("Successfully updated currency!");
			pst.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
