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

<c:forEach var="each" items="${users}">
    <p>${each.name}</p>
</c:forEach>

</body>
</html>
