<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%@include file="controls/head.jsp"%>
    <title>Orders</title>
</head>
<body>
<h1>Make Order</h1>
<%@ include file="controls/navigation.jsp"%>

<form method="post" action="orders/getcreds">
    <input type="submit" value="Proceed with order" class="proceed">
</form>
<br/>
<h2>Price: $${total}</h2>

<div class="store">
    <c:forEach items="${items}" var="item">
        <div class="item">
            <h3>Title: ${item.title}</h3>
            <div class="id">${item.id}</div>
            <div>Category: ${item.category}</div>
            <div>Subcategory: ${item.subcategory}</div>
            <div>Quantity: ${item.quantity}</div>
            <div>Price: $${item.price}</div>
        </div>
        <br/>
    </c:forEach>
</div>
</body>
</html>