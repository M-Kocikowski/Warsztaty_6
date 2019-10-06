<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: marcin
  Date: 20.09.2019
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
<div style="margin: 20px 40%">
    <form:form method="post" modelAttribute="appUser">
        <table>
            <tr>
                <td>First Name:</td>
                <td>
                    <form:input path="firstName"/>
                </td>
                <td>
                    <form:errors path="firstName"/>
                </td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td>
                    <form:input path="lastName"/>
                </td>
                <td>
                    <form:errors path="lastName"/>
                </td>
            </tr>
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
                    <input type="submit" value="Register">
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
