package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendorDAO {
	Connection connection;
	PreparedStatement pst;
	
	public Vendor searchVendor(int vendorID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor where VendorID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorID);
		Vendor vendor = null;
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			vendor = new Vendor();
			vendor.setvendorID(rs.getInt("vendorID"));
			vendor.setvendorName(rs.getString("vendorName"));
			vendor.setvendorCity(rs.getString("vendorCity"));
			vendor.setvendorState(rs.getString("vendorState"));
			vendor.setvendorEmail(rs.getString("vendorEmail"));
			vendor.setvendorMobile(rs.getString("vendorMobile"));
		}
		return vendor;
	}
	
	public List<Vendor> showVendor() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Vendor> vendorList = new ArrayList<Vendor>();
		Vendor vendor = null; 
		while(rs.next()) {
			vendor = new Vendor();
			vendor.setvendorID(rs.getInt("vendorID"));
			vendor.setvendorName(rs.getString("vendorName"));
			vendor.setvendorCity(rs.getString("vendorCity"));
			vendor.setvendorState(rs.getString("vendorState"));
			vendor.setvendorEmail(rs.getString("vendorEmail"));
			vendor.setvendorMobile(rs.getString("vendorMobile"));
			vendorList.add(vendor);
		}
		return vendorList;
	}
	
	public String addVendor(Vendor vendor) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		int vendorID = generatevendorID();
		vendor.setvendorID(vendorID);
		String cmd = "Insert into Vendor(vendorID,vendorName,vendorCity,vendorEmail,vendorMobile)   "
				+ " values(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendor.getvendorID());
		pst.setString(2, vendor.getvendorName());
		pst.setString(3, vendor.getvendorCity());
		pst.setString(4, vendor.getvendorState());
		pst.setString(5, vendor.getvendorMobile());
		pst.executeUpdate();
		return "Record Inserted...";
	}
	

	public int generatevendorID() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(vendorID) IS NULL then 1 "
				+ " else Max(vendorID)+1 end vendorID from Vendor";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int vendorID = rs.getInt("vendorID");
		return vendorID;
	}

}
