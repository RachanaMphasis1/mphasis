package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/showRestaurant")
	public  Restaurant[] show() {
		return restaurantService.showRestaurant();
	}
	
	@RequestMapping("/searchRestaurant/{restaurantID}")
	public Restaurant searchRestaurant(@PathVariable int restaurantID) {
		return restaurantService.searchRestaurant(restaurantID);
	}
}

