package Servlets;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOImp.RestaurantDAOImp;
import com.tap.DAOImp.UserDAOImp;
import com.tap.model.Restaurant;
import com.tap.model.User;

public class Launch {
	public static void main(String[] args) {
		
		UserDAOImp ui=new UserDAOImp();
		
		Scanner input=new Scanner(System.in);
		
		
//			System.out.println("Enter userId: ");
//			int userId=input.nextInt();
//			System.out.println("Enter Name: ");
//			input.nextLine();
//			String userName=input.nextLine(); 
//			System.out.println("Enter Password: ");
//			String password=input.nextLine();
//			System.out.println("Enter Email: ");
//			String email=input.nextLine();
//			System.out.println("Enter Address: ");
//			String address=input.nextLine();
//			System.out.println("Enter Phone Number: ");
//			String phoneNumber=input.nextLine();
//			System.out.println("Enter Role: ");
//			String role=input.nextLine();
//			
//			User u=new User(userId,userName, password, email,address, phoneNumber,role);
//			int result=ui.addUser(u);
//			System.out.println(result);
			
		
		
		
		
//		System.out.println("Enter id");
//		int id=input.nextInt();
//		
//		ui.deleteUser(id);
//		
		
//		ui.deleteUser(id);
		
		
	
		RestaurantDAOImp ri=new RestaurantDAOImp();
		
		List<Restaurant> list=ri.getAllRestaurant();
		for(Restaurant restaurant: list) {
			System.out.println(restaurant);
		}
		
	}
}
