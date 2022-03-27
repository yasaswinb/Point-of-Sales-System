package com.posSystem.rest.ItemManagement.controller;

public interface ItemManagementController {
	public String addItem(String item);
	public String editItem(String item);
	public String getAllItems();
	public String deleteItem(int id);
	public String getItemById(String id);
	public String getAllItemsForCategoryId(String id);
}
