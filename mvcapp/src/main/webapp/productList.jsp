<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 14/09/23
  Time: 11:23 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>

<h1>Welcome, ${user}</h1>
    <h1>Product List</h1>
    <form action="addToCart.do" method="post">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>PRICE</th>
            <th>Select</th>
        </tr>
        <c:forEach items="${products}" var="p">
            <tr>
                <td>${p.id}</td>
                <td>${p.name}</td>
                <td>${p.price}</td>
                <td><input type="checkbox" name="items" value="${p.id}"/> </td>
            </tr>
        </c:forEach>
    </table>
        <button type="submit">Add to Cart</button>
    </form>
<a href="cart.jsp">Cart</a>
<a href="logout.do">Logout</a>
</body>
</html>
