package com.cognizant.truyum.model;

import java.sql.Date;
import java.util.List;

public class Cart {

	private List<Item> menuItemList;
	private double total;
	private Date dateOfPurchase;

	// Constructors
	public Cart(List<Item> menuItemList, double total, Date date) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
		this.dateOfPurchase = date;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}



	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}



	// Getters and Setters
	public List<Item> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<Item> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cart[" +menuItemList+" "+total +"]";
	}

}
