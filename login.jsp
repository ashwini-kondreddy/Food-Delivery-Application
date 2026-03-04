<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Login</title>

<style>

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  font-family: "Segoe UI", sans-serif;
}

body {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #ffecd2, #fcb69f);
  padding: 20px;
}

.login-container {
  background: #ffffff;
  width: 100%;
  max-width: 420px;
  padding: 40px 35px;
  border-radius: 20px;
  box-shadow: 0 20px 40px rgba(0,0,0,0.15);
  transition: 0.3s ease;
}

.login-container:hover {
  transform: translateY(-5px);
}

.login-container h2 {
  text-align: center;
  margin-bottom: 30px;
  color: #8b4513;
  font-size: 28px;
  font-weight: 600;
}

.input-group {
  margin-bottom: 20px;
}

.input-group input {
  width: 100%;
  padding: 14px;
  border-radius: 10px;
  border: 1px solid #ddd;
  font-size: 15px;
  transition: 0.3s;
}

.input-group input:focus {
  border-color: #8b4513;
  outline: none;
  box-shadow: 0 0 8px rgba(139, 69, 19, 0.3);
}

.login-btn {
  width: 100%;
  padding: 14px;
  border-radius: 10px;
  border: none;
  background: #8b4513;
  color: white;
  font-size: 16px;
  cursor: pointer;
  margin-top: 10px;
  transition: 0.3s;
}

.login-btn:hover {
  background: #6d3410;
}

.register-btn {
  width: 100%;
  padding: 12px;
  border-radius: 10px;
  border: 2px solid #8b4513;
  background: transparent;
  color: #8b4513;
  font-size: 15px;
  cursor: pointer;
  margin-top: 15px;
  transition: 0.3s;
}

.register-btn:hover {
  background: #8b4513;
  color: white;
}

.error-message {
  margin-top: 15px;
  padding: 10px;
  background: #ffe6e6;
  color: #cc0000;
  border-radius: 8px;
  font-size: 14px;
  text-align: center;
}

/* ---------- Responsive ---------- */

@media (max-width: 768px) {
  .login-container {
    padding: 35px 25px;
  }
}

@media (max-width: 480px) {
  .login-container {
    padding: 30px 20px;
    border-radius: 15px;
  }

  .login-container h2 {
    font-size: 22px;
  }

  .input-group input {
    padding: 12px;
  }
}

</style>
</head>

<body>

<div class="login-container">
  <h2>Welcome Back</h2>

  <form action="LoginServlet" method="post">
    <div class="input-group">
      <input type="email" name="email" placeholder="Enter Email" required>
    </div>

    <div class="input-group">
      <input type="password" name="password" placeholder="Enter Password" required>
    </div>

    <button type="submit" class="login-btn">Login</button>
  </form>

  <%
    String error = request.getParameter("error");
    if (error != null) {
  %>
      <div class="error-message"><%= error %></div>
  <%
    }
  %>

  <form action="register.jsp">
    <button type="submit" class="register-btn">Create Account</button>
  </form>
</div>

</body>
</html>