🍽️ Food Delivery Web Application

A dynamic Food Delivery Web Application built using Java, JSP, Servlets, JDBC, MySQL, HTML, and CSS.
This project demonstrates backend connectivity, session handling, database integration, and complete order workflow management.

📌 Project Overview

This application allows users to:

1)View available restaurants<br>
2)Browse menus
3)Register & Login
4)Add items to cart
5)Place orders
6)Stores order details in database

All data (restaurants, menus, users, orders) is dynamically fetched and stored in MySQL Database.

🚀 Step-by-Step Application Flow
1️⃣ Restaurant Listing Page

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194650" src="https://github.com/user-attachments/assets/6fdab977-8fbe-4869-864a-ead304d5275d" />


🔹 Description:

Displays list of available restaurants.

Each restaurant shows:

Restaurant Image (stored as image URL in DB)

Restaurant Name

Cuisine Type

Rating

Estimated Delivery Time

🔹 Data Source:

All restaurant data is fetched dynamically from MySQL Database using JDBC.

Data includes:

restaurantId

name

imageUrl

cuisineType

rating

ETA

2️⃣ Menu Page

📷 (Menu Page UI Image Here)

🔹 Description:

Displays menu items based on selected restaurant.

Each item includes:

Item Image

Item Name

Description

Price

Add to Cart Button

🔹 Data Source:

Menu data is fetched from MySQL using restaurantId.

Each menu item is linked to its respective restaurant.

3️⃣ User Registration & Login

📷 (Login & Registration UI Image Here)

🔹 Registration Flow:

User fills registration form.

On submission:

User details are stored in MySQL Database.

Data includes:

Name

Email

Phone

Address

Password

🔹 Login Flow:

User logs in using registered email & password.

Authentication is validated using database records.

Session is created after successful login.

Only logged-in users can place orders.

4️⃣ Add to Cart Functionality

📷 (Cart UI Image Here)

🔹 Description:

Clicking Add to Cart stores the item in session-based cart.

Cart features:

Increase item quantity

Decrease item quantity

Remove item

View total price

Proceed to Checkout

🔹 Implementation:

Cart is maintained using Session Management.

Quantity updates dynamically affect total amount.

5️⃣ Checkout & Order Confirmation

📷 (Order Confirmation UI Image Here)

🔹 Description:

After clicking Proceed to Checkout:

Order is stored in database.

A Unique Order ID is generated for each order.

Order confirmation page displays:

Order ID

Ordered Items

Total Amount

Delivery Details

🔹 Database Storage:

Each order includes:

orderId (Auto-generated / Unique)

userId

restaurantId

orderDate

totalAmount

Order items stored in separate order_items table

🛠️ Technologies Used

Java

JSP

Servlets

JDBC

MySQL

HTML

CSS

Apache Tomcat

🗄️ Database Design (Basic Tables)
1️⃣ Users Table

userId

name

email

phone

address

password

2️⃣ Restaurant Table

restaurantId

name

address

cuisineType

rating

ETA

imageUrl

isAvailable

3️⃣ Menu Table

menuId

restaurantId

itemName

description

price

imageUrl

4️⃣ Orders Table

orderId (Unique)

userId

restaurantId

totalAmount

orderDate

5️⃣ Order_Items Table

orderItemId

orderId

menuId

quantity

itemTotal

🔐 Key Features Implemented

✔ MVC Architecture Concept
✔ Database Connectivity using JDBC
✔ Session Management
✔ Dynamic Data Rendering
✔ Unique Order ID Generation
✔ Cart Quantity Update System
✔ Complete End-to-End Order Flow

🎯 Learning Outcomes

Real-time database integration

Session handling in Servlets

CRUD operations

Order workflow management

Full-stack development basics
