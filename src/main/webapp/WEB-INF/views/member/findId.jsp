<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
	
	$(function(){
		fnFindId();
	})
	
	function fnFindId(){
		$('#findIdForm').on('submit', function(e){
			if($('#memberName').val() == '' || $('#memberEmail').val() == ''){
				alert('이름과 이메일을 입력해주세요.');
				e.preventDefault();
			}
			let regEmail = /^[a-zA-Z0-9-_]+@[a-zA-Z0-9]+(\.[a-zA-Z]{2,}){1,2}$/;  
			if(regEmail.test($('#memberEmail').val())==false){
				alert('잘못된 형식의 이메일입니다.');
				$('#memberEmail').focus();
				return;
			}
		})
	}

	
	
</script>
</head>
<body>
	
	<h3>아이디 찾기</h3>
	<form id="findIdForm" action="${contextPath}/member/findId" method="post">
		<div>
			이름<input type="text" name="memberName" id="memberName"><br>
			이메일<input type="text" name="memberEmail" id="memberEmail"><br>
			<button>확인</button> 
			<input type="button" value="취소" onclick="location.href='${contextPath}/'"><br>				
			<a href="${contextPath}/member/findPwPage">비밀번호 찾기</a> /
			<a href="${contextPath}/member/agreePage">회원가입</a>
		</div>
	</form>

</body>
</html>