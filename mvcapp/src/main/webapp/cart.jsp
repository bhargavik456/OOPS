<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 14/09/23
  Time: 3:27 pm
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Cart, Welcome ${user}</h1>
    <c:forEach items="${cart}" var="p">
        Product : ${p}
    </c:forEach>
    <a href="logout.do">Logout</a>
</body>
</html>
