<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 15.09.2019
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Main</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="margin: 20px 30%">
<form:form method="post" modelAttribute="newTweet">
    <form:textarea path="text" rows="10" cols="70"/>
    <br><form:errors path="text"/>
    <br>
    <input type="submit" value="Post New Tweet">
</form:form>
</div>
<c:if test="${not empty allTweets}">
    <h2 style="text-align: center">Newest tweets</h2>
    <table style="text-align: center; margin: 0 10%; width: 80%">
        <tr>
            <th style="width: 60%">Text</th>
            <th style="width: 20%">User</th>
            <th style="width: 20%">Posted On</th>
        </tr>
        <c:forEach items="${allTweets}" var="tweet">
            <tr>
                <td><a href="/app/tweet/${tweet.id}">${tweet.text}</a></td>
                <td><a href="/app/user/${tweet.user.id}">${tweet.user}</a></td>
                <td>${tweet.created}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
