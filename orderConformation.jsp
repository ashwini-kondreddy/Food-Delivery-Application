<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f8f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
            text-align: center;
            width: 400px;
        }

        h1 {
            color: green;
        }

        p {
            font-size: 16px;
            margin-top: 15px;
        }

        .btn {
            display: inline-block;
            margin-top: 25px;
            padding: 10px 20px;
            background-color: #ff6b6b;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        .btn:hover {
            background-color: #ff4757;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>Order Placed Successfully! 🎉</h1>
    <p>Thank you for ordering with us 🍽️</p>
    <p>Your food is being prepared and will reach you soon!</p>

    <a href="restaurant" class="btn">Back to Restaurants</a>
</div>

</body>
</html>