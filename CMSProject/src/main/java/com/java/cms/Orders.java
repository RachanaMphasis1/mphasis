package com.java.cms;

	import java.sql.Date;

	public class Orders {

		private int orderID;
		private int vendorID;
		private int customerID;
		private int menuID;
		private int walletID;
		private Date orderDate;
		private int quantityOrdered;
		private String orderStatus;
		private int billAmount;
		private String comments;
		
		public int getorderID() {
			return orderID;
		}
		public void setorderID(int orderID) {
			this.orderID = orderID;
		}
		public int getvendorID() {
			return vendorID;
		}
		public void setvendorID(int vendorID) {
			this.vendorID = vendorID;
		}
		public int getcustomerID() {
			return customerID;
		}
		public void setcustomerID(int customerID) {
			this.customerID = customerID;
		}
		public int getmenuID() {
			return menuID;
		}
		public void setmenuID(int menuID) {
			this.menuID = menuID;
		}
		public int getwalletID() {
			return walletID;
		}
		public void setwalletID(int walletID) {
			this.walletID = walletID;
		}
		public Date getOrderDate() {
			return orderDate;
		}
		public void setOrderDate(Date orderDate) {
			this.orderDate = orderDate;
		}
		public int getQuantityOrdered() {
			return quantityOrdered;
		}
		public void setQuantityOrdered(int quantityOrdered) {
			this.quantityOrdered = quantityOrdered;
		}
		public String getOrderStatus() {
			return orderStatus;
		}
		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}
		public int getBillAmount() {
			return billAmount;
		}
		public void setBillAmount(int billAmount) {
			this.billAmount = billAmount;
		}
		public String getcomments() {
			return comments;
		}
		public void setcomments(String comments) {
			this.comments = comments;
		}
		@Override
		public String toString() {
			return "Orders [orderID=" + orderID + ", vendorID=" + vendorID + ", customerID=" + customerID + ", menuID="
					+ menuID + ", walletID=" + walletID + ", orderDate=" + orderDate + ", quantityOrdered="
					+ quantityOrdered + ", orderStatus=" + orderStatus + ", billAmount=" + billAmount + ", comments="
					+ comments + "]";
		}
		
	}


