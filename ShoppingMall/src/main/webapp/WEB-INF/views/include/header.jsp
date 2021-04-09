<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>
	<div style="text-align: center">
		<h3>온라인 서점</h3>
	</div>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	    <!-- Brand/logo -->
	    <a class="navbar-brand" href="${contextPath}/">
	        <img src="${contextPath}/resources/images/book_logo.png" alt="logo" style="width:40px;">
	    </a>
	  
	  <!-- Links -->
	    <ul class="navbar-nav nav-fill w-100"> <!-- nav 간격을 균일하게 w-100 -->
			<li class="nav-item">
			    <a class="nav-link" href="${contextPath}/member/login">로그인</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="${contextPath}/member/join">회원가입</a>
			</li>
			<li class="nav-item">
			    <a class="nav-link" href="#">Link 3</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">Link 3</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="#">사용자 : ${login.member_nickname }</a>
			</li>
	    </ul>
	</nav>
</body>