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
<!-- iamport.payment.js -->
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>

<script>
	$(document).ready(function(){
		$('#f').on('submit', function(event){
			if($('#privacy').is(':checked') == false){
				alert('필수 약관에 동의하세요.')
				event.preventDefault();
				return false;
			}
			return true;
		})
	})
	
	function count(type) {
		const cntElement1 = document.getElementById('cnt1');
		const cntElement2 = document.getElementById('cnt2');
		const sum1 = document.getElementById('sum');
		
		let number1 = cntElement1.value;
		let number2 = cntElement2.value;
		let sumVal = sum1.value; 
		
		if(type == 'plus1') {
			number1 = parseInt(number1) + 1;
			sumVal = parseInt(number1) * 45000;
		} else if(type == 'minus1') { 
			if(cntElement1.value != 0) {
				number1 = parseInt(number1) - 1;
				sumVal = parseInt(sumVal) - 45000;
			}
		}
		$('#cnt1').attr('value', number1);
		$('#sum').attr('value', sumVal);
		
		if(type == 'plus2') {
			number2 = parseInt(number2) + 1;
		} else if(type == 'minus2') { 
			if(cntElement2.value != 0) {
				number2 = parseInt(number2) - 1;
			}
		}
		$('#cnt2').attr('value', number2);
	}
</script>
<style>

</style>
</head>
<body>

	<h1>예약 페이지</h1>
	<hr>
	
	<div>
		<img src="../resources/img/unnamed.jpg" width="50px" height="50px">
	</div>
	
	<hr>
	
	
	
	<h3>예약자 정보</h3>
	
	<form id="f" action="${contextPath}/payments" method="post">
			<div>
				조식 선택 <input type="button" value="+" onclick="count('plus1')">
							<span><input type="text" id="cnt1" name="food" value="0" style="width:14px;border:none;border:0px" readonly></span>
						  <input type="button" value="-" onclick="count('minus1')">
						  	<input type="text" id="sum" name="sum" size="8" value="0" style="border:none;border:0px" readonly><br>
				투숙 날짜 <br>
				객실 인원 <input type="button" value="+" onclick="count('plus2')">
							<span><input type="text" id="cnt2" name="people" value="0" style="width:14px;border:none;border:0px" readonly></span>
						  <input type="button" value="-" onclick="count('minus2')"><br>
			</div>
		<c:if test="${session == null }">
			<div>
				<input type="hidden" name="memberNo" id="memberNo" value="1">
				<input type="hidden" name="roomNo" id="roomNo" value="1">
				이름 <input type="text" name="name" id="name" value="ksj" readonly><br>
				연락처 <input type="text" name="tel" id="tel" value="01012345678" readonly><br>
				이메일 <input type="text" name="email" id="email" value="rlawo32@naver.com" readonly><br>
				체크인 <input type="text" name="checkin" id="checkin" value="" readonly>
				체크아웃 <input type="text" name="checkout" id="checkout" value="" readonly>
			</div>
		</c:if>
		<c:if test="${session != null }">
			<div>
				비회원 이름 <input type="text" name="nonName" id="nonName" value="${session.nonName}" readonly>
				비회원 연락처 <input type="text" name="nonTel" id="nonTel" value="${session.nonTel}" readonly><br>
			</div>
		</c:if>
		
		<textarea readonly>개인정보보호법에 따라 ...</textarea><br>
		
		<input type="checkbox" id="privacy">
		<label for="privacy" class="item">개인정보 수집에 동의합니다.</label><br>
		<br><br>
		
		<input type="button" value="돌아가기" onclick="location.href='${contextPath}'">
		<button id="payment">결제하기</button>
	</form>
	
	
	
</body>
</html>