package com.posSystem.rest.ItemManagement.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.posSystem.rest.ItemManagement.dao.ItemTypeManagementDaoImple;
import com.posSystem.rest.ItemManagement.dto.Category;

@Path("/itemType")
public class ItemTypeManagementControllerImpl implements ItemTypeManagementController {

//	@POST
//	@Path("/createItemType")
//	@Consumes("application/json")
//	@Produces("application/json")
//	@Override
//	public String addItemType(String itemTyp) {
//		int result = 0;
//		
//		Gson gson = new Gson();
//
//		JSONObject json = new JSONObject(itemTyp);
//		System.out.println(json.toString());
//
//		String itemType = json.getString("itemType");
//
//		if (itemType.isEmpty()) {
//			result = -2;
//		}else {
//			ItemTypeManagementDaoImple dao = new ItemTypeManagementDaoImple();
//			try {
//				result = dao.createItemType(itemType);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		return gson.toJson(result);
//	}

	@POST
	@Path("/createItemType")
	@Consumes("application/json")
	@Produces("application/json")
	@Override
	public Response addItemType(String itemTyp) {
		int result = 0;

		Gson gson = new Gson();

		JSONObject json = new JSONObject(itemTyp);
		System.out.println(json.toString());

		String itemType = json.getString("itemType");

		if (itemType.isEmpty()) {
			result = -2;
		} else {
			ItemTypeManagementDaoImple dao = new ItemTypeManagementDaoImple();
			try {
				result = dao.createItemType(itemType);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		return gson.toJson(result);
		return Response.ok(gson.toJson(result)).header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD").entity("").build();
	}

//	@GET
//	@Path("/getAllItemTypes")
//	@Produces("application/json")
//	@Override
//	public String getAllItemsType() {
//		List<Category> categories = null;
//		ItemTypeManagementDaoImple dao = new ItemTypeManagementDaoImple();
//		try {
//			categories = dao.getAllItemTypes();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Gson gson = new Gson();
//		return (gson.toJson(categories));
//	}

	@GET
	@Path("/getAllItemTypes")
	@Produces("application/json")
	@Override
	public Response getAllItemsType() {
		List<Category> categories = null;
		ItemTypeManagementDaoImple dao = new ItemTypeManagementDaoImple();
		try {
			categories = dao.getAllItemTypes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
//		return (gson.toJson(categories));
		return Response.ok(gson.toJson(categories)).header("Access-Control-Allow-Origin", "*").build();
	}
	
//	@GET
//	@Path("/getItemById/{itemId}")
//	@Produces("application/json")
//	@Override
//	public String getItemById(@PathParam("itemId") String id) {
//		Item item = null;
//		ItemManagementDaoImpl dao = new ItemManagementDaoImpl();
//		try {
//			item = dao.getItemById(id);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//		Gson gson = new Gson();
//		return (gson.toJson(item));
//	}
	
	@GET
	@Path("/getItemTypeById/{itemTypeId}")
	@Produces("application/json")
	@Override
		public String getItemTypeById(@PathParam("itemTypeId") String id) {
		Category category = null;
		ItemTypeManagementDaoImple dao = new ItemTypeManagementDaoImple();
		try {
			category = dao.getItemTypeById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Gson gson = new Gson();
		return (gson.toJson(category));
		}
}
