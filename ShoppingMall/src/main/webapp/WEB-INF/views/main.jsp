<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />

<%@include file ="include/header.jsp" %>

현재시각 : ${serverTime }
<br>
받은 메시지 :${msg }
<br>
세션 : ${login.member_nickname }

<%@include file ="include/footer.jsp" %>

<script>	
	$(document).ready(function() {	
		var msg = '${msg}';
		if(msg!=''){
			alert(msg);
		}
	})
</script>
