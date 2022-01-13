package com.example.demo;

public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private String gender;
	private String dob;
	private String maritialStatus;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private int zipcode;
	private String country;
	
	
	public int getcustomerID() {
		return customerID;
	}
	public void setcustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getfirstName() {
		return firstName;
	}
	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getlastName() {
		return lastName;
	}
	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	public String getgender() {
		return gender;
	}
	public void setgender(String gender) {
		this.gender = gender;
	}
	public String getdob() {
		return dob;
	}
	public void setdob(String dob) {
		this.dob = dob;
	}
	public String getmaritialStatus() {
		return maritialStatus;
	}
	public void setmaritialStatus(String maritialStatus) {
		this.maritialStatus = maritialStatus;
	}
	
	public String getaddress1() {
		return address1;
	}
	public void setaddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getaddress2() {
		return address2;
	}
	public void setaddress2(String address2) {
		this.address2 = address2;
	}
	
	public String getcity() {
		return city;
	}
	public void setcity(String city) {
		this.city = city;
	}
	
	public String getstate() {
		return state;
	}
	public void setstate(String state) {
		this.state = state;
	}
	
	public int getzipcode() {
		return zipcode;
	}
	public void setzipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	
	public String getcountry() {
		return country;
	}
	public void setcountry(String country) {
		this.country = country;
	}
	@Override
	public String toString() {
		return "Customer [customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", dob=" + dob + ", maritialStatus=" + maritialStatus + ", address1="
				+ address1 + ", address2=" + address2 + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", country=" + country + "]";
	}
	
}



