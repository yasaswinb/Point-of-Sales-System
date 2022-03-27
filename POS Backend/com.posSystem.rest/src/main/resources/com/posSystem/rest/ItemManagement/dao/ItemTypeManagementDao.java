package com.posSystem.rest.ItemManagement.dao;

import java.util.List;

import com.posSystem.rest.ItemManagement.dto.Category;

public interface ItemTypeManagementDao {
	public int createItemType(String itemType) throws Exception;
	public List<Category> getAllItemTypes() throws Exception;
	public Category getItemTypeById(String categoryId) throws Exception;
}
