package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {
	
	@Autowired
	private VendorService vendorService;
	
	@RequestMapping("/showVendor")
	public  Vendor[] show() {
		return vendorService.showVendor();
	}
	
	@RequestMapping("/searchVendor/{vendorID}")
	public Vendor searchVendor(@PathVariable int vendorID) {
		return vendorService.searchVendor(vendorID);
	}

}