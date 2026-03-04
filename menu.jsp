<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page import="java.util.*, com.tap.model.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Restaurant Menu</title>

<style>
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family: Arial, Helvetica, sans-serif;
}

body{
    background:#f5f5f5;
}

/* NAVBAR */
.navbar{
    background:#ff4d4d;
    color:white;
    padding:15px 40px;
    display:flex;
    justify-content:space-between;
    align-items:center;
}

.navbar h2{
    font-size:22px;
}

.cart-btn{
    background:white;
    color:#ff4d4d;
    padding:8px 15px;
    border-radius:20px;
    font-weight:bold;
    cursor:pointer;
    border:none;
}

/* MENU GRID */
.menu-container{
    padding:40px;
    display:grid;
    grid-template-columns:repeat(auto-fit,minmax(250px,1fr));
    gap:25px;
}

/* CARD */
.card{
    background:white;
    border-radius:12px;
    overflow:hidden;
    box-shadow:0 5px 15px rgba(0,0,0,0.1);
    transition:0.3s;
}

.card:hover{
    transform:translateY(-5px);
}

.card img{
    width:100%;
    height:180px;
    object-fit:cover;
}

/* CARD CONTENT */
.card-content{
    padding:15px;
}

.card-content h3{
    margin-bottom:8px;
}

.description{
    font-size:14px;
    color:#555;
    margin-bottom:10px;
}

.rating{
    color:gold;
    margin-bottom:10px;
}

.price-type{
    display:flex;
    justify-content:space-between;
    align-items:center;
    margin-bottom:12px;
}

.price{
    font-weight:bold;
    font-size:16px;
}

.type{
    padding:4px 8px;
    border-radius:12px;
    font-size:12px;
    font-weight:bold;
}

.veg{
    background:#d4edda;
    color:#155724;
}

.nonveg{
    background:#f8d7da;
    color:#721c24;
}

/* BUTTON */
.add-btn{
    width:100%;
    padding:8px;
    background:#ff4d4d;
    color:white;
    border:none;
    border-radius:6px;
    cursor:pointer;
    font-weight:bold;
    transition:0.3s;
}

.add-btn:hover{
    background:#e60000;
}

</style>
</head>
<body>

<!-- NAVBAR -->
<div class="navbar">
    <h2> Menu</h2>
    <a href="cart.jsp" class="cart-btn" style="text-decoration: none">🛒 Cart</a>
</div>

<!-- MENU ITEMS -->
<div class="menu-container">


	<%
	
	
	List<Menu> menu=(List<Menu>)request.getAttribute("allMenuByRestaurant");
	
	
	for(Menu m:menu){
		%>
		
			<div class="card">
	        <img src="<%=m.getImageURL()%>" alt="">
	        <div class="card-content">
	            <h3><%=m.getName()%></h3>
	            <p class="description"><%= m.getDescription() %></p>
	            <div class="rating">★<%= m.getRating() %></div>
	            <div class="price-type">
	                <span class="price"><%=m.getPrice() %></span>
	                <span class="type veg"><%=m.getType() %></span>
	            </div>
	            
	            
	            
	            <form action="cart" method="get">
	            
	            <input type="hidden" name="itemId" value="<%= m.getMenuId() %>">
	            <input type="hidden" name="restaurantId" value="<%=m.getRestaurantId() %>">
	            <input type="hidden" name="quantity" value="1">
	            <input type="hidden" name="action" value="add">
	            <input type="submit" value="Add to cart" class="add-btn">
	             
	            
	            
	            </form>
	            
	            
	        </div>
	    </div>
		
		
		
		<%
	}
	
	%>






    <!-- ITEM 1 -->
    

    

</div>

</body>
</html>