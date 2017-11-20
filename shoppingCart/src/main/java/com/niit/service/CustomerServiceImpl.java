package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.niit.dao.CustomerDao;
import com.niit.model.Customer;
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public void saveCustomer(Customer customer){
	   customerDao.saveCustomer(customer);	
	}
	@Override
	public Customer getCustomerByUserName(String username) {
	
		return customerDao.getCustomerByUserName(username);
	}

	

}
