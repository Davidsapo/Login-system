<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Info</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>


<jsp:include page="_header.jsp"/>

<div class="page-title">Welcome</div>

<div class="account-container">
    <ul>
        <li>First Name: ${user.firstName}</li>
        <li>Last Name: ${user.lastName}</li>
        <li>Email: ${user.email} </li>
        <li>Role: ${user.role} </li>
    </ul>
</div>

<jsp:include page="_footer.jsp"/>

</body>
</html>