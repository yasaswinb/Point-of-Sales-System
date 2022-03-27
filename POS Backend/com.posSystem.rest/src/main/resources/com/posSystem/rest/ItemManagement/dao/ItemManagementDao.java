package com.posSystem.rest.ItemManagement.dao;

import java.util.List;

import com.posSystem.rest.ItemManagement.dto.Item;

public interface ItemManagementDao {
	public int createItem(String itemName, int categoryId, double price, int quantity) throws Exception;
	public int editItem(int id, String itemName, int categoryId, double price, int quantity) throws Exception;
	public int deleteItem(int id) throws Exception;
	public Item getItemById(String id) throws Exception;
	public List<Item> getAllItems() throws Exception;
	public List<Item> getAllItemForTypeId(String categoryId) throws Exception;
}
