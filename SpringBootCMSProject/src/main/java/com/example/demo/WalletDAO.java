package com.example.demo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

	@Repository
	public class WalletDAO {
		
		@Autowired
	    JdbcTemplate jdbcTemplate;
		
		public Wallet searchWallet(int walletID) {
			String cmd = "select * from Wallet  where walletID=?";
			List<Wallet> walletList = jdbcTemplate.query(cmd, new Object[] {walletID}, new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Wallet wallet = new Wallet();
					wallet.setwalletID(rs.getInt("walletID"));
					wallet.setcustomerID(rs.getInt("customerID"));
					wallet.setwalletType(rs.getString("walletType"));
					wallet.setamount(rs.getInt("amount"));
					return wallet;
				}
			});
			if (walletList.size()==1) {
				return walletList.get(0);
			}
			return null;
		}

		public Wallet[] showWallet() {
			String cmd = "select * from Wallet";
			List<Wallet> walletList = null;
			walletList = jdbcTemplate.query(cmd, new RowMapper() {

				@Override
				public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
					Wallet wallet = new Wallet();
					wallet.setwalletID(rs.getInt("walletID"));
					wallet.setcustomerID(rs.getInt("customerID"));
					wallet.setwalletType(rs.getString("walletType"));
					wallet.setamount(rs.getInt("amount"));
					return wallet;
				}
			});
			return walletList.toArray(new Wallet[walletList.size()]);
		}

	}


