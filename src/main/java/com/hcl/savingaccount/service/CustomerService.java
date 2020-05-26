package com.hcl.savingaccount.service;

import com.hcl.savingaccount.dto.AccountDto;
import com.hcl.savingaccount.dto.CustomerDto;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;

public interface CustomerService {
	
	public AccountDto registration(CustomerDto customerDto);
	public Customer updateCustomerDetails(Customer customer);
	public Customer findCustomerByAadhar(String aadhar);
	public Customer getAccountByCustomerId(Account account);
	public Object login(Customer customer);
	

}
