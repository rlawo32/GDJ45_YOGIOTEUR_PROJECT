<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.blind {
		display: none;
	}
	.items, .item{	
		padding-left: 20px;
		background-image: url("../resources/image/uncheck.png");
		background-size: 18px 18px;
		background-repeat: no-repeat;
	}
	.check{
		background-image: url("../resources/image/check.png");
	}
</style>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>

	$(function(){
		
		$('#checkAll').on('click', function(){
		
			$('.checkOne').prop('checked', $('#checkAll').prop('checked'));		
																				
			if($('#checkAll').is(':checked')){
				$('.item, .items').addClass('check');
			} else{
				$('.item, .items').removeClass('check');
			}
		})
		
		
		$('.checkOne').on('click', function(){
			let checkAll = true;							

			$.each($('.checkOne'), function(i, checkOne){
				if($(checkOne).is(':checked') == false){	
					$('#checkAll').prop('checked', false);
					$('.items').removeClass('check');
					checkAll = false;						
					return false;
				}
			})
			if(checkAll){								
				$('#checkAll').prop('checked', true);	
				$('.items').addClass('check');			
			}
		})
		
		
		$('.item, .items').on('click', function(){
			$(this).toggleClass('check');		
		})
		
		
		$('#agreeForm').on('submit', function(e){
			if($('#service').is(':checked') == false || $('#privacy').is(':checked') == false){
				alert('필수 약관에 모두 동의하세요.');
				e.preventDefault();
				return false;
			}
			return true;
		})
		
	})
	
</script>
</head>
<body>

	<h3>약관 동의하기</h3>
	
	<form id="agreeForm" action="${contextPath}/member/signInPage">
		
		<input type="checkbox" id="checkAll" class="blind checkAll">
		<label for="checkAll" class="items">모두 동의합니다.</label>
		
		<hr>
		
		<input type="checkbox" id="service" class="blind checkOne">
		<label for="service" class="item">이용약관에 동의합니다.(필수)</label><br>
		<textarea>본 약관은 ...</textarea>
		<br><br>
		
		<input type="checkbox" id="privacy" class="blind checkOne">
		<label for="privacy" class="item">개인정보 수집, 이용에 동의합니다.(필수)</label><br>
		<textarea>개인정보보호법에 따라 ...</textarea>
		<br><br>
		
		<input type="checkbox" name="agreements" value="info" id="info" class="blind checkOne">
		<label for="info" class="item">개인정보 제3자 제공에 대한 동의(선택)</label><br>
		<textarea>개인정보 제3자 제공에 대한 ...</textarea>
		<br><br>
		
		<input type="checkbox" name="agreements" value="event" id="event" class="blind checkOne">
		<label for="event" class="item">개인정보 마케팅 활용 동의(선택)</label><br>
		<textarea>개인정보 마케팅 활용에 관한 ...</textarea>
		<br><br>
		
		<input type="button" value="취소" onclick="history.back()">
		<input type="submit" value="다음">
			
	</form>

</body>
</html>