package com.tap.DAOImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.RestaurantDAO;
import com.tap.model.Restaurant;

public class RestaurantDAOImp implements RestaurantDAO{
	public static String USER="jdbc:mysql://localhost:3306/food_delivery_appl";
	public static String ID="root";
	public static String PWD="Computer+9$";
	Connection con;
	public static String ALL_RESTAURANTS="select*from `restaurant`";
	@Override
	public List<Restaurant> getAllRestaurant() {
		
		List<Restaurant> list=new ArrayList<Restaurant>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			Statement stmt=con.createStatement();
			
			ResultSet res= stmt.executeQuery(ALL_RESTAURANTS);
			
			while(res.next()) {
				Restaurant r=new Restaurant(res.getInt("restaurantId"), res.getString("name"), res.getString("adminId"), 
						res.getString("address"), res.getString("cuisineType"), res.getInt("rating"), res.getString("ETA"),
						res.getString("imageUrl"), res.getString("isAvaliable"));
				
				list.add(r);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
		
	}

}
