package com.posSystem.rest.ItemManagement.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.posSystem.rest.ItemManagement.dao.ItemManagementDaoImpl;
import com.posSystem.rest.ItemManagement.dto.Item;

@Path("/item")
public class ItemManagementControllerImpl implements ItemManagementController {

	@POST
	@Path("/createItem")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public String addItem(String item) {
		int result = 0;
		int categoryId = 0;
		double price = 0;
		int quantity = 0;

		Gson gson = new Gson();

		JSONObject json = new JSONObject(item);
		System.out.println(json.toString());

		String itemName = json.getString("itemName");
		categoryId = json.getInt("categoryId");
		price = json.getDouble("price");
		quantity = json.getInt("quantity");

		if (itemName.isEmpty() || categoryId == 0 || price == 0 || quantity == 0) {
			result = -2;
		} else {
			ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
			try {
				result = dao.createItem(itemName, categoryId, price, quantity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gson.toJson(result);
	}

	@POST
	@Path("/editItem")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public String editItem(String item) {
		int id = 0;
		int result = 0;
		int categoryId = 0;
		double price = 0;
		int quantity = 0;

		Gson gson = new Gson();

		JSONObject json = new JSONObject(item);
		System.out.println(json.toString());
		id = json.getInt("id");
		String itemName = json.getString("itemName");
		categoryId = json.getInt("categoryId");
		price = json.getDouble("price");
		quantity = json.getInt("quantity");

		if (id == 0 || itemName.isEmpty() || categoryId == 0 || price == 0 || quantity == 0) {
			result = -2;
		} else {
			ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
			try {
				result = dao.editItem(id, itemName, categoryId, price, quantity);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return gson.toJson(result);
	}

	@GET
	@Path("/getAllItems")
	@Produces("application/json")
	@Override
	public String getAllItems() {
		List<Item> items = new ArrayList<Item>();
		ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
		try {
			items = dao.getAllItems();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		return (gson.toJson(items));
	}

	@DELETE
	@Path("/deleteItem/{itemId}")
	@Produces("application/json")
	@Override
	public String deleteItem(@PathParam("itemId") int id) {
		int result = 0;
		Gson gson = new Gson();

		ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
		try {
			result = dao.deleteItem(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gson.toJson(result);
	}
	
	@GET
	@Path("/getItemById/{itemId}")
	@Produces("application/json")
	@Override
	public String getItemById(@PathParam("itemId") String id) {
		Item item = null;
		ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
		try {
			item = dao.getItemById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		return (gson.toJson(item));
	}
	
	@GET
	@Path("/getAllItemsByCategoryId/{categoryId}")
	@Produces("application/json")
	@Override
	public String getAllItemsForCategoryId(@PathParam("categoryId") String id) {
		List<Item> items = new ArrayList<Item>();
		ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
		try {
			items = dao.getAllItemForTypeId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		return (gson.toJson(items));
	}
}
