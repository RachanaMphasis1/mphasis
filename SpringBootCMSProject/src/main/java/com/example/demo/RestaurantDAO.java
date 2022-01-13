package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class RestaurantDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Restaurant searchRestaurant(int restaurantID) {
		String cmd = "select * from Restaurant  where restaurantID=?";
		List<Restaurant> restaurantList = jdbcTemplate.query(cmd, new Object[] {restaurantID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Restaurant restaurant = new Restaurant();
				restaurant.setrestaurantID(rs.getInt("restaurantID"));
				restaurant.setrestaurantName(rs.getString("restaurantName"));
				restaurant.setcity(rs.getString("city"));
				restaurant.setbranch(rs.getString("branch"));
				restaurant.setemail(rs.getString("email"));
				restaurant.setcontactNo(rs.getString("contactNo"));
				return restaurant;
			}
		});
		if (restaurantList.size()==1) {
			return restaurantList.get(0);
		}
		return null;
	}

	public Restaurant[] showRestaurant() {
		String cmd = "select * from Restaurant";
		List<Restaurant> restaurantList = null;
		restaurantList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Restaurant restaurant = new Restaurant();
				restaurant.setrestaurantID(rs.getInt("restaurantID"));
				restaurant.setrestaurantName(rs.getString("restaurantName"));
				restaurant.setcity(rs.getString("city"));
				restaurant.setbranch(rs.getString("branch"));
				restaurant.setemail(rs.getString("email"));
				restaurant.setcontactNo(rs.getString("contactNo"));
				return restaurant;
			}
		});
		return restaurantList.toArray(new Restaurant[restaurantList.size()]);
	}

}
