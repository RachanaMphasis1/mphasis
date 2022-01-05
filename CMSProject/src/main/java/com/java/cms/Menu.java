package com.java.cms;

public class Menu {
	private int menuID;
	private int restaurantID;
	private String itemName;
	private String menuType;
	private int calaroies;
	private int price;
	
	public int getmenuID() {
		return menuID;
	}
	public void setmenuID(int menuID) {
		this.menuID = menuID;
	}
	public int getrestaurantID() {
		return restaurantID;
	}
	public void setrestaurantID(int restaurantID) {
		this.restaurantID = restaurantID;
	}
	public String getitemName() {
		return itemName;
	}
	public void setitemName(String itemName) {
		this.itemName =itemName;
	}
	public String getmenuType() {
		return menuType;
	}
	public void setmenuType(String menuType) {
		this.menuType = menuType;
	}
	public int getcalaroies() {
		return calaroies;
	}
	public void setcalories(int calaroies) {
		this.calaroies = calaroies;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Menu [menuID=" + menuID + ", restaurantID=" + restaurantID + ", itemName=" + itemName + ", menuType="
				+ menuType + ", calaroies=" + calaroies + ", price=" + price + "]";
	}
	
}



