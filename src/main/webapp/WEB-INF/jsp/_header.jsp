<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="header-container">

    <div class="site-name">Login app</div>

    <div class="header-bar">
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <a>${pageContext.request.userPrincipal.name } </a>
            <a href="/logout">Logout</a>

        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a href="/login-app/registration">Registration</a>
            <a> </a>
            <a> </a>
            <a href="/login">Login</a>
        </c:if>
    </div>
</div>