<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 14/09/23
  Time: 1:17 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product Form</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
  <h1>Product Form</h1>
  <h1>Welcome, ${user}</h1>
  <div class="error">
      ${param.errMsg}
  </div>
  <form action="addProduct.do" method="post">
      Name <input type="text" name="name" /> <br />
      Price <input type="number" name="price" /> <br />
      Quantity <input type="number" name="qty" /> <br />
      <button type="submit">Add Product</button>
  </form>
  <a href="cart.jsp">Cart</a>
  <a href="logout.do">Logout</a>
</body>
</html>
