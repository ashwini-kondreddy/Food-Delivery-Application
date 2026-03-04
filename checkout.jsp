<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout</title>

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

.checkout-container {
  background: #fff;
  width: 95%;
  max-width: 600px;
  padding: 30px;
  border-radius: 15px;
  box-shadow: 0 15px 30px rgba(0,0,0,0.15);
}

.checkout-title {
  text-align: center;
  margin-bottom: 25px;
}

.form-group {
  margin-bottom: 18px;
}

label {
  display: block;
  font-weight: bold;
  margin-bottom: 6px;
}

input, textarea, select {
  width: 100%;
  padding: 10px;
  border-radius: 8px;
  border: 1px solid #ccc;
  font-size: 14px;
}

textarea {
  resize: none;
  height: 80px;
}

.total-section {
  margin-top: 20px;
  padding: 15px;
  background: #f8f8f8;
  border-radius: 10px;
  font-size: 18px;
  font-weight: bold;
  display: flex;
  justify-content: space-between;
}

.place-order-btn {
  margin-top: 25px;
  width: 100%;
  padding: 14px;
  border: none;
  border-radius: 10px;
  background: #3da455;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: 0.3s;
}

.place-order-btn:hover {
  background: #1e7e34;
}

@media(max-width:480px){
  .checkout-container{
    padding: 20px;
  }
}
</style>
</head>

<body>

<div class="checkout-container">
  <h2 class="checkout-title">🧾 Checkout</h2>

  <form action="checkout" method="post">

    <div class="form-group">
      <label>Full Name</label>
      <input type="text" name="name" required>
    </div>

    <div class="form-group">
      <label>Mobile Number</label>
      <input type="tel" name="mobile" required>
    </div>

    <div class="form-group">
      <label>Delivery Address</label>
      <textarea name="address" required></textarea>
    </div>

    <div class="form-group">
      <label>Payment Mode</label>
      <select name="paymentMode" required>
        <option value="">Select Payment Mode</option>
        <option value="COD">Cash on Delivery</option>
        <option value="UPI">UPI</option>
        <option value="Card">Credit / Debit Card</option>
        <option value="NetBanking">Net Banking</option>
      </select>
    </div>

    <!-- Total Price Section -->
    <div class="total-section">
      <span>Total Amount:</span>
      <span>₹ 700</span>  <!-- Replace with dynamic value in JSP -->
    </div>

    <button type="submit" class="place-order-btn">
      🚀 Place Order
    </button>

  </form>
</div>

</body>
</html>