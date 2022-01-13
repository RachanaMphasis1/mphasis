package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrdersService {
	
	@Autowired
	OrdersDAO dao;
	
	public Orders[] showOrders() {
		return dao.showOrders();
	}
	
	public Orders[] customerOrders(int customerID) {
		List<Orders> ordersList = dao.customerOrders(customerID);
		return ordersList.toArray(new Orders[ordersList.size()]);
	}
	
	public Orders[] customerPendingOrders(int customerID) {
		List<Orders> ordersList = dao.customerPendingOrders(customerID);
		return ordersList.toArray(new Orders[ordersList.size()]);
	}	
	
	public Orders[] vendorOrders(int vendorID) {
		List<Orders> ordersList = dao.vendorOrders(vendorID);
		return ordersList.toArray(new Orders[ordersList.size()]);
	}
	
	public Orders[] vendorPendingOrders(int vendorID) {
		List<Orders> ordersList = dao.vendorPendingOrders(vendorID);
		return ordersList.toArray(new Orders[ordersList.size()]);
	}

}