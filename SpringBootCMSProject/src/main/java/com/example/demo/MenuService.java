package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuService {
	
	@Autowired
	MenuDAO dao;
	
	public Menu[] showMenu(int restaurantID) {
		List<Menu> menuList = dao.showMenu(restaurantID);
		return menuList.toArray(new Menu[menuList.size()]);
	}
	
	public Menu searchMenu(int menuID) {
		return dao.searchMenu(menuID);
	}
}
