<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
</script>
</head>
<body>
	
	<h1>예약 확인</h1>
	
	객실 이미지        객실 이름 및 타입
	
	체크인             체크아웃
	
	예약번호${reservation.reserNo}
	투숙인원${reservation.reserPeople}
	투숙객 이름
	투숙객 전화번호
	
	
	총 결제 금액
	결제 금액 세부사항(조식비 + 객실비)

</body>
</html>