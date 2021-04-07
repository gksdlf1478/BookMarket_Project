<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%@ page session="false" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<html>
<head>
	<title>Login</title>
</head>
<body>
		<div style="float:right">
			<button onClick="location.href='${contextPath}/board/register'">글작성</button>
		</div>
		<table class="table m-b-0 table-bordered" style="width: 100%; text-align: center">
			<thead>
				<tr>
					<th style="width: 10%; ">No</th>
					<th style="width: 30%; ">제목</th>
					<th style="width: 20%; ">작성자</th>
					<th style="width: 20%; ">작성일</th>
					<th style="width: 20%; ">조회수</th>
				</tr>
			</thead>
			<tbody id="board_list_table">
				<c:forEach var="board" items="${boardlist }">
				 	<tr onClick="location.href='detail?bno=${board.bno}'">
					 	<td>${board.bno}</td>
					 	<td>${board.boardname}</td>
					 	<td>${board.boardreguser}</td>
					 	<td>${board.boardregdate}</td>
					 	<td><span class="badge">${board.boardreadcnt }</span></td>					 
				 	</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="float:none;">
			<input type="text" id="boardsearch" class="form-control">
			<button>검색</button>
		</div>

<script>	
	$(document).ready(function() {
// 				document.getElementById("board_list_table").innerHTML = year+"."+ mon;
				
	})
</script>
</body>
</html>
