package models.transactions;

import java.util.Date;

public class Transaction {
	private int id;
	private int user_id;
	private String category;
	private String purpose;
	private double sum;
	private Date date;
	
	public Transaction(String category, String purpose, double sum, Date date) {
		this.category = category;
		this.purpose = purpose;
		this.sum = sum;
		this.date = date;
	}	
	
	public Transaction(int user_id, String category, String purpose, double sum, Date date) {
		this.user_id = user_id;
		this.category = category;
		this.purpose = purpose;
		this.sum = sum;
		this.date = date;
	}	
	
	public Transaction(int id, int user_id, String category, String purpose, double sum, Date date) {
		this.id = id;
		this.user_id = user_id;
		this.category = category;
		this.purpose = purpose;
		this.sum = sum;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {		
		return this.purpose + " " + this.sum + " " + this.category + " " + this.date  + " " + this.user_id;
	}
	
	
}
