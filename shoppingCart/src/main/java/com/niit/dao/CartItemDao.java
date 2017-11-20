package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemDao {
	public void saveCartItem(CartItem cartItem);

	public CartItem getCartItem(int cartItemId);
	List<CartItem> getAllItemsByCartId(int cart_id);
	public void removeAllCartItems(Cart cart);

	public void removeCartItem(CartItem cartItem);

}