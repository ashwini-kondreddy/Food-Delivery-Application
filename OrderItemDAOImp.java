package com.tap.DAOImp;

import java.sql.*;
import com.tap.DAO.OrderItemDAO;
import com.tap.model.OrderItem;

public class OrderItemDAOImp implements OrderItemDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/food_delivery_appl";
    private static final String USER = "root";
    private static final String PWD = "Computer+9$";

    @Override
    public int addOrderItem(OrderItem orderItem) {

        int id = 0;

        String sql = "INSERT INTO orderitem (orderId, itemName, qty, totalPrice) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(URL, USER, PWD);
                 PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

                stmt.setInt(1, orderItem.getOrderId());
                stmt.setString(2, orderItem.getItemName());
                stmt.setInt(3, orderItem.getQty());
                stmt.setDouble(4, orderItem.getTotalPrice());

                int rows = stmt.executeUpdate();
                System.out.println("Rows inserted: " + rows);

                if (rows > 0) {
                    ResultSet rs = stmt.getGeneratedKeys();
                    if (rs.next()) {
                        id = rs.getInt(1);
                    }
                }

                System.out.println("OrderItem inserted with ID: " + id);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}