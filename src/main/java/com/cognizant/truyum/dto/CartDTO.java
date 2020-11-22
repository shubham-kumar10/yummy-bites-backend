package com.cognizant.truyum.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Item;

public class CartDTO {

	private List<Item> cartItems = new ArrayList<Item>();
	private Date dateOfPurchase;
	private double total;

	public CartDTO() {
		super();
	}
	
	public CartDTO(List<Item> cartItems, double total,Date date) {
		super();
		this.cartItems = cartItems;
		this.total = total;
		this.dateOfPurchase = date;
	}

	public List<Item> getCartItems() {
		return cartItems;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public void setCartItems(List<Item> cartItems) {
		this.cartItems = cartItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		if (cartItems == null) {
			if (other.cartItems != null)
				return false;
		} else if (!cartItems.equals(other.cartItems))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}
}
