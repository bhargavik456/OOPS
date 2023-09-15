<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>MVC Application</title>
</head>
<body>
    <h1>MVC Application</h1>
<br/>
    <h1>Welcome, ${user}</h1>
    <div class="message">
        ${param.msg}
    </div>
<a href="hello-servlet">Hello Servlet</a> <br />
<a href="getProducts.do">Get Products</a> <br />
<a href="productForm.jsp">Add Product</a> <br />
<a href="cart.jsp">Cart</a> <br />
    <a href="chat.jsp">Chat</a> <br />
    <a href="logout.do">Logout</a>
</body>
</html>