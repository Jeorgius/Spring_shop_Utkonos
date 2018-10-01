<%@ page import="com.jeorgius.shop.entities.orders.Purchase" %>
<%@ page import="com.jeorgius.shop.entities.orders.UserAddress" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%@include file="controls/head.jsp"%>
    <title>Clothes</title>
</head>
<body>
<div class="store">
        <div class="item">
            <h3>Total price: $${purchase.total}</h3>
            <div>Pay Method: ${purchase.payMethod}</div>
            <h3>Address:</h3>
            <div>Country: ${address.country}</div>
            <div>City: ${address.city}</div>
            <div>Index: ${address.index}</div>
        </div>
        <br/>
</div>
<h1>Thank you! Have a nice time!</h1>
</body>
</html>