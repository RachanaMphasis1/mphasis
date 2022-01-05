package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.ConnectionHelper;
import com.java.cms.Menu;

public class MenuDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	public List<Menu> showMenu(int restaurantID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where restaurantID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, restaurantID);
		ResultSet rs = pst.executeQuery();
		List<Menu> menuList = new ArrayList<Menu>();
		Menu menu = null;
		while(rs.next()) {
			menu = new Menu();
			menu.setmenuID(rs.getInt("menuid"));
			menu.setrestaurantID(rs.getInt("restaurantid"));
			menu.setitemName(rs.getString("itemname"));
			menu.setmenuType(rs.getString("menutype"));
			menu.setcalories(rs.getInt("calaroies"));
			menu.setprice(rs.getInt("price"));
			menuList.add(menu);
		}
		return menuList;
	}
	
	
	public Menu searchMenu(int menuID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from menu where menuID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menuID);
		ResultSet rs = pst.executeQuery();
		Menu menu = null;
		if(rs.next()) {
			menu = new Menu();
			menu.setmenuID(rs.getInt("menuid"));
			menu.setrestaurantID(rs.getInt("restaurantid"));
			menu.setitemName(rs.getString("itemname"));
			menu.setmenuType(rs.getString("menutype"));
			menu.setcalories(rs.getInt("calaroies"));
			menu.setprice(rs.getInt("price"));
		}
		return menu;
		
	}
	
	public String addMenu(Menu menu) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int menuID = generatemenuID();
		menu.setmenuID(menuID);
		String cmd = "Insert into Menu(menuID,restaurantid,itemname,menutype,calaroies,price)   "
				+ " values(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, menu.getmenuID());
		pst.setInt(2, menu.getrestaurantID());
		pst.setString(3, menu.getitemName());
		pst.setString(4, menu.getmenuType());
		pst.setInt(5, menu.getcalaroies());
		pst.setInt(6, menu.getprice());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

	public int generatemenuID() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(menuID) IS NULL then 1 "
				+ " else Max(menuID)+1 end menuID from Menu";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int menuID = rs.getInt("menuID");
		return menuID;
	}


}
