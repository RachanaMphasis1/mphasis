package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdersController {
	
	@Autowired
	private OrdersService ordersService;
	
	@RequestMapping("/showOrders")
	public  Orders[] show() {
		return ordersService.showOrders();
	}

	@RequestMapping("/customerOrders/{customerID}")
	public Orders[] customerOrders(@PathVariable int customerID) {
		return ordersService.customerOrders(customerID);
	}
	
    @RequestMapping("/customerPendingOrders/{customerID}")
    public Orders[] customerPendingOrders(@PathVariable int customerID) {
    	return ordersService.customerPendingOrders(customerID);
	}
    
    @RequestMapping("/vendorOrders/{vendorID}")
	public Orders[] vendorOrders(@PathVariable int vendorID) {
		return ordersService.vendorOrders(vendorID);
	}
	
    @RequestMapping("/vendorPendingOrders/{vendorID}")
    public Orders[] vendorPendingOrders(@PathVariable int vendorID) {
    	return ordersService.vendorPendingOrders(vendorID);
	}
	
}
