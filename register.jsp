<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style>
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: Arial, sans-serif;
}

body {
    min-height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    background: linear-gradient(135deg, #ffecd2, #fcb69f);
    padding: 20px;
}

.register-container {
    background: #ffffff;
    width: 100%;
    max-width: 400px;
    padding: 30px 25px;
    border-radius: 12px;
    box-shadow: 0 10px 25px rgba(0,0,0,0.15);
}

.register-container h2 {
    text-align: center;
    margin-bottom: 25px;
    color: #333;
}

.form-group {
    margin-bottom: 18px;
}

label {
    display: block;
    margin-bottom: 6px;
    font-size: 14px;
    font-weight: bold;
    color: #444;
}

input {
    width: 100%;
    padding: 10px;
    border-radius: 6px;
    border: 1px solid #ccc;
    font-size: 14px;
    transition: 0.3s;
}

input:focus {
    border-color: #ff7e5f;
    outline: none;
    box-shadow: 0 0 5px rgba(255,126,95,0.3);
}

.btn {
    width: 100%;
    padding: 12px;
    background-color: #ff7e5f;
    border: none;
    border-radius: 6px;
    color: white;
    font-size: 16px;
    cursor: pointer;
    transition: 0.3s;
}

.btn:hover {
    background-color: #eb5e3f;
}

.login-link {
    text-align: center;
    margin-top: 18px;
    font-size: 14px;
}

.login-link a {
    text-decoration: none;
    color: #ff7e5f;
    font-weight: bold;
}

@media (min-width: 600px) {
    .register-container {
        max-width: 450px;
        padding: 35px;
    }
}

@media (min-width: 992px) {
    .register-container {
        max-width: 500px;
        padding: 40px;
    }
}
</style>

</head>
<body>

<div class="register-container">
    <h2>Create Account</h2>

    <form action="RegisterServlet" method="post">

    <div class="form-group">
        <label>Name</label>
        <input type="text" name="name" required>
    </div>

    <div class="form-group">
        <label>Email</label>
        <input type="email" name="email" required>
    </div>

    <div class="form-group">
        <label>Phone Number</label>
        <input type="tel" name="phonenumber" required>
    </div>

    <div class="form-group">
        <label>City</label>
        <input type="text" name="address" required>
    </div>

    <div class="form-group">
        <label>Password</label>
        <input type="password" name="password" required>
    </div>

    <button type="submit" class="btn">Register</button>

</form>

    <div class="login-link">
        Already have an account? <a href="login.jsp">Login</a>
    </div>
</div>

</body>
</html>