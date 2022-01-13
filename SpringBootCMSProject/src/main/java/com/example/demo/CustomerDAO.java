package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Customer searchCustomer(int customerID) {
		String cmd = "select * from Customer  where customerID=?";
		List<Customer> customerList = jdbcTemplate.query(cmd, new Object[] {customerID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
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
				return customer;
			}
		});
		if (customerList.size()==1) {
			return customerList.get(0);
		}
		return null;
	}

	public Customer[] showCustomer() {
		String cmd = "select * from Customer";
		List<Customer> customerList = null;
		customerList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
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
				return customer;
			}
		});
		return customerList.toArray(new Customer[customerList.size()]);
	}

}


