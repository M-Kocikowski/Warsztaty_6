<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 06.10.2019
  Time: 09:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Tweet Page</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h2 style="text-align: center">${tweet.text}</h2>
    <p>Posted by: ${tweet.user}</p>
    <p>Posted on: ${tweet.created}</p>
</body>
</html>
