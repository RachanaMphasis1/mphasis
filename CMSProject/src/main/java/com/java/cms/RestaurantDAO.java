package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.ConnectionHelper;
import com.java.cms.Restaurant;


public class RestaurantDAO {
	Connection connection;
	PreparedStatement pst;
	
	public String addRestaurant(Restaurant restaurant) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int restaurantID = generaterestaurantID();
		restaurant.setrestaurantID(restaurantID);
		String cmd = "Insert into Restaurant(restaurantID,restaurantName,city,branch,email,contactNo)   "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurant.getrestaurantID());
		pst.setString(2, restaurant.getrestaurantName());
		pst.setString(3, restaurant.getcity());
		pst.setString(4, restaurant.getbranch());
		pst.setString(5, restaurant.getemail());
		pst.setString(6, restaurant.getcontactNo());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

	public int generaterestaurantID() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(restaurantID) IS NULL then 1 "
				+ " else Max(restaurantID)+1 end restaurantID from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int restaurantID = rs.getInt("restaurantID");
		return restaurantID;
	}

	
	public Restaurant searchRestaurant(int restaurantID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant where RestaurantID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantID);
		Restaurant restaurant = null;
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			restaurant = new Restaurant();
			restaurant.setrestaurantID(rs.getInt("restaurantID"));
			restaurant.setrestaurantName(rs.getString("restaurantName"));
			restaurant.setcity(rs.getString("city"));
			restaurant.setbranch(rs.getString("branch"));
			restaurant.setemail(rs.getString("email"));
			restaurant.setcontactNo(rs.getString("contactNo"));
		}
		return restaurant;
	}
	
	public List<Restaurant> showRestaurant() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Restaurant";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Restaurant> restaurantList = new ArrayList<Restaurant>();
		Restaurant restaurant = null; 
		while(rs.next()) {
			restaurant = new Restaurant();
			restaurant.setrestaurantID(rs.getInt("restaurantID"));
			restaurant.setrestaurantName(rs.getString("restaurantname"));
			restaurant.setcity(rs.getString("city"));
			restaurant.setbranch(rs.getString("branch"));
			restaurant.setemail(rs.getString("email"));
			restaurant.setcontactNo(rs.getString("contactNo"));
			restaurantList.add(restaurant);
		}
		return restaurantList;
	}

}
