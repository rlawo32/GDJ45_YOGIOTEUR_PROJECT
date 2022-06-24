<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ</title>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
	
</script>
</head>
<body>
	<jsp:include page="../layout/header.jsp"></jsp:include>
	
 	<h1>FAQ 게시글 작성</h1>
	
	<form id="faqSv" action="${contextPath}/faq/faqSave" method="post">
		<input type="text" id="faqTitle" name="faqTitle"><br>
		<textarea rows="5" cols="50" name="faqContent"></textarea><br><br>
		<button>등록</button>
		<input type="button" value="목록" onclick="location.href='${contextPath}/faq/faqPage'">
		<input type="reset" value="초기화">
	</form>

	<jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>