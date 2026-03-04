package Servlets;

import java.io.IOException;
import java.sql.Timestamp;

import com.tap.DAOImp.OrderItemDAOImp;
import com.tap.DAOImp.OrdersDAOImp;
import com.tap.model.Cart;
import com.tap.model.CartItem;
import com.tap.model.OrderItem;
import com.tap.model.Orders;
import com.tap.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/checkout")
public class CheckOutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");

        String address = req.getParameter("address");
        String paymentMode = req.getParameter("paymentMode");

        // 🔴 If not logged in
        if (user == null) {
            RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
            rd.forward(req, resp);
            return;  // IMPORTANT
        }

        // 🔴 If cart empty
        if (cart == null || cart.getItems().isEmpty()) {
            resp.sendRedirect("cart.jsp");
            return;
        }

        // ✅ Create Order
        Orders order = new Orders();
        order.setUserId(user.getUserId());
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setAddress(address);
        order.setStatus("Order Received");
        order.setPaymentMethod(paymentMode);

        double totalAmount = 0.0;

        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getQuantity() * item.getPrice();
        }

        order.setTotalAmount(totalAmount);

        OrdersDAOImp odi = new OrdersDAOImp();
        int orderId = odi.addOrder(order);
        System.out.println("Generated Order ID: " + orderId);

        // ✅ Save Order Items
        OrderItemDAOImp oidi = new OrderItemDAOImp();

        for (CartItem item : cart.getItems().values()) {

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(orderId);
            orderItem.setItemName(item.getName()); // if you have name field
            orderItem.setQty(item.getQuantity());
            orderItem.setTotalPrice(item.getQuantity() * item.getPrice());

            oidi.addOrderItem(orderItem);
        }

        // ✅ Clear session
        session.removeAttribute("cart");
        session.removeAttribute("oldRestaurantId");

        req.setAttribute("orderId", orderId);
        req.setAttribute("totalAmount", totalAmount);

        RequestDispatcher rd = req.getRequestDispatcher("orderConformation.jsp");
        rd.forward(req, resp);
    }
}
