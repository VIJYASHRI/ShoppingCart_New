package com.niit.service;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerService {
	public void saveCustomer(Customer customer);
	public Customer getCustomerByUserName(String username);
	/*public List<Customer> getAllCustomer();
	public Customer getCustomerById(int id);
	public void deleteCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void saveCustomer(String username);*/
	//public List<Customer> getAllCustomer();
}
