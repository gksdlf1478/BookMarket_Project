<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<html>
<head>
	<meta charset="utf-8">
	<%@include file ="../include/header.jsp" %>
	<title>마이페이지</title>
	<style>
	</style>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<section class="content">
					<div class="box-header">
						<div class="mypage-first">
							<h3 class="box-title">${mypage.member_nickname}님 안녕하세요.</h3>
							 현재 등급은 ${mypage.type_no}, ${mypage.member_point} 포인트가 보유하고있습니다.
						</div>
					</div>
					<div id="Mypage">
						<hr class="mypage-hr">
						<table class="mypage-table">
							<tr>
								<td class="mypage-td">이메일</td>
								<td>${mypage.member_email}</td>
							</tr>
							<tr>
								<td class="mypage-td">소속출판사</td>
								<td>${mypage.pub_no}</td>
							</tr>
							<tr>
								<td class="mypage-td">연락처</td>
								<td>${mypage.member_phone}</td>
							</tr>
							<tr>
								<td class="mypage-td">성별</td>
								<td>${mypage.member_gender}</td>
							</tr>
							<tr>
								<td class="mypage-td">생년월일</td>
								<td>${mypage.member_birth}</td>
							</tr>
							<tr>
								<td class="mypage-td">계정소속</td>
								<td>${mypage.member_platform}</td>
							</tr>
							<tr>
								<td class="mypage-td">가입일</td>
								<td>${mypage.member_date}</td>
							</tr>
						</table>
						<br>
						<button type="button"
						onclick="location.href='${contextPath}/member/memberupdate?member_no=${login.member_no }'" class="login-button">개인정보수정</button>
						<br>
					</div>

				</section>
			</div>
		</div>
	</div>
</body>
<%@include file ="../include/footer.jsp" %>
</html>

<script>	
$(document).ready(function() {	
	var msg = '${msg}';
	if(msg!=''){
		alert(msg);
	}
})
</script>
