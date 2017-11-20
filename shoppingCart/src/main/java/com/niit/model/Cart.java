package com.niit.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

import javassist.SerialVersionUID;

@Entity
@Component
@Table(name="cart")
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUid=1L;
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	int cart_id;
	@Column
	@Min(0)
	int quantity;
	double grandTotal;
	boolean flag=false;
	
	@OneToOne(optional=false)
	private Customer customer;
	
	
	@OneToMany(mappedBy="cart", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<CartItem> cartItem;
	
	public List<CartItem> getCartItem() {
		return cartItem;
	}
	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
