package com.samyak.spring.service;

import java.util.List;

import com.samyak.spring.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
}
