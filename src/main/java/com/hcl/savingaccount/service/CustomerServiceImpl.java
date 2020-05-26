package com.hcl.savingaccount.service;

import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hcl.savingaccount.dao.CustomerRepository;
import com.hcl.savingaccount.dto.AccountDto;
import com.hcl.savingaccount.dto.CustomerDto;
import com.hcl.savingaccount.exception.CustomerNotFoundException;
import com.hcl.savingaccount.exception.InvalidNameException;
import com.hcl.savingaccount.model.Account;
import com.hcl.savingaccount.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	private Random random = new Random();
	private Customer customer = new Customer();
	 private AccountDto accountdto=new AccountDto();
	@Override
	public AccountDto registration(CustomerDto customerDto) {
		BeanUtils.copyProperties(customerDto, customer);
		int leftLimit = 97;
		int rightLimit = 122;
		int targetStringLength = 10;
		String returnString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	customer=customerRepository.saveAndFlush(customer);
		customer.setPassword(returnString);

		BeanUtils.copyProperties(customer, accountdto);
		return accountdto;
	}

	@Override
	public Customer updateCustomerDetails(Customer customer) {
		if ((customer.getFirstName() != null) && (customer.getFirstName().chars().allMatch(Character::isLetter))) {
			return customerRepository.saveAndFlush(customer);
		}
		throw new InvalidNameException();
	}

	@Override
	public Customer findCustomerByAadhar(String aadhar) {

		return customerRepository.findByAadhar(aadhar);
	}

	@Override
	public Customer getAccountByCustomerId(Account account) {

		return customerRepository.getCustomerByAccount(account);
	}

	@Override
	public Object login(Customer customer) {
		Customer customer1 = customerRepository.getOne(customer.getCustomerId());
		if ((customer1.getCustomerId() == customer.getCustomerId())
				&& (customer1.getPassword().equals(customer.getPassword()))) {
			return "Login Successfully";

		}
		throw new CustomerNotFoundException();
	}

}
