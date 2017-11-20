package com.niit.dao;

import java.util.List;



import org.apache.log4j.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Authorities;
import com.niit.model.Cart;
import com.niit.model.Customer;
import com.niit.model.Users;

@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	private SessionFactory sessionFactory;
	Logger logger = Logger.getLogger(CustomerDaoImpl.class);

	public CustomerDaoImpl(SessionFactory sessionFactory) {
		//super();
		this.sessionFactory = sessionFactory;
	}

	public void saveCustomer(Customer customer) {
		//sessionFactory.openSession().save(customer);

		//customer.getUsers().setEnabled(true);
		String username = customer.getUsers().getUsername(); // Assignment
		String role = "ROLE_USER";
		
		Authorities authorities = new Authorities(); // set the values
		authorities.setUsername(username);
		authorities.setRole(role);
		sessionFactory.getCurrentSession().save(authorities);

		/*Cart cart = new Cart();
		customer.setCart(cart);
		cart.setCustomer(customer);*/
		System.out.println(customer.getUsers().isEnabled());
		sessionFactory.getCurrentSession().save(customer);
		logger.debug("==============================");

	}

	
	/*@SuppressWarnings("deprecation")
	public Customer getCustomerById(int user_id) {

		Session session = sessionFactory.openSession();
  
		Query query = sessionFactory.getCurrentSession().createSQLQuery("select * from Customer where user_id='" + user_id + "'");

		return (Customer)query.uniqueResult();

	}

public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	public void deleteCustomer(Customer customer) {
		sessionFactory.getCurrentSession().delete(customer);

	}
*/
	public List<Customer> getAllCustomer() {
		return (List<Customer>) sessionFactory.getCurrentSession().createQuery("from Customer").list();
	}

	@Override
	public Customer getCustomerByUserName(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Users where username='"+username+"'");
		
		Users users=(Users)query.uniqueResult();
		Customer customer=users.getCustomer();
		return customer; //sessionFactory.getCurrentSession().get(Customer.class, username);
	}

}
