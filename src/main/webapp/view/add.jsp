<%@ page import="com.jeorgius.shop.entities.Item" %><%--
  Created by IntelliJ IDEA.
  User: Georgy
  Date: 28.08.2018
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <%@include file="controls/head.jsp"%>
    <title>Shop</title>
</head>
<body>
<h1>Add new goods(items)</h1>
<form method="post">
    <input type="text" name="title" placeholder="Title">
    <%--<input type="text" name="category" placeholder="Category">--%>
    <select name="subcategory">
        <optgroup label="clothes">
            <option>summer</option>
            <option>winter</option>
        </optgroup>
        <optgroup label="electronics">
            <option>laptops</option>
            <option>smartphones</option>
        </optgroup>
    </select>
    <input type="number" name="quantity" placeholder="Quantity">
    <input type="number" name="price" placeholder="Price">
    <input type="submit">
    <br/><br/>

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
</form>
</body>
</html>
