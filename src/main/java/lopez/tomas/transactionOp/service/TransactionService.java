package lopez.tomas.transactionOp.service;

import lopez.tomas.transactionOp.service.transaction.ArgumentsIn;

/**
 * Interface that exposes the operations provided by the transactions API.
 * 
 * @author Tomas Lopez
 *
 */
public interface TransactionService {
	/**
	 * Do a transaction operation indicated through the information received.
	 * 
	 * @param args
	 *            {@code ArgumentsIn} containing the information necessary to do a
	 *            transaction operation.
	 * 
	 * @return The operation result.
	 */
	public String doOp(ArgumentsIn args);
	
	/**
	 * Register a transaction with the user received.
	 * 
	 * @param userId
	 *            User identifier.
	 * @param json
	 *            JSON with the transaction information.
	 * 
	 * @return Json registered in the DB.
	 */
	public String add(int userId, String json);
	
	/**
	 * Return the transaction json that corresponds to the transaction id received.
	 * 
	 * @param userId
	 *            User identifier.
	 * @param txId
	 *            Transaction identifier.
	 * 
	 * @return Transaction Json.
	 */
	public String show(int userId, String txId);
	
	/**
	 * Lists in an array all the transactions that corresponds an user in its json
	 * form.
	 * 
	 * @param userId
	 *            User identifier.
	 * 
	 * @return Json array with the user trasanctions.
	 */
	public String list(int userId);
	
	/**
	 * Returns a json that contains the total amount that an user has registered in
	 * all his transactions.
	 * 
	 * @param userId
	 *            User identifier.
	 * 
	 * @return A json containing the user identifier and the sum of his transactions
	 *         amounts.
	 */
	public String sum(int userId);
}
