package com.tap.DAOImp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAO.UserDAO;
import com.tap.model.User;

public class UserDAOImp implements UserDAO{
	
	public static String USER="jdbc:mysql://localhost:3306/food_delivery_appl";
	public static String ID="root";
	public static String PWD="Computer+9$";
	Connection con;
	public static String ADD="insert into `user`(userId, userName, password, email, address, phoneNumber, role) values(?,?,?,?,?,?,?)";
	public static String UPDATE="update `user`  set `userName`=?,`password`=?,`email`=?,`phoneNumber`=? `address`=? where `userId`=?";
	public static String GET="select * from `user` where userId=?";
	public static String DELETE="delete from `user` where userId=?";
	public static String ALL_USERS="select*from `user`";
	@Override
	public int addUser(User u) {

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        con = DriverManager.getConnection(USER, ID, PWD);

	        String ADD = "INSERT INTO user(userName,password,email,address,phoneNumber,role) VALUES(?,?,?,?,?,?)";

	        PreparedStatement pstmt = con.prepareStatement(ADD);

	        pstmt.setString(1, u.getUserName());
	        pstmt.setString(2, u.getPassword());
	        pstmt.setString(3, u.getEmail());
	        pstmt.setString(4, u.getAddress());
	        pstmt.setString(5, u.getPhoneNumber());
	        pstmt.setString(6, u.getRole());

	        int result = pstmt.executeUpdate();

	        if (result == 1) {
	            System.out.println("User added successfully");
	            return 1;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return 0;
	}

	@Override
	public User getUser(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt=con.prepareStatement(GET);
			pstmt.setInt(1, id);
			
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				User u=new User( res.getInt("userId"),res.getString("userName"),res.getString("password"),
						res.getString("email"),res.getString("address"),res.getString("phoneNumber"),res.getString("role"),
						res.getTimestamp("lastLoginDate"),res.getTimestamp("createdDate"));
				return u;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void updateUser(User u) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt=con.prepareStatement(UPDATE);
			
			int userId=u.getUserId(); 
			String userName=u.getUserName();
			String password=u.getPassword();
			String email=u.getEmail();
			String address=u.getAddress();
			String phoneNumber=u.getPhoneNumber();
			
			
			pstmt.setString(1,userName);
			pstmt.setString(2,password);
			pstmt.setString(3,email);
			pstmt.setString(4,address);
			pstmt.setString(5,phoneNumber);
			
			pstmt.setInt(6, userId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt=con.prepareStatement(DELETE);
			pstmt.setInt(1, id);
			
			int result=pstmt.executeUpdate();
			if(result==1) {
				System.out.println("User deleted Succesfully");
			}else {
				System.out.println("User is not deleted");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list=new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con=DriverManager.getConnection(USER,ID,PWD);
			
			Statement stmt=con.createStatement();
			ResultSet res= stmt.executeQuery(ALL_USERS);
			
			while(res.next()) {
				User u=new User(res.getInt("userId"), res.getString("userName"), res.getString("password"), res.getString("email"), res.getString("address"), res.getString("phoneNumber"), res.getString("role"), res.getTimestamp("lastLoginDate"), res.getTimestamp("createdDate"));
				list.add(u);

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	@Override
	public User validateUser(String email, String password) {

	    User user = null;

	    try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection(USER,ID,PWD);

	        String sql = "SELECT * FROM user WHERE email=? AND password=?";
	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, email);
	        ps.setString(2, password);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {   // only if match found
	            user = new User();
	            user.setUserName(rs.getString("name"));
	            user.setEmail(rs.getString("email"));
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return user;   // will return null if not found
	}
	
}
