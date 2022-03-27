package com.posSystem.rest.ItemManagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.posSystem.rest.ItemManagement.dto.Category;

public class ItemTypeManagementDaoImple implements ItemTypeManagementDao {
	private Connection connect = null;
	private ResultSet resultSet = null;
	private Statement statement  = null;
	private PreparedStatement preparedStatement = null;
	
	public ItemTypeManagementDaoImple() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int createItemType(String itemType) throws Exception {
		int result ;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?"+"user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("insert into pointofsale.categories values (default, ?)");
			this.preparedStatement.setString(1, itemType);
			result = this.preparedStatement.executeUpdate();
	
		}catch(Exception e) {
			throw e;
		}finally {
			close();
		}
		return result;
	}
	
	@Override
	public List<Category> getAllItemTypes() throws Exception {
		List<Category> itemTypes = new ArrayList<Category>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?" + "user=root&password=Test@123");
			this.statement = this.connect.createStatement();
			this.resultSet = this.statement.executeQuery("SELECT * from pointofsale.categories");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("categoryId");
				String itemType = resultSet.getString("itemType");
				Category category = new Category(id, itemType);
				System.out.println(category.toString());
				itemTypes.add(category);
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			close();
		}
		return itemTypes;
	}
	
	@Override
	public Category getItemTypeById(String categoryId) throws Exception {
		Category result = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.connect = DriverManager.getConnection("jdbc:mysql://localhost/pointofsale?" + "user=root&password=Test@123");
			this.preparedStatement = this.connect.prepareStatement("select * from pointofsale.categories where categoryId=?");
	        this.preparedStatement.setString(1, categoryId);
	        this.resultSet = this.preparedStatement.executeQuery();
			while(resultSet.next()) {
				int id = resultSet.getInt("categoryId");
				String itemType = resultSet.getString("itemType");
				Category category = new Category(id, itemType);
				System.out.println(category.toString());
				System.out.println(category.toString());
				result=category;
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw e;
		}finally {
			close();
		}
		return result;
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
