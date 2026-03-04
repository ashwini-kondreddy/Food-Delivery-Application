<img width="1920" height="1008" alt="Screenshot 2026-03-04 194823" src="https://github.com/user-attachments/assets/56a425b3-eac8-40db-bced-d9405aa5f0ff" /><img width="1920" height="1008" alt="Screenshot 2026-03-04 194718" src="https://github.com/user-attachments/assets/8b172207-f4a7-4a04-8451-e30b94236d5f" />🍽️ Food Delivery Web Application

A dynamic Food Delivery Web Application built using Java, JSP, Servlets, JDBC, MySQL, HTML, and CSS.
This project demonstrates backend connectivity, session handling, database integration, and complete order workflow management.

📌 Project Overview

This application allows users to:

1)View available restaurants<br>
2)Browse menus<br>
3)Register & Login<br>
4)Add items to cart<br>
5)Place orders<br>
6)Stores order details in database<br>

All data (restaurants, menus, users, orders) is dynamically fetched and stored in MySQL Database.<br>

🚀 Step-by-Step Application Flow<br>
1️⃣ Restaurant Listing Page<br>

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194650" src="https://github.com/user-attachments/assets/6fdab977-8fbe-4869-864a-ead304d5275d" />


🔹 Description:<br>

Displays list of available restaurants.

Each restaurant shows:
1)Restaurant Image (stored as image URL in DB)<br>
2)Restaurant Name<br>
3)Cuisine Type<br>
4)Rating<br>

🔹 Data Source:<br>

All restaurant data is fetched dynamically from MySQL Database using JDBC.<br>

Data includes:<br>

a)restaurantId<br>
b)name<br>
c)imageUrl<br>
d)cuisineType<br>
e)rating<br>

2️⃣ Menu Page<br>

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194718" src="https://github.com/user-attachments/assets/04f88d8e-6634-448c-92e4-364fe14b1f75" />


🔹 Description:<br>
Displays menu items based on selected restaurant.<br>
Each item includes:<br>

1)Item Image<br>
2)Item Name<br>
3)Description<br>
4)Price<br>
5)Add to Cart Button<br>

🔹 Data Source:<br>

-->Menu data is fetched from MySQL using restaurantId.<br>
-->Each menu item is linked to its respective restaurant.<br>

3️⃣ User Registration & Login<br>

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194731" src="https://github.com/user-attachments/assets/7925b8c7-9e99-476b-aedd-a2f6b2c90079" />


🔹 Registration Flow:<br>

User fills registration form.<br>

On submission:<br>
->User details are stored in MySQL Database.<br>
->Data includes:<br>
&nbsp;&nbsp;&nbsp;1)Name<br>
&nbsp;&nbsp;&nbsp;2)Email<br>
&nbsp;&nbsp;&nbsp;3)Phone<br>
&nbsp;&nbsp;&nbsp;4)Address<br>
&nbsp;&nbsp;&nbsp;5)Password<br>

🔹 Login Flow:<br>

&nbsp;&nbsp;&nbsp;a)User logs in using registered email & password.<br>

&nbsp;&nbsp;&nbsp;b)Authentication is validated using database records.<br>

&nbsp;&nbsp;&nbsp;c)Session is created after successful login.<br>

&nbsp;&nbsp;&nbsp;d)Only logged-in users can place orders.<br>

4️⃣ Add to Cart Functionality<br>

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194746" src="https://github.com/user-attachments/assets/cfaf14be-467d-4c6c-9ae0-a8b3ee412882" />

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194812" src="https://github.com/user-attachments/assets/96482366-2fc4-4522-b4f9-6fa6529461a9" />

🔹 Description:<br>
Clicking Add to Cart stores the item in session-based cart.<br>

Cart features:<br>
1)Increase item quantity<br>
2)Decrease item quantity<br>
3)Remove item<br>
4)View total price<br>
5)Proceed to Checkout<br>

🔹 Implementation:<br>

a)Cart is maintained using Session Management.<br>
b)Quantity updates dynamically affect total amount.<br>

5️⃣ Checkout & Order Confirmation<br>

<img width="1920" height="1008" alt="Screenshot 2026-03-04 194823" src="https://github.com/user-attachments/assets/e09b4d31-3f0c-4a31-823e-f532833b1ed3" />


🔹 Description:<br>
After clicking Proceed to Checkout:<br>
1)Order is stored in database.<br>
2)A Unique Order ID is generated for each order.<br>

🔹 Database Storage:<br>
Each order includes:<br>
-->orderId (Auto-generated / Unique)<br>
-->userId<br>
-->restaurantId<br>
-->orderDate<br>
-->totalAmount<br>

Order items stored in separate order_items table<br>

🛠️ Technologies Used<br>
1)Java<br>
2)JSP<br>
3)Servlets<br>
4)JDBC<br>
5)MySQL<br>
6)HTML<br>
7)CSS<br>
8)Apache Tomcat<br>

<br>
<br>


🔐 Key Features Implemented<br>

✔ MVC Architecture Concept<br>
✔ Database Connectivity using JDBC<br>
✔ Session Management<br>
✔ Dynamic Data Rendering<br>
✔ Unique Order ID Generation<br>
✔ Cart Quantity Update System<br>
✔ Complete End-to-End Order Flow<br>

🎯 Learning Outcomes<br>

1)Real-time database integration
2)Session handling in Servlets
3)CRUD operations
4)Order workflow management
5)Full-stack development basics
