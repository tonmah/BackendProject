package lopez.tomas.transactionOp.domain;

import org.springframework.data.annotation.Id;

/**
 * Domain object that represents a transaction info.
 * 
 * @author Tomas Lopez
 *
 */
public class Transaction {
	/** The transaction ID. */
	@Id
	public String transactionId;
	/** The transaction amount. */
	private float amount;
	/** The transaction description. */
	private String description;
	/** The transaction date. */
	private String date;
	/** The user ID. */
	private int userId;
	
	@Override
	public String toString() {
		return "{\"transaction_id\":\"" + transactionId + "\", \"amount\":" + amount + ", \"description\": \"" + description + "\", \"date\":\"" + date
				+ "\", \"user_id\":" + userId + "}";
	}

	/* GETTERS & SETTERS */
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
