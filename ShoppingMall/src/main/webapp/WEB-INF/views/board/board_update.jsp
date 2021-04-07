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
	<form role="form" method="POST" action="${contextPath}/board/update">
		<table border="1" style="border-collapse:collapse; width:500px; text-align: center">
			<tr>
				<td class="detail-title">제목</td>				
				<td colspan="3" class="detail-label"><input type="text" name="boardname" class="form-control" placeholder="${detail_data.boardname}"></td>
			</tr>
			<tr class="detail-tr-center">
				<td class="detail-title">작성자</td>
				<td colspan="3" class="detail-label"><input type="text" name="boardreguser" class="form-control" placeholder="${detail_data.boardreguser}"></td>
			</tr>
			<tr class="detail-tr">
				<td class="detail-title">수정일</td>
				<td class="detail-label"><input type="text" name="boardregdate" placeholder="${detail_data.boardregdate}" readonly ></td>
				<td class="detail-title">조회수</td>
				<td class="detail-label"><input type="text" name="boardregcnt" placeholder="${detail_data.boardreadcnt}" readonly ></td>
			</tr>
			<tr>
				<td class="detail-title">글내용</td>
				<td colspan="4" ><input type="text" name="boardtext" class="form-control" placeholder="${detail_data.boardtext}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="bno" class="form-control" placeholder="${detail_data.bno}"></td>
			</tr>
		</table>
		<button type="submit">수정</button>
		<button type="reset" >취소</button>
	</form>

		
<script>	
	$(document).ready(function() {
				
	})
</script>
</body>
</html>
