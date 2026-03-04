package Servlets;
// use your package name

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.tap.DAOImp.UserDAOImp;
import com.tap.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phonenumber");
        String address = request.getParameter("address"); // change city → address
        String password = request.getParameter("password");

        User userObject = new User();

        userObject.setUserName(name);
        userObject.setEmail(email);
        userObject.setPhoneNumber(phone);
        userObject.setAddress(address);
        userObject.setPassword(password);
        userObject.setRole("customer"); // VERY IMPORTANT (must match enum)

        UserDAOImp dao = new UserDAOImp();
        int result = dao.addUser(userObject);

        if(result == 1) {
            response.sendRedirect("login.jsp");
        } else {
            response.getWriter().println("Registration Failed");
        }
    }
}