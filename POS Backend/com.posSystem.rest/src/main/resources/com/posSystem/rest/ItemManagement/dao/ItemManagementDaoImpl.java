package com.posSystem.rest.ItemManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.posSystem.rest.ItemManagement.dto.Item;

public class ItemManagementDaoImpl implements ItemManagementDao {
	private Connection connect = null;
	private ResultSet resultSet = null;
	private Statement statement  = null;
	private PreparedStatement preparedStatement = null;
	
	public ItemManagementDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int createItem(String itemName, int categoryId, double price, int quantity) throws Exception {
		int result ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?"+"user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("insert into pointofsale.items values (default, ?, ?, ?, ?)");
			this.preparedStatement.setString(1, itemName);
			this.preparedStatement.setInt(2, categoryId);
			this.preparedStatement.setDouble(3, price);
			this.preparedStatement.setInt(4, quantity);
			result = this.preparedStatement.executeUpdate();
	
		}catch(Exception e) {
			throw e;
		}finally {
			close();
		}
		return result;
	}
	
	@Override
	public int editItem(int id, String itemName, int categoryId, double price, int quantity) throws Exception {
		int result ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?"+"user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("update pointofsale.items set itemName = ?, categoryId = ?, price = ?, quantity = ? where id = ?");
			this.preparedStatement.setString(1, itemName);
			this.preparedStatement.setInt(2, categoryId);
			this.preparedStatement.setDouble(3, price);
			this.preparedStatement.setInt(4, quantity);
			this.preparedStatement.setInt(5, id);
			result = this.preparedStatement.executeUpdate();
	
		}catch(Exception e) {
			throw e;
		}finally {
			close();
		}
		return result;
	}
	
	@Override
	public int deleteItem(int id) throws Exception {
		int result ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?"+"user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("delete from pointofsale.items where id = ?");
			this.preparedStatement.setInt(1, id);
			result = this.preparedStatement.executeUpdate();
	
		}catch(Exception e) {
			throw e;
		}finally {
			close();
		}
		return result;
	}
	
	@Override
	public List<Item> getAllItems() throws Exception {
		List<Item> items = new ArrayList<Item>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?" + "user=root&password=Test@123");
			this.statement = this.connect.createStatement();
			this.resultSet = this.statement.executeQuery("SELECT * from pointofsale.items");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("id");
				String itemName = resultSet.getString("itemName");
				int categoryId = resultSet.getInt("categoryId");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				Item item = new Item(id,itemName,categoryId, price,quantity);
				System.out.println(item.toString());
				items.add(item);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			close();
		}
		return items;
	}
	
	@Override
	public Item getItemById(String id) throws Exception {
		Item result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?" + "user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("select * from pointofsale.items where id=?");
	        this.preparedStatement.setString(1, id);
	        this.resultSet = this.preparedStatement.executeQuery();
			while(resultSet.next()) {
				int itemiId = resultSet.getInt("id");
				String itemName = resultSet.getString("itemName");
				int categoryId = resultSet.getInt("categoryId");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				Item item = new Item(itemiId,itemName,categoryId, price,quantity);
				System.out.println(item.toString());
				result=item;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			close();
		}
		return result;
	}
	
	@Override
	public List<Item> getAllItemForTypeId(String categoryId) throws Exception {
		List<Item> items = new ArrayList<Item>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?" + "user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("SELECT * from pointofsale.items where categoryId = ?");
	        this.preparedStatement.setString(1, categoryId);
	        this.resultSet = this.preparedStatement.executeQuery();
			while(resultSet.next()) {
				int itemiId = resultSet.getInt("id");
				String itemName = resultSet.getString("itemName");
				int catId = resultSet.getInt("categoryId");
				double price = resultSet.getDouble("price");
				int quantity = resultSet.getInt("quantity");
				Item item = new Item(itemiId,itemName,catId, price,quantity);
				System.out.println(item.toString());
				items.add(item);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			close();
		}
		return items;
	}

	
	// You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
}