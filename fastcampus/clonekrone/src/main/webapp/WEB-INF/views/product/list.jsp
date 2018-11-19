<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>게시판 - 목록</title>
</head>
<body>
<a href="/product/list">모든 품목 보기</a><br>

<a href="/product/list?superiorid=1">호밀빵</a>
<a href="/product/list?superiorid=5">통밀빵</a><br><br>

<h3>상품 목록</h3>
<c:forEach items="${productList}" var="product">
    ${product.name} <br>
</c:forEach>
<c:forEach begin="0" end="${totalPage-1}" step="1" var="page">
    <a href="/product/list?start=${page}&superiorid=${superiorId}&searchWord=${searchWord}">${page+1}</a>
</c:forEach>
<br>
<form action="/product/list">
    <input type="search" name="searchWord">
    <button type="submit">검색</button>
</form>
</body>
</html>
