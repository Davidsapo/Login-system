<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>

<body>

<jsp:include page="_header.jsp"/>

<div class="page-title">Registration</div>

<div class="login-container">

    <form:form method="POST" modelAttribute="user">
        <table align="center">

            <tr>
                <td><label>First Name: </label></td>
                <td><form:input cssStyle="font-size: 18px" path="firstName"/></td>
            </tr>
            <tr>
                <td><label>Last Name: </label></td>
                <td><form:input cssStyle="font-size: 18px" path="lastName"/></td>
            </tr>
            <tr>
                <td><label for="Email">Email: </label></td>
                <td><form:input cssStyle="font-size: 18px" path="email"/></td>
            </tr>
            <tr>
                <td><label for="password">Password: </label></td>
                <td><form:input type="password" cssStyle="font-size: 18px" path="password"/></td>
            </tr>
            <tr>
                <td colspan="3">
                    <style>
                        button[type="submit"] {
                            font-size: 18px;
                            font-family: "Arial Rounded MT Bold", Arial, Helvetica, sans-serif
                        }
                    </style>
                    <button type="submit" value="Register">Register</button>
                </td>
            </tr>
        </table>
    </form:form>
</div>

<br/>
<br/>

Go back to <a href="/login-app/">Home</a>

<jsp:include page="_footer.jsp"/>
</body>
</html>