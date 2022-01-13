package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class OrdersDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;
	
	public Orders[] showOrders() {
		String cmd = "select * from Orders";
		List<Orders> ordersList = null;
		ordersList = jdbcTemplate.query(cmd, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setorderID(rs.getInt("ORDERID"));
				orders.setmenuID(rs.getInt("MENUID"));
				orders.setvendorID(rs.getInt("VendorID"));
				orders.setcustomerID(rs.getInt("CustomerID"));
				orders.setwalletID(rs.getInt("WALLETID"));
				orders.setBillAmount(rs.getInt("BILLAMOUNT"));
				orders.setcomments(rs.getString("COMMENTS"));
				orders.setOrderDate(rs.getDate("ORDERDATE"));
				orders.setOrderStatus(rs.getString("ORDERSTATUS"));
				orders.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orders;
			}
		});
		return ordersList.toArray(new Orders[ordersList.size()]);
	}


	
	public List<Orders> customerOrders(int customerID) {
		String cmd = "select * from Orders where customerID=?";
		List<Orders> ordersList = jdbcTemplate.query(cmd, new Object[] {customerID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setorderID(rs.getInt("ORDERID"));
				orders.setmenuID(rs.getInt("MENUID"));
				orders.setvendorID(rs.getInt("VendorID"));
				orders.setcustomerID(rs.getInt("CustomerID"));
				orders.setwalletID(rs.getInt("WALLETID"));
				orders.setBillAmount(rs.getInt("BILLAMOUNT"));
				orders.setcomments(rs.getString("COMMENTS"));
				orders.setOrderDate(rs.getDate("ORDERDATE"));
				orders.setOrderStatus(rs.getString("ORDERSTATUS"));
				orders.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orders;
			}
		});
		return ordersList;
	}
	
	public List<Orders> customerPendingOrders(int customerID) {
		String cmd = "select * from Orders where customerID=? and OrderStatus='PENDING'   ";
		List<Orders> ordersList = jdbcTemplate.query(cmd, new Object[] {customerID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setorderID(rs.getInt("ORDERID"));
				orders.setmenuID(rs.getInt("MENUID"));
				orders.setvendorID(rs.getInt("VendorID"));
				orders.setcustomerID(rs.getInt("CustomerID"));
				orders.setwalletID(rs.getInt("WALLETID"));
				orders.setBillAmount(rs.getInt("BILLAMOUNT"));
				orders.setcomments(rs.getString("COMMENTS"));
				orders.setOrderDate(rs.getDate("ORDERDATE"));
				orders.setOrderStatus(rs.getString("ORDERSTATUS"));
				orders.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orders;
			}
		});
		return ordersList;
	}
	
	
	public List<Orders> vendorOrders(int vendorID) {
		String cmd = "select * from Orders where vendorID=?";
		List<Orders> ordersList = jdbcTemplate.query(cmd, new Object[] {vendorID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setorderID(rs.getInt("ORDERID"));
				orders.setmenuID(rs.getInt("MENUID"));
				orders.setvendorID(rs.getInt("VendorID"));
				orders.setcustomerID(rs.getInt("CustomerID"));
				orders.setwalletID(rs.getInt("WALLETID"));
				orders.setBillAmount(rs.getInt("BILLAMOUNT"));
				orders.setcomments(rs.getString("COMMENTS"));
				orders.setOrderDate(rs.getDate("ORDERDATE"));
				orders.setOrderStatus(rs.getString("ORDERSTATUS"));
				orders.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orders;
			}
		});
		return ordersList;
	}
	
	
	public List<Orders> vendorPendingOrders(int vendorID) {
		String cmd = "select * from Orders where vendorID=? and OrderStatus='PENDING'   ";
		List<Orders> ordersList = jdbcTemplate.query(cmd, new Object[] {vendorID}, new RowMapper() {

			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Orders orders = new Orders();
				orders.setorderID(rs.getInt("ORDERID"));
				orders.setmenuID(rs.getInt("MENUID"));
				orders.setvendorID(rs.getInt("VendorID"));
				orders.setcustomerID(rs.getInt("CustomerID"));
				orders.setwalletID(rs.getInt("WALLETID"));
				orders.setBillAmount(rs.getInt("BILLAMOUNT"));
				orders.setcomments(rs.getString("COMMENTS"));
				orders.setOrderDate(rs.getDate("ORDERDATE"));
				orders.setOrderStatus(rs.getString("ORDERSTATUS"));
				orders.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
				return orders;
			}
		});
		return ordersList;
	}		
}
