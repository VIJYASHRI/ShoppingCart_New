package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartDao;
import com.niit.model.Cart;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;

	/*@Override
	public void addCart(Cart cart) {
		cartDao.addCart(cart);
	}

	@Override
	public void updateCart(Cart cart) {
	
		cartDao.updateCart(cart);
	}

	@Override
	public boolean deleteCart(Cart cart) {
		try {
			cartDao.deleteCart(cart);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Cart> getCartItems(int customer_id) {
		
		return (List<Cart>) cartDao.getCartItems(customer_id);
	}*/

	@Override
	public Cart getCart(int cart_id) {
		
		return cartDao.getCart(cart_id);
	}


	
}


