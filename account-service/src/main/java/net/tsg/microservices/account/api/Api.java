package net.tsg.microservices.account.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tsg.microservices.account.model.Account;

@RestController
public class Api {

	private List<Account> accounts;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	public Api() {
		accounts = new ArrayList<>();
		accounts.add(new Account(101, 1, "AD12345"));
		accounts.add(new Account(102, 2, "AD77745"));
		accounts.add(new Account(103, 3, "AD88845"));
		accounts.add(new Account(104, 4, "AD99945"));
		accounts.add(new Account(105, 1, "AD00045"));
		accounts.add(new Account(106, 2, "AD20245"));
		accounts.add(new Account(107, 2, "AD92345"));
	}
	
	@RequestMapping("/accounts/{number}")
	public Account findByNumber(@PathVariable("number") String number) {
		logger.info(String.format("Account.findByNumber(%s)", number));
		return accounts.stream().filter(it -> it.getNumber().equals(number)).findFirst().get();
	}
	
	@RequestMapping("/accounts/customer/{customer}")
	public List<Account> findByCustomer(@PathVariable("customer") Integer customerId) {
		logger.info(String.format("Account.findByCustomer(%s)", customerId));
		return accounts.stream().filter(it -> it.getCustomerId().intValue()==customerId.intValue()).collect(Collectors.toList());
	}
	
	@RequestMapping("/accounts")
	public List<Account> findAll() {
		logger.info("Account.findAll()");
		return accounts;
	}
	
}
