package com.tap.DAO;

import java.util.List;

import com.tap.model.Menu;

public interface MenuDAO {
	
	
	List<Menu> getAllMenuByRestaurantId(int id);
}
