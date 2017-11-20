package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartItemController {
	@Autowired
	private ProductService productservice;
	@Autowired
	private CartItemService cartitemservice;
	@Autowired
	private CartService cartservice;
	@Autowired
	private CustomerService customerservice;
	

	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping("/addCartItem/{id}")
	public void addCartItem(@PathVariable(value = "id") int id) {
		User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username=user.getUsername();
		
		Customer customer=customerservice.getCustomerByUserName(username);//from Users where username=?
		Cart cart=customer.getCart();
		System.out.println("NULLP"+username);
		List<CartItem> cartItems= cart.getCartItem();
		
		Product  product = productservice.getProductById(id);
		
		for (int i = 0; i <cartItems.size(); i++) {
			CartItem cartItem=cartItems.get(i);
			Product p=cartItem.getProduct();
			     //1    ==  1
			if(p.getId()==id){
				cartItem.setQuantity(cartItem.getQuantity() + 1);//increment the quantity
				cartItem.setTotalPrice(cartItem.getQuantity() * p.getPrice()); //update the total price
				cartitemservice.saveCartItem(cartItem);//update the quantity in the cartitem
				return ;
			}	
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
		cartItem.setProduct(product); //set product id
		cartItem.setCart(cart);//set cart id
		cartitemservice.saveCartItem(cartItem); //insert query	
	
	}
	/*@RequestMapping(value="/addCartItem/{id}", method = RequestMethod.GET)
	public void saveCartItem(@PathVariable(value = "id") int productId) {
		
		System.out.println("My User:"+ principal.getName());
		String username=principal.getName();
		String username =user.getUsername();
		Customer customer=customerservice.getCustomerByUserName(username);            //from Users where username=?
		Cart cart=customer.getCart();
		System.out.println("NULLP"+username);
		List<CartItem> cartItems= cart.getCartItem();
		
		Product  product = productservice.getProductById(id);
		
		for (int i = 0; i <cartItems.size(); i++) {
			CartItem cartItem=cartItems.get(i);
			Product p=cartItem.getProduct();
			     //1    ==  1
			if(p.getId()==id){
				cartItem.setQuantity(cartItem.getQuantity() + 1);//increment the quantity
				cartItem.setTotalPrice(cartItem.getQuantity() * p.getPrice()); //update the total price
				cartitemservice.saveCartItem(cartItem);//update the quantity in the cartitem
				return;
			}	
		}
		
		CartItem cartItem=new CartItem();
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
		cartItem.setProduct(product); //set product id
		cartItem.setCart(cart);//set cart id
		cartitemservice.saveCartItem(cartItem); //insert query	
	
	}*/
	
	  @RequestMapping("/removeCartItem/{cartItemId}")	  
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	public void removeCartItem(@PathVariable int cartItemId){
	CartItem cartItem=cartitemservice.getCartItem(cartItemId);
	cartitemservice.removeCartItem(cartItem); }
	 
	 @RequestMapping("/removeAllCartItems/{cartId}")
	 
	 @ResponseStatus(value=HttpStatus.NO_CONTENT) 
	 public void removeAllCartItems(@PathVariable int cartId){ 
	 Cart cart=cartservice.getCart(cartId);
	 cartitemservice.removeAllCartItems(cart); }
	 

}