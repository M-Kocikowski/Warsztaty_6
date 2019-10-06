<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 15.09.2019
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<div style="margin: 20px 40%">
    <form:form method="post" modelAttribute="appUser">
        <table>
            <tr>
                <td>Email:</td>
                <td>
                    <form:input path="email"/>
                </td>
                <td>
                    <form:errors path="email"/>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <form:password path="password"/>
                </td>
                <td>
                    <form:errors path="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" style="text-align: right">
                    <input type="submit" value="Login">
                </td>
            </tr>
        </table>
    </form:form>
    <a href="<c:url value="/register"/>">Register new user</a>
</div>
</body>
</html>