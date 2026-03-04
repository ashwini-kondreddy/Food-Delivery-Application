package Servlets;

import com.tap.model.Menu;
import java.io.IOException;

import com.tap.model.CartItem;

import com.mysql.cj.Session;
import com.tap.DAOImp.MenuDAOImp;
import com.tap.model.Cart;
import com.tap.model.CartItem;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cart")
public class CartServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		Cart cart=(Cart)session.getAttribute("cart");
		
		Integer oldRestaurantId=(Integer)session.getAttribute("oldRestaurantId");
		
		int restaurantId=Integer.parseInt(req.getParameter("restaurantId"));
		
		if(cart==null || oldRestaurantId!=restaurantId) {
			cart=new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("oldRestaurantId", restaurantId);
			
		}
		
		String action=req.getParameter("action");
		if(action.equals("add")) {
			addItemToCart(req,cart);
		}else if(action.equals("update")) {
			updateItemOfCart(req,cart);
		}else if(action.equals("delete")){
			deleteItemFromCart(req,cart);
		}
		
		
		resp.sendRedirect("cart.jsp");
	}

	

	private void addItemToCart(HttpServletRequest req, Cart cart) {
		// TODO Auto-generated method stub
		
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		
		MenuDAOImp menuDAOImp= new MenuDAOImp();
		Menu menu=menuDAOImp.getMenuById(itemId);
		
		String itemName=menu.getName();
		double itemPrice=menu.getPrice();
		
		CartItem cartItem=new CartItem(itemId,itemName,quantity,itemPrice);
		
		cart.addItem(cartItem);
		
	}
	
	private void updateItemOfCart(HttpServletRequest req, Cart cart) {
		// TODO Auto-generated method stub
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		cart.updateItem(itemId, quantity);
		
	}
	
	private void deleteItemFromCart(HttpServletRequest req, Cart cart) {
		// TODO Auto-generated method stub
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		cart.removeItem(itemId);
		
	}

}
