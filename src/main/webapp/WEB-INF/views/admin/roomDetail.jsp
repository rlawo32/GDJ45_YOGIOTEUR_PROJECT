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
<link rel="stylesheet" href="../resources/css/admin.css">
</head>
<body>
	
	<div class="container">
		<jsp:include page="index.jsp"></jsp:include>
		
		<div class="grid_item room">
			<h3>객실상세</h3>
			<form id="f" action="${contextPath}/room/saveRoom" method="post" enctype="multipart/form-data">
				객실타입
				<select name="rtNo">
					<option value="">==선택==</option>
					<option value="1">싱글</option>
					<option value="2">더블</option>
					<option value="3">트윈</option>
				</select><br>
				객실이름<input type="text" name="roomName" id="roomName"><br>
				객실가격<input type="text" name="roomPrice" id="roomPrice"><br>
				이미지 첨부<input type="file" name="files" id="files" multiple="multiple"><br>
				<button>등록</button>
			</form>
		</div>
	</div>

</body>
</html>