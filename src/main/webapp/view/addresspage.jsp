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
    <title>Set Address</title>
</head>
<body>
<h1>Add new goods(items)</h1>
<form method="post" action="/order/setcreds">
    <select name="payMethod">
        <option>By Cash</option>
        <option>By Card</option>
        <option>By Online Services</option>
    </select>
    <h2>Enter your address:</h2>
    <input type="text" name="country" placeholder="Country"><br/>
    <input type="text" name="city" placeholder="City"><br/>
    <input type="number" name="index" placeholder="Index"><br/>
    <input type="submit">
    <br/><br/>
</form>
</body>
</html>
