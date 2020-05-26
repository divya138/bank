package com.hcl.savingaccount.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.savingaccount.dto.AccountDto;
import com.hcl.savingaccount.dto.CustomerDto;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;
import com.hcl.savingaccount.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	private AccountDto accountdto=new AccountDto();
	@PostMapping("/registration")
	public ResponseEntity<Object> registration(@RequestBody CustomerDto customerdto){
		accountdto=customerService.registration(customerdto);
		return new ResponseEntity<>(accountdto, HttpStatus.OK);
		
	}
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody Customer customer){
	 Object o1=customerService.login(customer);
	 return new ResponseEntity<Object>(o1, HttpStatus.OK);
	 
	}
	@GetMapping("/customer/{aadhar}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable String aadhar){
		Customer customer=customerService.findCustomerByAadhar(aadhar);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
		
	}
	@PostMapping("/customer")
	public ResponseEntity<Long> getCustomerById(@RequestBody Account account){
	Customer customer=customerService.getAccountByCustomerId(account);
		return new ResponseEntity<Long>(customer.getCustomerId(), HttpStatus.OK);
		
	}
	
	
	
	

}
