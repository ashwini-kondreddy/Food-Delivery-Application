package com.tap.DAOImp;
import java.sql.*;

import com.tap.DAO.*;
import com.tap.model.UserLogin;
public class userLoginDAOImp implements UserLoginDAO{

	
	
	String USER="jdbc:mysql://localhost:3306/login";
	String ID="root";
	String PWD="Computer+9$";
	String ADD="insert into user(username,password) values (?,?)";
	Connection con;
	@Override
	public int addUserLogin(UserLogin u) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con= DriverManager.getConnection(USER,ID,PWD);
			
			PreparedStatement pstmt=con.prepareStatement(ADD);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			int result=pstmt.executeUpdate();
			
			return result;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
