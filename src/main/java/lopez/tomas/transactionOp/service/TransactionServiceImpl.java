package lopez.tomas.transactionOp.service;

import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lopez.tomas.transactionOp.domain.Transaction;
import lopez.tomas.transactionOp.repository.TransactionRepository;
import lopez.tomas.transactionOp.service.transaction.ArgumentsIn;

/**
 * Implementation of the interface {@code TransactionService} that uses the
 * spring-data for do its operations with MongoDB.
 * 
 * @see lopez.tomas.transactionOp.service.TransactionService
 * 
 * @author Tomas Lopez
 *
 */
@Service
public class TransactionServiceImpl implements TransactionService {
	/** Provider of business services for transaction operations. */
	@Autowired
	TransactionRepository transactionRepository;

	@Override
	public String doOp(ArgumentsIn args) {
		String result = "";
		switch (args.getOp()) {
		case ADD:
			result = this.add(args.getUserId(), args.getJson());
			break;
		case SHOW:
			result = this.show(args.getUserId(), args.getJson());
			break;
		case LIST:
			result = this.list(args.getUserId());
			break;
		case SUM:
			result = this.sum(args.getUserId());
			break;
		default:
			result = "The operation is not recognized.";
			break;
		}
		return result;
	}

	@Override
	public String add(int userId, String json) {
		Transaction tx = new Transaction();
		try {
			JsonReader jsonReader = Json.createReader(new StringReader(json));
			JsonObject jsonObject = jsonReader.readObject();
			jsonReader.close();

			tx.setAmount(Float.parseFloat(jsonObject.getJsonNumber("amount").toString()));
			tx.setDescription(jsonObject.getString("description"));
			tx.setDate(jsonObject.getString("date"));
			tx.setUserId(userId);
		} catch (Exception e) {
			return "JSON FORMAT ERROR";
		}
		try {
			transactionRepository.save(tx);
		} catch (Exception e) {
			return "DB ERROR";
		}

		return tx.toString();
	}

	@Override
	public String show(int userId, String txId) {
		String toReturn = "Transaction not found.";
		Transaction tx = null;
		try {
			tx = transactionRepository.findByTransactionId(txId);
		} catch (Exception e) {
			return "DB ERROR";
		}

		if (tx != null) {
			if (userId != tx.getUserId()) {
				toReturn = "Transaction not found in this user.";
			} else {
				toReturn = tx.toString();
			}
		}

		return toReturn;
	}

	@Override
	public String list(int userId) {
		List<Transaction> txs = new ArrayList<Transaction>();
		try {
			txs =transactionRepository.findByUserId(userId);
		} catch (Exception e) {
			return "DB ERROR";
		}
		
		txs.sort((t1, t2) -> {
			LocalDate date1 = LocalDate.parse(t1.getDate());
			LocalDate date2 = LocalDate.parse(t2.getDate());
			return date2.compareTo(date1);
		});

		StringBuilder sb = new StringBuilder("[\n");
		txs.forEach(transaction -> sb.append(transaction.toString() + "\n"));
		sb.append("]");

		return sb.toString();
	}

	@Override
	public String sum(int userId) {
		float sum = 0;
		List<Transaction> txs = new ArrayList<Transaction>();
		
		try {
			txs = transactionRepository.findByUserId(userId);
		} catch (Exception e) {
			return "DB ERROR";
		}
		
		for (Transaction tx : txs) {
			sum = sum + tx.getAmount();
		}

		return "{\"user_id\":" + userId + ", \"sum\":" + sum + "}";
	}

}
