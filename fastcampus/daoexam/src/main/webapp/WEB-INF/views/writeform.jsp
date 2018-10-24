<%@ page language="java" contentType="text/html; charset=EUC-KR"
         pageEncoding="EUC-KR" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>writeform</title>
</head>
<body>
<h1>writeform</h1>
<br>

<form method="post" action="/boards">
    name : <input type="text" name="name"><br>
    title : <input type="text" name="title"><br>
    content : <textarea name="content" cols="50" rows="6"></textarea>
    <br>
    <input type="submit">
</form>
</body>
</html>

