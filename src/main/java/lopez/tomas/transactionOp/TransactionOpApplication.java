package lopez.tomas.transactionOp;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lopez.tomas.transactionOp.service.TransactionService;
import lopez.tomas.transactionOp.service.transaction.ArgumentsIn;
import lopez.tomas.transactionOp.service.transaction.OperationsEnum;

/**
 * Class that contains the entry point for the program.
 * 
 * @author Tomas Lopez
 *
 */
@SpringBootApplication
public class TransactionOpApplication {

	public static void main(String[] args) {
		SpringApplication app =  new SpringApplication(TransactionOpApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
	
	/**
	 * Bean that will be charge when the program starts and provides the
	 * functionality for the execution through the command line.
	 * 
	 * @param transactionService
	 *            Provider for the business operations about transactions.
	 * 
	 */
	@Bean
    CommandLineRunner init(TransactionService transactionService) {

        return args -> {

        	if (args.length < 2) {
        		System.out.println("WRONG ARGUMENTS");
        		return;
        	} else {
        		//Verify user ID as integer.
        		try {
        			Integer.parseInt(args[0]);
        		} catch (NumberFormatException ne) {
        			System.out.println("WRONG USER");
        			return;
        		}
        		
        		//Build the arguments object.
        		ArgumentsIn data = new ArgumentsIn();
        		data.setUserId(Integer.parseInt(args[0]));
        		if ("ADD".equals(args[1].toUpperCase())) {
        			data.setOp(OperationsEnum.ADD);
        			//Read the transaction json
        			StringBuilder jsonB = new StringBuilder();
        			for(int i = 2; i<args.length; i++) { //If the string has white spaces it separates the arguments.
        				jsonB.append(args[i]+" ");
        			}
        			data.setJson(jsonB.toString());
        		} else if ("LIST".equals(args[1].toUpperCase())) {
        			data.setOp(OperationsEnum.LIST);
        		} else if ("SUM".equals(args[1].toUpperCase())) {
        			data.setOp(OperationsEnum.SUM);
        		} else {
        			data.setOp(OperationsEnum.SHOW);
        			data.setJson(args[1]);
        		}
        		
        		//Executes the operation.
        		String result = transactionService.doOp(data);
        		System.out.println(result);
        	}
        };
	}
}
