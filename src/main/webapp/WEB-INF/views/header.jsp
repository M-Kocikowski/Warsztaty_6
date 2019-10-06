<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 01.10.2019
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="height: 3rem; background-color: black; padding: 10px 30px">
    <h2 style="text-align: right; color: white; margin: 0">Hello, ${sessionScope.get("appUser").firstName}</h2>
    <a href="<c:url value="/"/>" style="color: white">Main Page</a>
    <a href="<c:url value="/app/logout"/>" style="color: white; padding-left: 5px">Logout</a>
</div>
</body>
</html>
