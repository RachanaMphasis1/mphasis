package com.java.cms;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WalletDAO {
	Connection connection;
	PreparedStatement pst;
	
	
	public List<Wallet> searchByCustomerID(int walletID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from Wallet where customerID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletID);
		ResultSet rs = pst.executeQuery();
		List<Wallet> walletList = new ArrayList<Wallet>();
		Wallet wallet = null;
		while (rs.next()) {
			wallet = new Wallet();
			wallet.setwalletID(rs.getInt("walletID"));
			wallet.setcustomerID(rs.getInt("customerID"));
			wallet.setwalletType(rs.getString("walletType"));
			wallet.setamount(rs.getInt("amount"));
			walletList.add(wallet);
		}
		return walletList;
	}
	
	public String deductBalance(int walletID, int billAmount) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "update wallet set amount=amount-? where walletID=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, billAmount);
		pst.setInt(2, walletID);
		pst.executeUpdate();
		return "Amount Deducted...";
	}
	
	public Wallet searchByWalletId(int walletID) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "select * from wallet where walletid=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, walletID);
		ResultSet rs = pst.executeQuery();
		Wallet wallet = null;
		if(rs.next()) {
			wallet = new Wallet();
			wallet.setwalletID(rs.getInt("walletid"));
			wallet.setcustomerID(rs.getInt("customerid"));
			wallet.setwalletType(rs.getString("wallettype"));
			wallet.setamount(rs.getInt("amount"));
		}
		return wallet;
		
	}

}
