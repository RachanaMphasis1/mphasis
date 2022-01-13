package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/showMenu/{restaurantID}")
	public Menu[] showMenu(@PathVariable int restaurantID) {
		return menuService.showMenu(restaurantID);
	}	
	
	@RequestMapping("/searchMenu/{menuID}")
	public Menu searchMenu(@PathVariable int menuID) {
		return menuService.searchMenu(menuID);
	}

}
