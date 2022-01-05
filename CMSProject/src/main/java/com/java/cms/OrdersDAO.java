package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	public List<Orders> customerOrders(int customerID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where customerID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerID);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
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
			OrdersList.add(orders);
		}
		return OrdersList;
	}
	
	public List<Orders> customerPendingOrders(int customerID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where customerID=? and OrderStatus='PENDING'   ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, customerID);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
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
			OrdersList.add(orders);
		}
		return OrdersList;
	}
	
	public List<Orders> vendorsOrders(int vendorID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where vendorID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorID);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
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
			OrdersList.add(orders);
		}
		return OrdersList;
	}
	
	public List<Orders> vendorPendingOrders(int vendorID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Orders where vendorID=? and OrderStatus='PENDING'   ";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, vendorID);
		ResultSet rs = pst.executeQuery();
		List<Orders> OrdersList = new ArrayList<Orders>();
		Orders orders = null;
		while(rs.next()) {
			orders = new Orders();
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
			OrdersList.add(orders);
		}
		return OrdersList;
	}
	
	public Orders searchOrder(int orderId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from orders where  ORDERID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, orderId);
		ResultSet rs = pst.executeQuery();
		Orders orderFound = null;
		if (rs.next()) {
			orderFound = new Orders();
			orderFound.setorderID(rs.getInt("ORDERID"));
			orderFound.setmenuID(rs.getInt("MENUID"));
			orderFound.setvendorID(rs.getInt("VendorID"));
			orderFound.setcustomerID(rs.getInt("CustomerID"));
			orderFound.setwalletID(rs.getInt("WALLETID"));
			orderFound.setBillAmount(rs.getInt("BILLAMOUNT"));
			orderFound.setcomments(rs.getString("COMMENTS"));
			orderFound.setOrderDate(rs.getDate("ORDERDATE"));
			orderFound.setOrderStatus(rs.getString("ORDERSTATUS"));
			orderFound.setQuantityOrdered(rs.getInt("QUANTITYORDERED"));
		}
		return orderFound;
	}
	public String acceptOrRejectOrder(int orderID, int vendorID, String status) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		Orders order = searchOrder(orderID);
		if (order.getvendorID()==vendorID) {
			if (status.toUpperCase().equals("YES")) {
				String cmd = "Update orders set OrderStatus='ACCEPTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderID);
				pst.executeUpdate();
				return "Order Approved Successfully...";
			} else {
				String cmd = "Update orders set OrderStatus='REJECTED' "
						+ " WHERE OrderID=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, orderID);
				pst.executeUpdate();
				cmd = "Update Wallet set Amount=Amount+? where walletId=?";
				pst = connection.prepareStatement(cmd);
				pst.setInt(1, order.getBillAmount());
				pst.setInt(2, order.getwalletID());
				pst.executeUpdate();
				return "Order Rejected Amount Refunded...";
			}
		} 
		return "You are unauthorized vendor...";
	}

	
	public String placeOrder(Orders order) throws SQLException, ClassNotFoundException {
		int oid = generateOrderId();
		order.setOrderStatus("PENDING");
		java.util.Date today = new Date();
		java.sql.Date dbDate = new java.sql.Date(today.getTime());
		order.setOrderDate(dbDate);
		Menu menu = new MenuDAO().searchMenu(order.getmenuID());
		int price = menu.getprice();
		int  billAmount = order.getQuantityOrdered() * price;
		Wallet wallet = new WalletDAO().searchByWalletId(order.getwalletID());
		int amount = wallet.getamount();
		if (amount - billAmount > 0) {
			order.setBillAmount(billAmount);
			order.setorderID(oid);
			String cmd = "insert into Orders(orderId,VendorId,CustomerId,MenuID,"
					+ "WalletId,OrderDate,QuantityOrdered,OrderStatus,BillAmount,Comments) "
					+ "values(?,?,?,?,?,?,?,?,?,?)";
			pst = connection.prepareStatement(cmd);
			pst.setInt(1, order.getorderID());
			pst.setInt(2, order.getvendorID());
			pst.setInt(3, order.getcustomerID());
			pst.setInt(4, order.getmenuID());
			pst.setInt(5, order.getwalletID());
			pst.setDate(6, order.getOrderDate()); 
			pst.setInt(7, order.getQuantityOrdered());
			pst.setString(8, order.getOrderStatus());
			pst.setInt(9, order.getBillAmount());
			pst.setString(10, order.getcomments());
			pst.executeUpdate();
			new WalletDAO().deductBalance(order.getwalletID(), billAmount);
			return "Order Placed Successfully...Wallet Balance Deducted...";
		}
		return "Insufficient Funds...";
		//order.setBillAmount(billAmount);
	}
	
	public int generateOrderId() throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select case when max(ORDERID) is NULL THEN 1"
				+ " else max(ORDERID)+1 end oid from orders";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		rs.next();
		int id = rs.getInt("oid");
		return id;
	}


}
