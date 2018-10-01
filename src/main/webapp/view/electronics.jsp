<%--
  Created by IntelliJ IDEA.
  User: Georgy
  Date: 28.08.2018
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <%@include file="controls/head.jsp"%>
    <title>Shop</title>
</head>
<body>
    <h1>Add new goods(items)</h1>
    <br/>
    <%@ include file="controls/navigation.jsp"%>
    <div><a href="/electronics/smartphones">Smartphones</a></div>
    <div><a href="/electronics/laptops">Laptops</a></div>
    <div><a href="/add">Add new item</a></div>

    <%@include file="controls/storebody.jsp"%>
</body>
</html>
