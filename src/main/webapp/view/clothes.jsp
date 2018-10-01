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
    <title>Clothes</title>
</head>
<body>
<h1>Clothes</h1>
    <%@ include file="controls/navigation.jsp"%>

    <div><a href="/clothes/winter">Winter Clothes</a></div>
    <div><a href="/clothes/summer">Summer Clothes</a></div>
    <div><a href="/add">Add new item</a></div>

    <br/>

    <%@include file="controls/storebody.jsp"%>
</body>
</html>
