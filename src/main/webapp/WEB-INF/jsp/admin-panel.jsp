<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>

<jsp:include page="_header.jsp"/>

<fmt:setLocale value="en_US" scope="session"/>

<div class="page-title">User List</div>

<div>Total Users Count: ${userCount} </div>

<table class="table">
    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Email</th>
        <th>Role</th>
        <%--<th>Delete</th>--%>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td>${user.role}</td>
            <%--<td><a href="/shopping-cart/user/delete?id=${user.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
</table>

<jsp:include page="_footer.jsp"/>

</body>
</html>