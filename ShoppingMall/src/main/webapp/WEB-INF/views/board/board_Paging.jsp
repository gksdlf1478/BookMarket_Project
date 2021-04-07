<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<style>
	h2 {
		text-align: center;
	}
	table {
		width: 100%;
	}
	#outter {
		display: block;
		width: 60%;
		margin: auto;
	}
	a {
		text-decoration: none;
	}
</style>
<script>
	function selChange() {
		var sel = document.getElementById('cntPerPage').value;
		location.href="${contextPath}/board/boardListPaging?nowPage=${paging.nowPage}&cntPerPage="+sel;
	}
	
	
</script>
<body>
<h2>게시판</h2>

<div id="outter">
	<div style="float:left">
		<input type="button" value="글쓰기" style="float: right;" onclick="location.href='${contextPath}/board/register'">
	</div>
	<div style="float: right;">
		<select id="cntPerPage" name="sel" onchange="selChange()">
			<option value="5"
				<c:if test="${paging.cntPerPage == 5}">selected</c:if>>5줄 보기</option>
			<option value="10"
				<c:if test="${paging.cntPerPage == 10}">selected</c:if>>10줄 보기</option>
			<option value="15"
				<c:if test="${paging.cntPerPage == 15}">selected</c:if>>15줄 보기</option>
			<option value="20"
				<c:if test="${paging.cntPerPage == 20}">selected</c:if>>20줄 보기</option>
		</select>
	</div> <!-- 옵션선택 끝 -->
	<table border="1" style="font-size: 13px; text-align: center; border-collapse:collapse;">
		<tr>
			<td>No.</td>
			<td width="30%">제목</td>
			<td>작성자</td>
			<td width="25%">등록일</td>
			<td>조회수</td>		
		</tr>
		<c:forEach items="${boardlist }" var="list">
			<tr>
				<td>${list.bno }</td>
				<td><a href='detail?bno=${list.bno }'>${list.boardname }</a></td>
				<td>${list.boardreguser }</td>
				<td>${list.boardregdate }</td>
				<td>${list.boardreadcnt }</td>
			</tr>
		</c:forEach>
	</table>
	<div style="display: block;">
		<select id="SearchType" name="SearchType" style="float:right;position:absolute ;left: 31%;">
			<option value="boardname">제목 </option>
			<option value="boardreguser">작성자 </option>
		</select>
		<input type="text" id="SearchData" style="width:120px;float:right;position:absolute ;left: 40%;">
		<button id="Search" type="button" class="btn btn-default" style="float:right;position:absolute;left:56%;font-size: 13px;">검색</button>
	</div>
    <br>
	
	<div style="display: block; text-align: center;">		
		<c:if test="${paging.startPage != 1 }">
			<a href="${contextPath}/board/boardListPaging?nowPage=${paging.startPage - 1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
		</c:if>
		<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
			<c:choose>
				<c:when test="${p == paging.nowPage }">
					<b>${p }</b>
				</c:when>
				<c:when test="${p != paging.nowPage }">
					<a href="${contextPath}/board/boardListPaging?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p }</a>
				</c:when>
			</c:choose>
		</c:forEach>
		<c:if test="${paging.endPage != paging.lastPage}">
			<a href="${contextPath}/board/boardListPaging?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
		</c:if>
	</div>
</div>

<script>
//검색 버튼 동작
$('#Search').click(function(){ 
	var SearchType = $('#SearchType').val();
	var SearchData = $('#SearchData').val();
	$.ajax({ // DB 연동 - 데이터 조회 AJAX
		type : "POST",
		url : "${contextPath}/board/search",
		data : {
			SearchType: SearchType,
			SearchData: SearchData
		},
		dataType : 'json',
		success : function(result) {
			console.log("검색 성공");
		},
		error : function(data){
			console.log("검색 오류");
		}
	})
})
</script>
</body>
</html>