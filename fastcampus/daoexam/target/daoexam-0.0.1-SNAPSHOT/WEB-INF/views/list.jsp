<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list</title>
</head>
<body>
<h1>list</h1>
<br>

<c:forEach items="${boards}" var="board">
    ${board.title}<br>
</c:forEach>
<br>

<a href="/boards/writeform">±Û¾²±â</a>
</body>
</html>

