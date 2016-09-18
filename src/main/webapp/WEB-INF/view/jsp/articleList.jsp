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
    <link rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <script src="/js/jquery-3.1.0.min.js"></script>
    <script src="/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <title>board list page.</title>
</head>
<body>
this is boradlist page.

<div class="table-responsive">
    <table class="table table-bordered table-striped table-hover table-condensed">
        <thead>
        <th>No.</th>
        <th>Title</th>
        </thead>
        <tbody>
        <c:forEach var="article" items="${articleList}">
            <tr>
                <td>${article.seqNo}</td>
                <td>${article.title}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
