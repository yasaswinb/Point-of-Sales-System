package com.posSystem.rest.ItemManagement.dto;

public class Category {
	private int id;
	private String itemType;

	public Category(String itemType) {
		super();
		this.itemType = itemType;
	}

	public Category(int id, String itemType) {
		super();
		this.id = id;
		this.itemType = itemType;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Categories [itemType=" + itemType + "]";
	}
}
