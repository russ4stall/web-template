<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<%--@elvariable id="action" type="com.russ4stall.jorb.actions.RegisterAction"--%>

<html>
<head>
<app:head-common title="Register"/>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="center-block title" >
            <h2>Register</h2>
        </div>
    </div>

    <div class="center-block user-form">
        <c:forEach items="${action.fieldErrors}" var="error">
            <span class="text-danger">${error.value}</span><br/>
        </c:forEach>
        <form role="form" action="${pageContext.request.contextPath}/register" method="post">
            <div class="form-group">
                <input class="form-control" id="name-field" name="name" type="text" value="${action.name}" placeholder="NAME">
            </div>
            <div class="form-group">
                <input class="form-control" id="email-field" name="email" type="email" value="${action.email}" placeholder="EMAIL">
            </div>
            <div class="form-group">
                <input class="form-control" id="password-field" name="password" type="password" placeholder="PASSWORD">
            </div>
            <div class="form-group">
                <input class="form-control" id="confirm-password-field" name="confirmPassword" type="password" placeholder="RETYPE PASSWORD">
            </div>
            <button type="submit" class="btn btn-primary btn-block btn-lg">SUBMIT</button>
            <a class="btn btn-danger btn-block btn-lg" href="${pageContext.request.contextPath}/login">CANCEL</a>

        </form>
    </div>
</div>
</body>
</html>
