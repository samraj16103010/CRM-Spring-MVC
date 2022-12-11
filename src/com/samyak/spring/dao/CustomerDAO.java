package com.samyak.spring.dao;

import java.util.List;

import com.samyak.spring.entity.Customer;

public interface CustomerDAO {
	public List<Customer>getCustomers();

	public void addCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
}
