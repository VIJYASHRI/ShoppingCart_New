package com.niit.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.dao.CartDao;
import com.niit.model.Product;
@Transactional
@Repository(value="cartDao")
public class CartDaoImpl implements CartDao {

		@Autowired 
		private SessionFactory sessionFactory;
		public CartDaoImpl(){
			System.out.println("Cart DaoImpl created");	
				
		}
		
	/*	public void addCart(Cart cart) {
			sessionFactory.getCurrentSession().save(cart);
			
		}
		
		public void updateCart(Cart cart) {
			sessionFactory.getCurrentSession().update(cart);
		}

		public boolean deleteCart(Cart cart) {
			try{
				sessionFactory.getCurrentSession().delete(cart);
			} catch(HibernateException e){
				e.printStackTrace();
				return false;
			}
			
			return true;
		}

		
		@SuppressWarnings("unchecked")
		public List<Cart> getCartItems(int customer_id) {
			return (List<Cart>) sessionFactory.getCurrentSession().createQuery("from Customer where customer_id=" + customer_id).list();
		}*/

		public Cart getCart(int cartId) {
			Session session=sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class, cartId);
			session.close();
			return cart;
		}
}
