package net.tsg.microservices.customer.api;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.tsg.microservices.customer.intercomm.AccountClient;
import net.tsg.microservices.customer.model.Account;
import net.tsg.microservices.customer.model.Customer;
import net.tsg.microservices.customer.model.CustomerType;

@RestController
public class Api {
	
	@Autowired
	private AccountClient accountClient;
	
	protected Logger logger = Logger.getLogger(Api.class.getName());
	
	private List<Customer> customers;
	
	public Api() {
		customers = new ArrayList<>();
		customers.add(new Customer(1, "11111", "Deccan Herald", CustomerType.INDIVIDUAL));
		customers.add(new Customer(2, "33333", "Daily Herald", CustomerType.INDIVIDUAL));
		customers.add(new Customer(3, "55555", "Washington Post", CustomerType.INDIVIDUAL));
		customers.add(new Customer(4, "77777", "Newyork Times", CustomerType.INDIVIDUAL));
		customers.add(new Customer(5, "99999", "Guru Times", CustomerType.INDIVIDUAL));
	}
	
	@RequestMapping("/customers/taxid/{taxid}")
	public Customer findByPesel(@PathVariable("taxid") String taxid) {
		logger.info(String.format("Customer.findByTaxid(%s)", taxid));
		return customers.stream().filter(it -> it.getTaxid().equals(taxid)).findFirst().get();	
	}
	
	@RequestMapping("/customers")
	public List<Customer> findAll() {
		logger.info("Customer.findAll()");
		return customers;
	}
	
	@RequestMapping("/customers/{id}")
	public Customer findById(@PathVariable("id") Integer id) {
		logger.info(String.format("Customer.findById(%s)", id));
		Customer customer = customers.stream().filter(it -> it.getId().intValue()==id.intValue()).findFirst().get();
		List<Account> accounts =  accountClient.getAccounts(id);
		customer.setAccounts(accounts);
		return customer;
	}
	
}
