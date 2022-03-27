package com.posSystem.rest.ItemManagement.controller;

import javax.ws.rs.core.Response;


public interface ItemTypeManagementController {
//	public String addItemType(String itemType);
	public Response addItemType(String itemType);
//	public String getAllItemsType();
	public Response getAllItemsType();
	public String getItemTypeById(String id);
}
