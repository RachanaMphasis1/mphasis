package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/showCustomer")
	public  Customer[] show() {
		return customerService.showCustomer();
	}
	
	@RequestMapping("/searchCustomer/{customerID}")
	public Customer searchCustomer(@PathVariable int customerID) {
		return customerService.searchCustomer(customerID);
	}

}
