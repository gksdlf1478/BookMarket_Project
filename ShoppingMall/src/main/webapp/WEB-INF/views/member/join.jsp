<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file ="../include/header.jsp" %>
<title>회원가입</title>
<form method="POST">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" placeholder="Enter email" name="member_email">
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="member_pw">
    </div>
    <div class="form-group">
      <label for="pwd">닉네임:</label>
      <input type="text" class="form-control" id="nickname" placeholder="Enter nickname" name="member_nickname">
    </div>
    <div class="form-group">
      <label for="pwd">연락처:</label>
      <input type="text" class="form-control" id="phone" placeholder="Enter phone" name="member_phone">
    </div>
    <div class="form-group">
      <label for="pwd">성별:</label>
      <input type="text" class="form-control" id="gender" placeholder="Enter gende" name="member_gender">
    </div>
    <div class="form-group">
      <label for="pwd">생년월일:</label>
      <input type="text" class="form-control" id="birth" placeholder="Enter birth" name="member_birth">
    </div>
    <button type="submit" class="btn btn-primary">회원가입</button>
 </form>

<%@include file ="../include/footer.jsp" %>

<script>	
	$(document).ready(function() {		
	})
</script>
