package com.niit.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.model.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public CartItem getCartItem(int cartItemId) {
		Session session=sessionFactory.openSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.flush();
		session.close();
		return cartItem;
		}

		public void removeCartItem(CartItem deletedItem) {
		Session session=sessionFactory.openSession();
		session.delete(deletedItem);
		session.flush();
		session.close();

		}

	@Override
	public void removeAllCartItems(Cart cart) {
		
		List<CartItem> cartItems=cart.getCartItem();
		//JDK 1.5 feature - for each loop
		for(CartItem cartItem:cartItems){
		removeCartItem(cartItem);
		}
	}
	

	@Override
	public void saveCartItem(CartItem cartItem) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cartItem);
		session.flush();
		session.close();
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CartItem> getAllItemsByCartId(int cart_id) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where cart_id='"+cart_id+"'");
		List<CartItem> list=(List<CartItem>)query.list();
		return list;
	}

}
	/*private CartItem cartItem;
	Logger logger=Logger.getLogger(CartItemDaoImpl.class);
	public CartItemDaoImpl(SessionFactory sessionFactory){
		super();
		this.sessionFactory=sessionFactory;
	}
	public void saveCartItem(CartItem cartItem) {
		logger.debug("==============");
		sessionFactory.getCurrentSession().saveOrUpdate(cartItem);
	}
	public void updateCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().update(cartItem);
	}
		
	public CartItem getCartItem(int cartItemId) {
		
		return sessionFactory.getCurrentSession().get(CartItem.class, cartItemId);
	}
	public void removeCartItem(CartItem cartItem) {
		sessionFactory.getCurrentSession().delete(cartItem);
	}

	public void removeAllCartItems(Cart cart) {
		List<CartItem> cartItems= cart.getCartItem();
		for(CartItem cartItem:cartItems){
			removeCartItem(cartItem);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<CartItem> getAllItemsByCartId(int cart_id) {
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from CartItem where cart_id='"+cart_id+"'");
		List<CartItem> list=(List<CartItem>)query.list();
				return list;
	}
	
	*/

