package com.niit.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import com.niit.model.Cart;

public interface CartService {

	/*@PreAuthorize("hasRole('USER')")
	public void addCart(Cart cart);
	public void updateCart(Cart cart);
	public boolean deleteCart(Cart cart);
	public List<Cart> getCartItems(int customer_id);*/
	public Cart getCart(int cart_id);
}
