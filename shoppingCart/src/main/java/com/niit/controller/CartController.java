package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Customer;
import com.niit.service.CartItemService;
import com.niit.service.CartService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private CustomerService customerservice;
	@Autowired
	private CartService cartservice;
	@Autowired
	private CartItemService cartitemservice;
	@Autowired
	private ProductService productservice;
	
	@RequestMapping("/getCartId")
	public String getCartId(Model model, HttpSession session) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		//System.out.println("uname:"+user.getUsername());
		String username = user.getUsername();
		Customer customer = customerservice.getCustomerByUserName(username);
		Cart cart = customer.getCart();
		int cartId = cart.getCart_id();                        //getCart_id();
		List<CartItem> cartList=(List<CartItem>)cartitemservice.getCartItem(cartId);
		session.setAttribute("cartCount", cartList.size());
		double grandTotal=0.0;
		for(CartItem item: cartList){
		grandTotal+=item.getTotalPrice();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("grandTotal", grandTotal);
		return "cart";
	}
	/*@RequestMapping("/getCartId")
	public String getCartId(Model model, HttpSession session) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		Customer customer = customerservice.getCustomerByUsername(username);
		Cart cart = customer.getCart();
		int cartId = cart.getId();
		List<CartItem> cartList=(List<CartItem>)cartitemservice.getAllitemsByCartId(cartId);
		session.setAttribute("cartCount", cartList.size());
		double grandTotal=0.0;
		for(CartItem item: cartList){
		grandTotal+=item.getTotalPrice();
		}
		
		model.addAttribute("cartList", cartList);
		model.addAttribute("grandTotal", grandTotal);
		return "cart";*/
	@RequestMapping(value="/removeFromCart/{id}")
	public String removeItem(@PathVariable("id") int id)
	{
		CartItem deletedItem=cartitemservice.getCartItem(id);
		cartitemservice.removeCartItem(deletedItem);
		return "redirect:/getCartId";
	}
	@RequestMapping(value="/clearCart")
	public String clearMyCart()
	{
		User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		System.out.println("uname:"+user.getUsername());
		String username=user.getUsername();
		Customer customer=customerservice.getCustomerByUserName(username);
		Cart cart=customer.getCart();
		cartitemservice.removeAllCartItems(cart);
		return "redirect:/getCartId";
	}
@RequestMapping(value="/increaseQuantity/{id}")
public String increaseQuantity(@PathVariable("id") int id)
{
	CartItem item=cartitemservice.getCartItem(id);
	int qty=item.getProduct().getQuantity();
	if(qty>0){
		item.setQuantity(item.getQuantity()+1);
		item.setTotalPrice(item.getProduct().getPrice()*item.getQuantity());
		item.getProduct().setQuantity(qty-1);
		cartitemservice.saveCartItem(item);
		productservice.updateProduct(item.getProduct());
	}
	return "redirect:/getCartId";
}
@RequestMapping(value="/decreaseQuantity/{id}")
public String decreaseQuantity(@PathVariable("id") int id)
{
	CartItem item=cartitemservice.getCartItem(id);
	int qty=item.getProduct().getQuantity();
	if(qty>0){
		item.setQuantity(item.getQuantity()-1);
		item.setTotalPrice(item.getProduct().getPrice()*item.getQuantity());
		item.getProduct().setQuantity(qty+1);
		cartitemservice.saveCartItem(item);
		productservice.updateProduct(item.getProduct());
	}
	return "redirect:/getCartId";
}
	@RequestMapping("/getCart")
	public Cart getCart(@PathVariable int cartId) {
		Cart cart = cartservice.getCart(cartId);
		return cart;
	}
@RequestMapping("/cart")
	public String cart(){
		return "cart";
	}
}