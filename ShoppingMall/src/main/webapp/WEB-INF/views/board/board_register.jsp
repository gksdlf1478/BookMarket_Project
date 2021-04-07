<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>
<head>
	<title>Home</title>
</head>
<body>		
	<form role="form" method="post">
		<div class="form-group">
			<input type="text" style="width:300px"  name="boardname" class="form-control" placeholder="제목을 입력하세요">
		</div>
		
		<div class="form-group">
			<textarea class="form-control" style="width:300px" name="boardtext" id="boardtext"></textarea>
		</div>
		<div>
			<input type="text" name="boardreguser" placeholder="작성자를 입력하세요">
		</div>
		
		<div class="box-footer" align="center">
			<button type="submit" class="mng-button">작성</button>
		</div>		
	</form>
		
<script>	
	$(document).ready(function() {
				
	})
</script>
</body>
</html>
