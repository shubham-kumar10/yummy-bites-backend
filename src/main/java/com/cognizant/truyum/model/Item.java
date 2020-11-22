package com.cognizant.truyum.model;

public class Item {
	
	private MenuItem item;
	private int quantity;
	
	
	public Item() {
		super();
	}

	public Item(MenuItem item, int quantity) {
		super();
		this.item = item;
		this.quantity = quantity;
	}
	
	public MenuItem getItem() {
		return item;
	}
	public void setItem(MenuItem item) {
		this.item = item;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Item [item=" + item + ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
}
