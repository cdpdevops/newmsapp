package net.tsg.microservices.customer.model;

import java.util.List;

public class Customer {

	private Integer id;
	private String taxid;
	private String name;
	private CustomerType type;
	private List<Account> accounts;

	public Customer() {
		
	}
	
	public Customer(Integer id, String taxid, String name, CustomerType type) {
		this.id = id;
		this.taxid = taxid;
		this.name = name;
		this.type = type;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaxid() {
		return taxid;
	}

	public void setTaxid(String taxid) {
		this.taxid = taxid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CustomerType getType() {
		return type;
	}

	public void setType(CustomerType type) {
		this.type = type;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
