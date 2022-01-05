package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
	
	Connection connection;
	PreparedStatement pst;
	
	
	public Customer searchCustomer(int customerID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer where CustomerID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerID);
		Customer customer = null;
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			customer = new Customer();
			customer.setcustomerID(rs.getInt("customerID"));
			customer.setfirstName(rs.getString("firstName"));
			customer.setlastName(rs.getString("lastName"));
			customer.setgender(rs.getString("gender"));
			customer.setdob(rs.getString("dob"));
			customer.setmaritialStatus(rs.getString("maritialStatus"));
			customer.setaddress1(rs.getString("address1"));
			customer.setaddress2(rs.getString("address2"));
			customer.setcity(rs.getString("city"));
			customer.setstate(rs.getString("state"));
			customer.setzipcode(rs.getInt("zipcode"));
			customer.setcountry(rs.getString("country"));
			
		}
		return customer;
	}
	
	public List<Customer> showCustomer() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Customer> CustomerList = new ArrayList<Customer>();
		Customer customer = null; 
		while(rs.next()) {
			customer = new Customer();
			customer.setcustomerID(rs.getInt("customerID"));
			customer.setfirstName(rs.getString("firstName"));
			customer.setlastName(rs.getString("lastName"));
			customer.setgender(rs.getString("gender"));
			customer.setdob(rs.getString("dob"));
			customer.setmaritialStatus(rs.getString("maritialStatus"));
			customer.setaddress1(rs.getString("address1"));
			customer.setaddress2(rs.getString("address2"));
			customer.setcity(rs.getString("city"));
			customer.setstate(rs.getString("state"));
			customer.setzipcode(rs.getInt("zipcode"));
			customer.setcountry(rs.getString("country"));
			CustomerList.add(customer);
		}
		return CustomerList;
	}
	
	public String addCustomer(Customer customer) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int customerID = generatecustomerID();
		customer.setcustomerID(customerID);
		String cmd = "Insert into Customer(customerID,firstName,lastName,gender,dob,maritialStatus,address1,address2,city,state,zipcode,country)   "
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customer.getcustomerID());
		pst.setString(2, customer.getfirstName());
		pst.setString(3, customer.getlastName());
		pst.setString(4, customer.getgender());
		pst.setString(5, customer.getdob());
		pst.setString(6, customer.getmaritialStatus());
		pst.setString(7, customer.getaddress1());
		pst.setString(8, customer.getaddress2());
		pst.setString(9, customer.getcity());
		pst.setString(10, customer.getstate());
		pst.setInt(11, customer.getzipcode());
		pst.setString(12, customer.getcountry());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

	public int generatecustomerID() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(customerID) IS NULL then 1 "
				+ " else Max(customerID)+1 end customerID from Customer";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int customerID = rs.getInt("customerID");
		return customerID;
	}

}
