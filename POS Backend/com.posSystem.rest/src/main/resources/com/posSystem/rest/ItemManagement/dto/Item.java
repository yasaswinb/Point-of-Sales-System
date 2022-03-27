package com.posSystem.rest.ItemManagement.dto;

public class Item {
	private int id;
	private String itemName;
	private int categoryId;
	private double price;
	private int quantity;
	
	public Item(String itemName, int categoryId, double price, int quantity) {
		super();
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Item(int id,String itemName, int categoryId, double price, int quantity) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.categoryId = categoryId;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", categoryId=" + categoryId + ", price=" + price + ", quantity="
				+ quantity + "]";
	}
	
	
	
	
}
