<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!-- 컨트롤러의 BindingResult 객체와 오류메시지 출력 기능 사용을 위한 라이브러리 -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
	<meta charset="utf-8">
	<%@include file ="../include/header.jsp" %>
	<title>회원가입</title>
	<style>
		.valid_chk{
			color: red;
			font:5px;
		}
	</style>
</head>
<body>
	<form:form 
	      modelAttribute="memberDTO"
	      method="POST"
	      action="${contextPath }/member/join">	      
	      <table>
	      	<tr>
	      		<td>
		        	<label for="email">Email:</label>
		        	<form:input path="member_email" type="email" placeholder="Enter email" id="member_email" onchange="Validate()"/>
		       		<br>		       		
		       		<div class="valid_chk" id="valid_email"><form:errors path="member_email" /></div>
			    </td>
		   	</tr>	   	
	      	<tr>
	      		<td>
			        <label for="pwd">비밀번호:</label>
			        <form:input path="member_pw" placeholder="Enter password" name="member_pw" id="member_pw" onchange="Validate()"/>	  			  	    
			  	    <br>
		       		<div class="valid_chk" id="valid_pw"><form:errors path="member_pw" /></div>
			    </td>
		   	</tr>		   	
	      	<tr>
	      		<td>
			        <label for="nickname">닉네임:</label>
			        <form:input path="member_nickname" placeholder="Enter nickname" name="member_nickname" id="member_nickname" onchange="Validate()"/>				  	   
			  	    <br>
		       		<div class="valid_chk" id="valid_nickname"> <form:errors path="member_nickname" /></div>
			  	</td>
		   	</tr>
	      	<tr>
	      		<td>		  
			        <label for="phone">연락처:</label>
			        <form:input path="member_phone" placeholder="Ex)01012345678" name="member_phone" id="member_phone" onchange="Validate()"/>				    
				    <br>
		       		<div class="valid_chk" id="valid_phone"><form:errors path="member_phone" /></div>
			  	 </td>
		   	</tr>
	      	<tr>
	      		<td>		
			        <label for="gender">성별:</label>
			        <label>남</label> <input type="radio" name="member_gender" value="male" checked="checked">
			        <label>여</label> <input type="radio" name="member_gender" value="female">					 		
			 		<br>
		       		<div class="valid_chk" id="valid_gender"><form:errors path="member_gender" /></div>
			  	 </td>
		   	</tr>
	      	<tr>
	      		<td>		 
			        <label for="birth">생년월일:</label>
			        <form:input path="member_birth" placeholder="Ex)20210409" name="member_birth" id="member_birth" onchange="Validate()"/>				   	  		
		   	  		<br>
		       		<div class="valid_chk" id="valid_birth"><form:errors path="member_birth" /></div>
		   	  	 </td>
		   	</tr>
	      	<tr>
	      		<td>	   	  
		   	  		<input type="submit" value="회원가입" class="btn btn-primary"/>
		   	  		<input type="reset" value="작성취소" class="btn btn-primary"/> <!-- HELP 유효성 검사 후 버튼 동작이 안되는 상태  -->
		   	  	</td>
		   	</tr>
	   	  </table>
	</form:form>
</body>
<%@include file ="../include/footer.jsp" %>
</html>



<script>	
	function Validate(){
		// 각 입력박스의 데이터를 변수로 선언
		var input_email = $("#member_email").val();
		var input_pw = $("#member_pw").val();
		var input_nickname = $("#member_nickname").val();
		var input_phone = $("#member_phone").val();
		var input_birth = $("#member_birth").val();
		
		// 특정 패턴이 있는 경우 정규식 선언
		var Reg_email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var Reg_pw = /^[0-9a-zA-Z!@#$%^&]*$/;
		
		// email 정규식 및 글자제한 등 유효성 검사
		if(!Reg_email.test(input_email)){ 
			$("#valid_email").html("이메일 형식이 잘못되었습니다.");
			return false;
		}else{
			$("#valid_email").html("");
		}
		
		// pw 정규식 및 글자제한 등 유효성 검사
		if(!Reg_pw.test(input_email)){ 
			$("#valid_pw").html("비밀번호는 문자, 숫자, 특수문자를 모두 사용해야 합니다.");
			return false;
		}else{
			$("#valid_pw").html("");
		}
		
		// nickname 정규식 및 글자제한 등 유효성 검사
		if(!Reg_email.test(input_email)){ 
			$("#valid_nickname").html("이메일 형식이 잘못되었습니다.");
			return false;
		}else{
			$("#valid_nickname").html("");
		}
	}
	
// 	// 이메일 유효성 검사
// 	$('#member_email').change(function(){
// 		var input_email = $("#member_email").val();
// 		var Reg_email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
// 		console.log(input_email);
// 		console.log(input_email.length);	
		
// 		// test  - 정규식.test(문자열)	일치 여부(Boolean) 반환
// 		// match - 문자열.match(정규식)	일치하는 문자열의 배열(Array) 반환
// 		if(!Reg_email.test(input_email)){ 
// 			$("valid_email").html() = "이메일 형식이 잘못되었습니다."
// 		}
// 	});
	
// 	// 비밀번호 유효성 검사
// 	$('#member_pw').change(function(){
// 		var input_pw = $("#member_email").val();
// 		var Reg = /^[0-9a-zA-Z!@#$%^&]*$/;
// 		console.log(input_pw);
// 		console.log(input_pw.length);		
// 	});
	
// 	// 닉네임 유효성 검사
// 	$('#member_nickname').change(function(){
// 		var input_text = $("#member_email").val();
// 		console.log(input_text);
// 		console.log(input_text.length);		
// 	});
	
// 	// 연락처 유효성 검사
// 	$('#member_phone').change(function(){
// 		var input_text = $("#member_email").val();
// 		console.log(input_text);
// 		console.log(input_text.length);		
// 	});
	
// 	// 생년월일 유효성 검사
// 	$('#member_birth').change(function(){
// 		var input_text = $("#member_email").val();
// 		console.log(input_text);
// 		console.log(input_text.length);		
// 	});
</script>
