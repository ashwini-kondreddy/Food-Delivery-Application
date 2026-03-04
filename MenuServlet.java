package Servlets;

import java.io.IOException;
import java.util.List;

import com.tap.DAOImp.MenuDAOImp;
import com.tap.model.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
	        throws ServletException, IOException {

	    String restIdStr = req.getParameter("restaurantId");

	    // If restaurantId not coming from URL, try session
	    if (restIdStr == null || restIdStr.equals("null") || restIdStr.isEmpty()) {

	        Object sessionRestId = req.getSession().getAttribute("restaurantId");

	        if (sessionRestId != null) {
	            restIdStr = sessionRestId.toString();
	        } else {
	            resp.sendRedirect("restaurant.jsp"); // your restaurant listing page
	            return;
	        }
	    }

	    int restaurantId = Integer.parseInt(restIdStr);

	    // Store again in session (important for future use)
	    req.getSession().setAttribute("restaurantId", restaurantId);

	    MenuDAOImp mi = new MenuDAOImp();
	    List<Menu> allMenuByRestaurant = 
	            mi.getAllMenuByRestaurantId(restaurantId);

	    req.setAttribute("allMenuByRestaurant", allMenuByRestaurant);

	    RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
	    rd.forward(req, resp);
	}

}
