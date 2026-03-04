package com.tap.DAOImp;
import com.tap.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.tap.DAO.MenuDAO;
import com.tap.model.Menu;

public class MenuDAOImp implements MenuDAO{
	
	public static String USER="jdbc:mysql://localhost:3306/food_delivery_appl";
	public static String ID="root";
	public static String PWD="Computer+9$";
	Connection con;
	
	public static String GET_MENU_BY_RESTAURANT="select*from `menu` where `restaurantId`=?";
	
	public static String GET_MENU_BY_ID="select*from `menu` where `menuId`=?";
	@Override
	public List<Menu> getAllMenuByRestaurantId(int id) {
		List<Menu> allMenuList=new ArrayList<Menu>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt= con.prepareStatement(GET_MENU_BY_RESTAURANT);
			
			pstmt.setInt(1, id);
			
			ResultSet res= pstmt.executeQuery();
			
			while(res.next()) {
				
				Menu m=new Menu(res.getInt("menuId"), res.getInt("restaurantId"), res.getString("name"), 
						res.getString("description"), res.getInt("price"), res.getInt("rating"), 
						res.getString("imageURL"), res.getString("type"), res.getString("isAvaliable"));
				
				
				allMenuList.add(m);
				
			}
			return allMenuList;
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		return allMenuList;
	}
	
	
	
	
	public Menu getMenuById(int menuId) {
		Menu m=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt= con.prepareStatement(GET_MENU_BY_ID);
			
			pstmt.setInt(1, menuId);
			
			ResultSet res=pstmt.executeQuery();
			
			while(res.next()) {
				
				m=new Menu(res.getInt("menuId"), res.getInt("restaurantId"), res.getString("name"), 
						res.getString("description"), res.getInt("price"), res.getInt("rating"), 
						res.getString("imageURL"), res.getString("type"), res.getString("isAvaliable"));
				
			}
			
			return m;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
