<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page  import="java.util.*,com.tap.*,com.tap.model.*"%>>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Food Delivery</title>

<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
a{
	text-decoration: none;
	color: black;
}

body {
  background: #f8f8f8;
}

/* ---------- NAVBAR ---------- */

.nav {
  background: white;
  padding: 15px 5%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-shadow: 0 2px 10px rgba(0,0,0,0.08);
  position: sticky;
  top: 0;
  z-index: 100;
}

.logo {
  font-size: 22px;
  font-weight: bold;
  color: #fc8019;
}

.nav-links a {
  text-decoration: none;
  color: #333;
  margin-left: 20px;
  font-weight: 500;
  transition: 0.3s;
}

.nav-links a:hover {
  color: #fc8019;
}

/* ---------- HERO SECTION ---------- */

.hero {
  padding: 40px 5%;
  text-align: center;
}

.hero h1 {
  font-size: 28px;
  margin-bottom: 10px;
}

.hero p {
  color: gray;
}

/* ---------- CARD CONTAINER ---------- */

.container {
  padding: 20px 5%;
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
  gap: 20px;
}

/* ---------- CARD DESIGN ---------- */

.box {
  background: white;
  border-radius: 15px;
  overflow: hidden;
  transition: 0.3s;
  cursor: pointer;
}

.box:hover {
  transform: translateY(-6px);
  box-shadow: 0 8px 20px rgba(0,0,0,0.15);
}

.box img {
  width: 100%;
  height: 170px;
  object-fit: cover;
}

.card-content {
  padding: 15px;
}

.res-name {
  font-size: 18px;
  font-weight: 600;
  margin-bottom: 5px;
}

.desc {
  font-size: 14px;
  color: gray;
  margin-bottom: 8px;
}

.info {
  display: flex;
  justify-content: space-between;
  font-size: 13px;
  color: #555;
}

.rating {
  background: #48c479;
  color: white;
  padding: 2px 8px;
  border-radius: 5px;
  font-size: 12px;
}

/* ---------- MOBILE ---------- */

@media (max-width: 600px) {
  .hero h1 {
    font-size: 20px;
  }

  .nav-links {
    display: none;
  }
}
</style>
</head>

<body>

<!-- NAVBAR -->
<div class="nav">
  <div class="logo">Foodie</div>
  <div class="nav-links">
    <a href="#">Home</a>
    <a href="login.jsp">Login</a>
    <a href="cart.jsp">Cart</a>
    <a href="#">Profile</a>
  </div>
</div>

<!-- HERO -->
<div class="hero">
  <h1>Discover the best food near you</h1>
  <p>Order from your favorite restaurants</p>
</div>

<!-- RESTAURANT CARDS -->
<div class="container">

<%

List<Restaurant> allRestaurants=(List<Restaurant>)request.getAttribute("allRestaurants");

for(Restaurant r: allRestaurants) {
	
	%>
	<a href="menu?restaurantId=<%=r.getRestaurantId()%>">
	
	<div class="box">
	    <img src=<%= r.getImageUrl()%> alt="">
	    <div class="card-content">
	      <div class="res-name"><%= r.getName() %></div>
	      <div class="desc"><%= r.getCuisineType()%></div>
	      <div class="address"><%= r.getAddress()%></div>
	      <div class="info">
	        <span class="rating"><%= r.getRating() %> ★</span>
	        <span><%=r.getETA()%></span>
	      </div>
	    </div>
	  </div>
	
	</a>
  
  <% 
}

%>>
  
  

  

</div>

</body>
</html>
    