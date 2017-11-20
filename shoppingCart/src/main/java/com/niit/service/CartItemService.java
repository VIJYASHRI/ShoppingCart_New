package com.niit.service;

import java.util.List;

import com.niit.model.Cart;
import com.niit.model.CartItem;

public interface CartItemService  {
	public CartItem getCartItem(int cartItemId);
	public void saveCartItem(CartItem cartItem);
	List<CartItem> getAllItemsByCartId(int cart_id);
	public void removeAllCartItems(Cart cart);
	public void removeCartItem(CartItem cartItem);
}
