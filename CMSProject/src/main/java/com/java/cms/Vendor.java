package com.java.cms;

public class Vendor {
	private int vendorID;
	private String vendorName;
	private String vendorCity;
	private String vendorState;
	private String vendorEmail;
	private String vendorMobile;
	
	public int getvendorID() {
		return vendorID;
	}
	public void setvendorID(int vendorID) {
		this.vendorID = vendorID;
	}
	public String getvendorName() {
		return vendorName;
	}
	public void setvendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getvendorCity() {
		return vendorCity;
	}
	public void setvendorCity(String vendorCity) {
		this.vendorCity = vendorCity;
	}
	public String getvendorState() {
		return vendorState;
	}
	public void setvendorState(String vendorState) {
		this.vendorState = vendorState;
	}
	public String getvendorEmail() {
		return vendorEmail;
	}
	public void setvendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getvendorMobile() {
		return vendorMobile;
	}
	public void setvendorMobile(String vendorMobile) {
		this.vendorMobile = vendorMobile;
	}
	@Override
	public String toString() {
		return "Vendor [vendorID=" + vendorID + ", vendorName=" + vendorName + ", vendorCity=" + vendorCity
				+ ", vendorState=" + vendorState + ", vendorEmail=" + vendorEmail + ", vendorMobile=" + vendorMobile
				+ "]";
	}

}
