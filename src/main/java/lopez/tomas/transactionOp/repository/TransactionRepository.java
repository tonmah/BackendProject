package lopez.tomas.transactionOp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import lopez.tomas.transactionOp.domain.Transaction;

/**
 * Spring Data repository that provides the CRUD operations for transactions.
 * 
 * @author Tomas Lopez
 *
 */
public interface TransactionRepository extends MongoRepository<Transaction, String> {
	/**
	 * Returns the info about a transaction.
	 * 
	 * @param transactionId
	 *            Transaction Identifier
	 * 
	 * @return Domain object with the info about the transaction.
	 */
	public Transaction findByTransactionId(String transactionId);
	
	/**
	 * Returns the transactions that a certain user has done.
	 * 
	 * @param userId
	 *            User Identifier.
	 * 
	 * @return {@code List} with the Domain object that represents the user
	 *         transactions.
	 */
	public List<Transaction> findByUserId(int userId);
}
