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
	<div id="board_detail">
		<div >
			<button style="margin:20px" id="board-list">  목록</button>
			<button style="margin:20px" id="board-update">수정</button>
			<button style="margin:20px" id="board-delete">삭제</button>
		</div>
		<table border="1" style="border-collapse:collapse; width:500px; text-align: center">
			<tr>
				<td class="detail-title">제목</td>
				<td colspan="3" class="detail-label">${detail_data.boardname}</td>
			</tr>
			<tr class="detail-tr-center">
				<td class="detail-title">작성자</td>
				<td colspan="3" class="detail-label">${detail_data.boardreguser}</td>
			</tr>
			<tr class="detail-tr">
				<td class="detail-title">작성일</td>
				<td class="detail-label">${detail_data.boardregdate}</td>
				<td class="detail-title">조회수</td>
				<td class="detail-label">${detail_data.boardreadcnt}</td>
			</tr>
			<tr>
				<td class="detail-title">글내용</td>
				<td colspan="4" >${detail_data.boardtext}</td>
			</tr>
		</table>
	</div>

	<div id="board_reply">
		<br>
		<table class="reply-input" style="width:500px">
			<tr>
				<td>
					<textarea style="width:100%" class="form-control"  name="rememo" id="rememo" placeholder="댓글을 입력하세요."></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<div align="right">
						<button type="button" id="btnReplySave" class="reply-save"> 저장</button>
					</div>
				</td>
			</tr>
		</table>
	</div>
	<div id="replylist" style="width:100%;"></div>
		
<script>	
	$(document).ready(function() {
		replylist();
	})
	
	function replylist() {
		var url = "${pageContext.request.contextPath}/board/replylist";
		var paramData = {
			"bno" : ${detail_data.bno}
		}
		$.ajax({
			url : url,
			data : paramData,
			dataType : 'json',
			type : 'POST',
			success : function(result) {
					var htmls = "";
					if (result.length < 1) {
						
					}else{
						$(result).each(function() {
							htmls = htmls+ '<div id="reno' + this.reno + '">';
							htmls += '<hr><span class="d-block">';
							htmls += '<strong class="reply-list"><span style="font-size:12pt">'+ this.rewriter + '</span></strong>';
							htmls += '<span style="font-size: 9pt; color: #999399;">';
// 							htmls += '<br>'+ this.redate;
							htmls += '</span>';
							htmls += '<br>';
							htmls += '<div style="padding-left:10px; padding-top:5px;">';
							htmls += this.rememo;
							htmls += '</div>';
							htmls += '<div align="right" class="reply-button">';
							htmls += '<span style="font-size: 9pt">';
							htmls += '<a href="javascript:void(0)" onclick="fn_editReply('
								+ this.reno + ', \''
								+ this.rewriter + '\', \''
								+ this.rememo + '\' )" style="padding-right:10px;">수정</a>';
							htmls += '<a href="javascript:void(0)" style="padding-right:10px;" onclick="fn_deleteReply('+ this.reno
								+ ')" >삭제</a>';
							htmls += '</span>';
							htmls += '</span>';
							htmls += '</div>';
							htmls += '</div>';
							}); // each End
						}
						$("#replylist").html(htmls);
					}, // Ajax success End
					error : function(data) {
					}
				})
		}
						
	$(function() {
		//목록 버튼을 눌렀을 때 처리
		$("#board-list").click(function() {
			location.href = "${contextPath}/board/boardListPaging";
		});
		//삭제 버튼을 눌렀을 때 처리
		$("#board-delete").click(function() {
			location.href = "${contextPath}/board/delete?bno=" + ${detail_data.bno};
		});
		//수정 버튼을 눌렀을 때 처리
		$("#board-update").click(function() {
			location.href = "${contextPath}/board/update?bno=" + ${detail_data.bno};
		});
	})
</script>
</body>
</html>
