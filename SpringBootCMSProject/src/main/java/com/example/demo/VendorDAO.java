package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VendorDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Vendor searchVendor(int vendorID) {
		String cmd = "select * from Vendor  where vendorID=?";
		List<Vendor> vendorList = jdbcTemplate.query(cmd, new Object[] {vendorID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor vendor = new Vendor();
				vendor.setvendorID(rs.getInt("vendorID"));
				vendor.setvendorName(rs.getString("vendorName"));
				vendor.setvendorCity(rs.getString("vendorCity"));
				vendor.setvendorState(rs.getString("vendorState"));
				vendor.setvendorEmail(rs.getString("vendorEmail"));
				vendor.setvendorMobile(rs.getString("vendorMobile"));
				return vendor;
			}
		});
		if (vendorList.size()==1) {
			return vendorList.get(0);
		}
		return null;
	}

	public Vendor[] showVendor() {
		String cmd = "select * from Vendor";
		List<Vendor> vendorList = null;
		vendorList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Vendor vendor = new Vendor();
				vendor.setvendorID(rs.getInt("vendorID"));
				vendor.setvendorName(rs.getString("vendorName"));
				vendor.setvendorCity(rs.getString("vendorCity"));
				vendor.setvendorState(rs.getString("vendorState"));
				vendor.setvendorEmail(rs.getString("vendorEmail"));
				vendor.setvendorMobile(rs.getString("vendorMobile"));
				return vendor;
			}
		});
		return vendorList.toArray(new Vendor[vendorList.size()]);
	}

}
