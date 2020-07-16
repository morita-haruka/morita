<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果表示</title>
</head>
<body>
<h4>検索結果表示</h4>

<c:forEach var="templist" items="${resultlist}">
	<c:out value="${templist.date}"></c:out>:
	<c:out value="${templist.bodyTemp}"></c:out>℃<br>
</c:forEach>
<br/>
<a href="/BodyTempKadai/">トップへ</a>
</body>
</body>
</html>