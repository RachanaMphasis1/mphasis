package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RestaurantService {
	
	@Autowired
	RestaurantDAO dao;
	
	public Restaurant[] showRestaurant() {
		return dao.showRestaurant();
	}
	
	public Restaurant searchRestaurant(int restaurantID) {
		return dao.searchRestaurant(restaurantID);
	}
}
