<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 06.10.2019
  Time: 01:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>User Details</title>
</head>
<body>
    <jsp:include page="header.jsp"/>
    <h2>User Page: ${user}</h2>
    <c:if test="${not empty userTweets}">
        <h2 style="text-align: center">User's newest tweets</h2>
        <table style="text-align: center; margin: 0 10%; width: 80%">
            <tr>
                <th style="width: 70%">Text</th>
                <th style="width: 30%">Posted On</th>
            </tr>
            <c:forEach items="${userTweets}" var="tweet">
                <tr>
                    <td><a href="/app/tweet/${tweet.id}">${tweet.text}</a></td>
                    <td>${tweet.created}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</body>
</html>
