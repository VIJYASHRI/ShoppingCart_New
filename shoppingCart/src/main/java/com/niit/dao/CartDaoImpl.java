package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.model.Cart;
import com.niit.model.Product;

@Repository
public class CartDaoImpl implements CartDao {

	

		@Autowired 
		private SessionFactory sessionFactory;
		
		public CartDaoImpl(){
			System.out.println("Cart DaoImpl created");	
				
		}
		
		public Cart getCart(int cartid) {
			return sessionFactory.getCurrentSession().get(Cart.class, cartid);
				
	}

		
}