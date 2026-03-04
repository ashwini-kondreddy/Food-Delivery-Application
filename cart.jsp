<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.tap.model.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Cart</title>

<style>
body {
  margin: 0;
  font-family: Arial, sans-serif;
  background: linear-gradient(135deg, #ffe0c3, #ffcba4);
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
}

.cart-container {
  background: #fff;
  width: 95%;
  max-width: 600px;
  padding: 25px;
  border-radius: 15px;
  box-shadow: 0 15px 30px rgba(0,0,0,0.15);
}

.cart-title {
  text-align: center;
  margin-bottom: 25px;
}

.cart-item {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background: #f8f8f8;
  padding: 15px;
  border-radius: 12px;
  margin-bottom: 15px;
  transition: 0.3s;
}

.cart-item:hover {
  transform: translateY(-3px);
  box-shadow: 0 8px 18px rgba(0,0,0,0.1);
}

.item-details {
  flex: 1;
}

.item-name {
  font-weight: bold;
  font-size: 16px;
}

.item-price {
  color: #777;
  font-size: 14px;
}

.qty-controls {
  display: flex;
  align-items: center;
  gap: 10px;
}

.quantity-btn {
  background: #995516;
  color: white;
  border: none;
  padding: 6px 12px;
  border-radius: 6px;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
}

.quantity-btn:hover {
  background: #7a420a;
}

.quantity-btn:disabled {
  background: #ccc;
  cursor: not-allowed;
}

.qty-number {
  font-weight: bold;
  font-size: 16px;
  min-width: 20px;
  text-align: center;
}

.cart-buttons {
  display: flex;
  flex-direction: column;
  gap: 12px;
  margin-top: 20px;
}

.add-btn, .checkout-btn {
  text-decoration: none;
  text-align: center;
  padding: 12px;
  border-radius: 8px;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
}

.add-btn {
  background: #995516;
  color: white;
}

.add-btn:hover {
  background: #7a420a;
}

.checkout-btn {
  background: #3da455;
  color: white;
  border: none;
}

.checkout-btn:hover {
  background: #1e7e34;
}

.empty-msg {
  text-align: center;
  font-size: 18px;
  margin: 20px 0;
}

@media(max-width:480px){
  .cart-item{
    flex-direction: column;
    align-items: flex-start;
    gap: 10px;
  }
  .qty-controls{
    width: 100%;
    justify-content: space-between;
  }
}
.remove-section {
  margin-left: 10px;
}

.remove-btn {
  background: transparent;
  border: none;
  font-size: 18px;
  cursor: pointer;
  transition: 0.3s;
}

.remove-btn:hover {
  transform: scale(1.2);
}
</style>
</head>

<body>

<div class="cart-container">
<h2 class="cart-title">🛒 My Cart</h2>

<%
Cart cart = (Cart)session.getAttribute("cart");
Integer restaurantId = (Integer)session.getAttribute("oldRestaurantId");

if(cart != null && !cart.getItems().isEmpty()){
  for(CartItem item : cart.getItems().values()){
%>

<div class="cart-item">
  
  <div class="item-details">
    <div class="item-name"><%= item.getName() %></div>
    <div class="item-price">₹ <%= item.getPrice() %></div>
  </div>

  <div class="qty-controls">
  
  
  	<!-- Decrease -->
    <form action="cart" >
      <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
      <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
      <button class="quantity-btn"
      <% if(item.getQuantity() == 1){ %> disabled <% } %>>
      -
      </button>
    </form>

    <div class="qty-number"><%= item.getQuantity() %></div>

    
    
    <!-- Increase -->
    <form action="cart">
      <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
      <input type="hidden" name="action" value="update">
      <input type="hidden" name="restaurantId" value="<%=restaurantId%>">
      <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
      <button class="quantity-btn">+</button>
    </form>
    
    
    <div class="remove-section">
    <form action="cart">
        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
        <input type="hidden" name="action" value="delete">
        <button class="remove-btn">🗑</button>
    </form>
	</div>

  </div>

</div>

<%
  }
  %>
  <div style="text-align:right; font-size:18px; font-weight:bold; margin-top:15px;">
  Total: ₹ <%= cart.getTotalPrice() %>
</div>
  <%
%>

<div class="cart-buttons">
  <a href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>" class="add-btn">
    Add More Items
</a>
  <a href="orderConformation.jsp" class="checkout-btn" style="text-decoration: none">Proceed to Checkout</a>
</div>

<%
}else{
%>

<div class="empty-msg">Your cart is empty 🛍️</div>

<div class="cart-buttons">
  <a href="restaurant" class="add-btn">Add Items</a>
</div>

<%
}
%>

</div>
</body>
</html>