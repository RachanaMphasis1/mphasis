package com.java.cms;

public class Restaurant {
	private int restaurantID;
	private String restaurantName;
	private String city;
	private String branch;
	private String email;
	private String contactNo;
	
	public int getrestaurantID() {
		return restaurantID;
	}
	public void setrestaurantID(int RestaurantID) {
		this.restaurantID = RestaurantID;
	}
	public String getrestaurantName() {
		return restaurantName;
	}
	public void setrestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	public String getbranch() {
		return branch;
	}
	public void setbranch(String branch) {
		this.branch = branch;
	}
	public String getemail() {
		return email;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public String getcontactNo() {
		return contactNo;
	}
	public void setcontactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	@Override
	public String toString() {
		return "Restaurant [restaurantID=" + restaurantID + ", restaurantName=" + restaurantName + ", city=" + city
				+ ", branch=" + branch + ", email=" + email + ", contactNo=" + contactNo + "]";
	}

}
