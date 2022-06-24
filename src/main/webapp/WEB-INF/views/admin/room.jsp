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
		fnFindRoomList();
		fnRoomDetail();
	})
	
	function fnFindRoomList() {
		$.ajax({
			url: '${contextPath}/room/findRooms',
			type: 'GET',
			success: function(obj) {
				$('#rooms').empty();
				$.each(obj.rooms, function(i, room) {
					var tr = '<tr>';
					tr += '<td>' + room.roomNo + '</td>';
					tr += '<td>' + room.roomName + '</td>';
					tr += '<td>' + room.roomTypeDTO.rtType + '</td>';
					tr += '<td>' + room.roomPrice + '</td>';
					if(room.roomStatus == 0) {
						tr += '<td>가능</td>';
					} else {
						tr += '<td>불가</td>';
					}
					tr += '<td><input type="button" value="상세보기" class="btnDetail" data-room_no="' + room.roomNo + '"></td>';
					tr += '</tr>';
					$('#rooms').append(tr);
				})
			}
		})
	}
	function fnRoomDetail() {
		$(document).on('click', '.btnDetail', function() {
			location.href='${contextPath}/admin/roomDetail?roomNo=' + data('room_no');
		})
	}
	
</script>
<link rel="stylesheet" href="../resources/css/admin.css">
</head>
<body>
	
	<div class="container">
		<jsp:include page="index.jsp"></jsp:include>
		
		<div class="grid_item room">
			<h3>객실 목록</h3>
			<table class="table">
				<thead>
					<tr>
						<td>번호</td>
						<td>이름</td>
						<td>타입</td>
						<td>가격</td>
						<td>상태</td>
						<td>보기</td>
					</tr>
				</thead>
				<tbody id="rooms">
				</tbody>
			</table>
		</div>
		
	</div>

</body>
</html>