package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MenuDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Menu searchMenu(int menuID) {
		String cmd = "select * from Menu  where menuID=?";
		List<Menu> menuList = jdbcTemplate.query(cmd, new Object[] {menuID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setmenuID(rs.getInt("menuid"));
				menu.setrestaurantID(rs.getInt("restaurantid"));
				menu.setitemName(rs.getString("itemname"));
				menu.setmenuType(rs.getString("menutype"));
				menu.setcalories(rs.getInt("calaroies"));
				menu.setprice(rs.getInt("price"));
				return menu;
			}
		});
		if (menuList.size()==1) {
			return menuList.get(0);
		}
		return null;
	}

	public List<Menu> showMenu(int restaurantID) {
		String cmd = "select * from Menu where restaurantID=?" ;
		List<Menu> menuList = jdbcTemplate.query(cmd, new Object[] {restaurantID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Menu menu = new Menu();
				menu.setmenuID(rs.getInt("menuid"));
				menu.setrestaurantID(rs.getInt("restaurantid"));
				menu.setitemName(rs.getString("itemname"));
				menu.setmenuType(rs.getString("menutype"));
				menu.setcalories(rs.getInt("calaroies"));
				menu.setprice(rs.getInt("price"));
				return menu;
			}
		});
		return menuList;
	}



}
