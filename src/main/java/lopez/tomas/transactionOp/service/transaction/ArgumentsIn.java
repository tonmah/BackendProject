package lopez.tomas.transactionOp.service.transaction;

/**
 * Pojo that represents the info that a user introduces to do a certain
 * operation with the transaction api.
 * 
 * @author Tomas Lopez
 *
 */
public class ArgumentsIn {
	/** User identifier. */
	private int userId;
	/** Operation selected. */
	private OperationsEnum op;
	/** Data to operate (it can be a json or an idTransaction). */
	private String json;
	
	/* GETTERS & SETTERS */
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public OperationsEnum getOp() {
		return op;
	}
	public void setOp(OperationsEnum op) {
		this.op = op;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
}
