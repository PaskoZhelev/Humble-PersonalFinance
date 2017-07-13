package models.users;

public class User {
	private int id;
	private String username;
	private String password;
	private double cash;
	private int currency;
	
	public User(String username, String password) {		
		this.username = username;
		this.password = password;
	}
	
	public User(int id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, double cash, int currency) {
		this.username = username;
		this.password = password;
		this.cash = cash;
		this.currency = currency;
	}
	
	public User(int id, String username, double cash, int currency) {
		this.id = id;
		this.username = username;
		this.cash = cash;
		this.currency = currency;
	}
	
	public User(int id, String username, String password, double cash, int currency) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.cash = cash;
		this.currency = currency;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {		
		return "Student: " + username + ", ID: " + id;
	}
	
	
}
