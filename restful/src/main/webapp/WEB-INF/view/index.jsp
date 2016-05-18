<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
${name.publicationDate}

<form action="jsonfeed.json" method="post">
	<button type="submit">提交</button>
</form>

<c:forEach items="${items}" var="a">
	date:<input type="text" value="${a.publicationDate}">
</c:forEach>
</body>
</html>