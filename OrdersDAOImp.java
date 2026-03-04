package com.tap.DAOImp;

import java.sql.*;
import com.tap.DAO.OrdersDAO;
import com.tap.model.Orders;

public class OrdersDAOImp implements OrdersDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery_appl";
    private static final String USER = "root";
    private static final String PWD = "Computer+9$";

    @Override
    public int addOrder(Orders order) {

        int orderId = 0;

        String sql = "INSERT INTO orders (userId, restaurantId, totalAmount, orderDate, address, paymentMethod, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PWD);
                 PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                stmt.setInt(1, order.getUserId());
                stmt.setInt(2, order.getRestaurantId());
                stmt.setDouble(3, order.getTotalAmount());
                stmt.setTimestamp(4, order.getOrderDate());
                stmt.setString(5, order.getAddress());
                stmt.setString(6, order.getPaymentMethod());
                stmt.setString(7, order.getStatus());

                int rows = stmt.executeUpdate();

                if (rows > 0) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        orderId = rs.getInt(1);
                    }
                }

                System.out.println("Generated Order ID: " + orderId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return orderId;
    }
}