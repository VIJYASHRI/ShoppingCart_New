package com.niit.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.CartItemDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;

@Service(value="cartItemService")
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemDao cartItemDao;
	
	public void saveCartItem(CartItem cartItem) {
	cartItemDao.saveCartItem(cartItem);
	}

	public CartItem getCartItem(int cartItemId) {
		return cartItemDao.getCartItem(cartItemId);
	}
	public void removeCartItem(CartItem cartItem) {
		cartItemDao.removeCartItem(cartItem);	
	}

	public void removeAllCartItems(Cart cart) {
	cartItemDao.removeAllCartItems(cart);
		
	}

	@Override
	public List<CartItem> getAllItemsByCartId(int cart_id) {
		
		return cartItemDao.getAllItemsByCartId(cart_id);
	}


}