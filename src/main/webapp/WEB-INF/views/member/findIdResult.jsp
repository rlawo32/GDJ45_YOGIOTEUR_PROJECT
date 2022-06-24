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

</script>

</head>
<body>
	
	<c:if test="${memberConfirm != null}">
		회원님의 아이디는 ${memberConfirm.memberId} 입니다.<br>
		가입일 ${memberConfirm.signIn}<br>
		<input type="button" value="로그인" onclick="location.href='${contextPath}/member/loginPage'">
	</c:if>
	
	<c:if test="${memberConfirm == null}">
		일치하는 회원 정보가 없습니다.<br>
		<input type="button" value="취소" onclick="location.href='${contextPath}/'">
		<input type="button" value="회원가입" onclick="location.href='${contextPath}/member/agreePage'">
	</c:if>
	
</body>
</html>