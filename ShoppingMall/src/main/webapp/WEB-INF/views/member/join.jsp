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
		        	<input type="button" id="email_check" value="중복체크">
		        	<span class="valid_chk" id="email_check_result"></span>
		       		<br>		       		
		       		<div class="valid_chk" id="valid_email"><form:errors path="member_email" /></div>
			    </td>
		   	</tr>	   	
	      	<tr>
	      		<td>
			        <label for="pwd">비밀번호:</label>
			        <form:input path="member_pw" type="password" placeholder="Enter password" name="member_pw" id="member_pw" onchange="Validate()"/>	  			  	    
			  	    <br>
		       		<div class="valid_chk" id="valid_pw"><form:errors path="member_pw" /></div>
			    </td>
		   	</tr>		   	
	      	<tr>
	      		<td>
			        <label for="nickname">닉네임:</label>
			        <form:input path="member_nickname" type="text" placeholder="Enter nickname" name="member_nickname" id="member_nickname" onchange="Validate()"/>				  	   
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
		   	  		<input type="submit" value="회원가입" id="form_submit" disabled="disabled" class="btn btn-primary"/>
		   	  		<input type="reset"  value="작성취소" class="btn btn-primary"/> <!-- HELP 유효성 검사 후 버튼 동작이 안되는 상태  -->
		   	  	</td>
		   	</tr>
	   	  </table>
	</form:form>
</body>
<%@include file ="../include/footer.jsp" %>
</html>



<script>	
	// 아이디 중복 체크를 위한 ajax 통신 메소드
	$("#email_check").click(function(){
		var member_email = $("#member_email").val();
		var ajax_data = {"member_email" : member_email}
		
		$.ajax({
			 type : "POST",
	         url : "${contextPath}/member/emailcheck",
	         data : ajax_data,
	         dataType : 'json',
	         success : function(result){
	        	 if(result==0){
	        	 	$("#email_check_result").html("사용 가능한 이메일 입니다.");
	        	 }else{
	        		$("#email_check_result").html("이미 가입된 메일주소 입니다.");
	        	 }
	         },
	         error : function(data){
	        	 console.log(data);
	         }
		});
	});


	function Validate(){
		// 회원가입 버튼의 활성화/비활성화 상태 변경을 위한 객체 선언
		const btn = document.getElementById('form_submit');
		
		// 각 입력박스의 데이터를 변수로 선언
		var input_email = $("#member_email").val();
		var input_pw = $("#member_pw").val();
		var input_nickname = $("#member_nickname").val();
		var input_phone = $("#member_phone").val();
		var input_birth = $("#member_birth").val();			
		
		// 특정 패턴이 있는 경우 정규식 선언
		var Reg_email = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		var Reg_pw = /^[0-9a-zA-Z!@#$%^&]*$/;
		
		// email 정규식 및 글자수 제한 등 유효성 검사
		if(!Reg_email.test(input_email) && input_email!=null){ 
			$("#valid_email").html("이메일 형식이 잘못되었습니다.");
			return false;
		}else{
			$("#valid_email").html("");
		}
		
		// pw 정규식 및 글자수 제한 등 유효성 검사
		if(!Reg_pw.test(input_pw) && input_pw!=null){ 
			$("#valid_pw").html("비밀번호는 문자, 숫자, 특수문자를 모두 사용해야 합니다.");
			return false;
		}else if(input_pw.length <6 && input_pw.length > 0){
			$("#valid_pw").html("비밀번호는 6자 이상으로 지정해야 합니다.");	
			return false;
		}else{			
			$("#valid_pw").html("");
		}
		
		// nickname 글자수 제한 등 유효성 검사
		if(!(input_nickname.length >= 2 && input_nickname.length<=6 ) && !input_nickname.length<1){ 
			$("#valid_nickname").html("닉네임은 2~6자 사이로 입력해주세요");
			return false;
		}else{
			$("#valid_nickname").html("");
		}
		
		// phone  글자수 제한 등 유효성 검사
		if(input_phone.length < 8 && input_phone.length > 0){ 
			$("#valid_phone").html("전화번호를 확인하여 주세요.");
			return false;
		}else{
			$("#valid_phone").html("");
		}
		
		// birth 글자수 제한 등 유효성 검사
		if(input_birth.length!=8 && input_birth>0){ 
			$("#valid_birth").html("전화번호를 확인하여 주세요.");
			return false;
		}else{
			$("#valid_birth").html("");
		}
		
		// 모든 유효성 검사에 충족 및 모든 항목에 데이터를 입력한 경우 회원가입 버튼 활성화 
		if(input_email!="" && input_pw!="" && input_birth!="" && input_nickname!="" && input_phone!=""){
			btn.disabled=false;
		}
	}

</script>
