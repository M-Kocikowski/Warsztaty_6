<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <div style="margin: 20px 5%">
        <form:form method="post" modelAttribute="comment">
            <form:textarea path="text" rows="3" cols="30"/>
            <br><form:errors path="text"/>
            <br>
            <input type="submit" value="Add a comment">
        </form:form>
    </div>
    <c:if test="${not empty tweetComments}">
        <h2 style="text-align: center">Comments</h2>
        <table style="text-align: center; margin: 0 20%; width: 60%">
            <tr>
                <th style="width: 50%">Comment</th>
                <th style="width: 25%">User</th>
                <th style="width: 25%">Commented On</th>
            </tr>
            <c:forEach items="${tweetComments}" var="comment">
                <tr>
                    <td>${comment.text}</td>
                    <td><a href="/app/user/${comment.user.id}">${comment.user}</a></td>
                    <td>${comment.created}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${empty tweetComments}">
        <h2 style="text-align: center">No Comments</h2>
    </c:if>
</body>
</html>
