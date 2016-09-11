<%--
  Created by IntelliJ IDEA.
  User: home
  Date: 2016-09-10
  Time: 오후 9:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>board list page.</title>
</head>
<body>
this is boradlist page.

<c:forEach var="user" items="${users}">
    <p>${user.name}</p>
</c:forEach>

<c:forEach var="article" items="${articleList}">
    <p>${article.title}</p>
</c:forEach>

</body>
</html>
