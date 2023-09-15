<%--
  Created by IntelliJ IDEA.
  User: banuprakash
  Date: 15/09/23
  Time: 10:00 am
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Chat</title>
</head>
<body>
    Welcome, ${user} <br />
    <form action="chat.do" method="post">
        Message <input type="text" name="msg"> <br />
        <button type="submit">Send Message</button>
    </form>
    <c:forEach items="${messages}" var="message">
        ${message} <br />
    </c:forEach>
    <a href="index.jsp">Back</a>
</body>
</html>
