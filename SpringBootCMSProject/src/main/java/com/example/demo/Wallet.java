package com.example.demo;

public class Wallet {

	private int walletID;
	private int customerID;
	private String walletType;
	private int amount;
	
	public int getwalletID() {
		return walletID;
	}
	public void setwalletID(int walletID) {
		this.walletID = walletID;
	}
	public int getcustomerID() {
		return customerID;
	}
	public void setcustomerID(int customerID) {
		this.customerID = customerID;
	}
	public String getwalletType() {
		return walletType;
	}
	public void setwalletType(String walletType) {
		this.walletType =walletType;
	}
	public int getamount() {
		return amount;
	}
	public void setamount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Wallet [walletID=" + walletID + ", customerID=" + customerID + ", walletType=" + walletType
				+ ", amount=" + amount + "]";
	}

}

