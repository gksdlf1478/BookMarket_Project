<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<nav>
<div class="topnav">
		<a class="navbar-brand" href="${pageContext.request.contextPath}">
		</a>
		<div class="topnav-right">
			<ul class="nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="${contextPath }/board/boardListPaging">게시판</a></li>
			</ul>
		</div>
	</div>
</nav>
</body>
</html>
