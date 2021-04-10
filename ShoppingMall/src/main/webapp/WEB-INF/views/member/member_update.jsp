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
					<div id="Mypage">
						<hr class="mypage-hr">
						<form method="POST">
							<table class="mypage-table">			
			
								<tr>
									<td class="mypage-td">닉네임</td>
									<td><input type="text" name="member_nickname" value="${mypage.member_nickname}"></td>
								</tr>
								<tr>
									<td class="mypage-td">연락처</td>
									<td><input type="text" name="member_phone" value="${mypage.member_phone}"></td>
								</tr>
								<tr>
									<td class="mypage-td">비밀번호</td>
									<td><input type="password" name="member_pw" value="${mypage.member_pw}"></td>
								</tr>	
								<tr>
									<td class="mypage-td">회원번호</td>
									<td><input type="hidden" name="member_no" value="${login.member_no}"></td>
								</tr>								
								<tr>
									<td class="mypage-td">이메일</td>
									<td>${mypage.member_email}</td>
								</tr>
								<tr>
									<td class="mypage-td">소속출판사</td>
									<td>${mypage.pub_no}</td>
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
							<button type="submit"
							onclick="location.href='${contextPath}/member/memberupdate'" class="login-button">개인정보수정</button>
						</form>
						<br>
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
