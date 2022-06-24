<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    * {
        padding: 0;
        margin: 0;
        box-sizing: border-box;
    }
    input[type=radio] { /* checkbox표시를 없애준다. */
        display: none;
    }
    .tab_menu {  /* 메뉴를 수평 배치해준다. */
        display: flex;
    }
    .tab_menu > label {
        display: block;
        width: 200px;
        height: 50px;
        text-align: center;
        line-height: 50px;
        border-top: 1px solid black; 
        border-left: 1px solid black;
        border-bottom: 1px solid black;
        background-color: Lightgray;
    }
    .tab_menu > label:last-of-type {
        border-right: 1px solid black;
    }
    .tab_menu > label:hover {
        cursor: pointer;
    }
    /* input[type=radio] ~ div:first-of-type > label { 인풋(라디오)와 인접한 첫번째 형제들(#menu1, #menu2) 선택
        background-color: aquamarine;
    } */
    #memberInfo:checked ~ div:first-of-type > label:nth-of-type(1) { /*첫번째 인풋(라디오)& 첫번째 형제들 中 첫번째 라벨(메뉴1) 선택 */
        background-color: white;
        color: gray;
    }
    #memberReser:checked ~ div:first-of-type > label:nth-of-type(2) { /*두번째 인풋(라디오)& 첫번째 형제들 中 두번째 라벨(메뉴2) 선택 */
        background-color: white;
        color: gray;
    }
    .content {
        width: 400px;
        height: 400px;
        border-right: 1px solid black;
        border-left: 1px solid black;
        border-bottom: 1px solid black;
        display: none;
    }
    #memberInfo:checked ~ div:nth-of-type(2) { /*첫번째 인풋(라디오)와 인접한 2번째 형제 */
        display: block;
    }
    #memberReser:checked ~ div:nth-of-type(3) { /*첫번째 인풋(라디오)와 인접한 3번째 형제 */
        display: block;
    }

</style>
<script src="../resources/js/jquery-3.6.0.js"></script>
<script>
	$(document).ready(function(){
		fnPwCheck();
		fnPwConfirm();
		fnChangePw();
	})
	
	let pwPass = false;
	function fnPwCheck(){
		$('#memberPw').on('keyup', function(){
			let regPw = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,12}$/; 
			if(regPw.test($('#memberPw').val())==false){
				$('#pwMsg').text('영문 소문자, 숫자, 특수문자 포함 8~12자로 입력해주세요.').addClass('dont').removeClass('ok');
				pwPass = false;
			} else {
				$('#pwMsg').text('사용 가능한 비밀번호입니다.').addClass('ok').removeClass('dont');
				pwPass = true;
			}
		})
	}
	

	let rePwPass = false;
	function fnPwConfirm(){
		$('#memberRePw').on('keyup', function(){
			if($('#memberRePw').val() != '' && $('#memberPw').val() != $('#memberRePw').val()){
				$('#rePwMsg').text('비밀번호를 확인하세요.').addClass('dont').removeClass('ok');
				rePwPass = false;
			} else {
				$('#rePwMsg').text('');
				rePwPass = true;
			}
		})
	}
	
	function fnChangePw(){
		$('#findPwForm').on('submit', function(event){
			if(pwPass == false || rePwPass == false){
				alert('비밀번호를 확인하세요.');
				event.preventDefault();
				return false;
			}
			else if('${loginMember.memberPhone}' == $('#memberPhone').val() && '${loginMember.memberEmail}' == $('#memberEmail').val()){
				alert('변경된 정보가 없습니다.');
				e.preventDefault();
				return false;
			}
			}
			return true;
			})
		})
	}
</script>
</head>
<body>
	
	<div class="container">
        <!-- 상단 탭 메뉴 -->
        <input type="radio" name="tabmenu" id="memberInfo" checked="checked">
        <input type="radio" name="tabmenu" id="memberReser">
        <div class="tab_menu">
            <label for="memberInfo">개인정보</label>
            <label for="memberReser">예약확인</label>
        </div>

        <!-- 개인정보 내용 -->
        <div class="content">
            <p>정보 수정시, 비밀번호를 꼭 다시 한번 확인해 주세요.</p>
            <form action="/member/modifyMember" method="post">
            	아이디${loginMember.memberId}<br>
            	이름${loginMember.memberName}<br>
            	신규 비밀번호<input type="password" >
            	신규 비밀번호 확인
            	연락처<input type="text" name="memberPhone" id="memberPhone" value="${loginMember.memberPhone}"><br>
				이메일<input type="text" name="memberEmail" id="memberEmail" value="${loginMember.memberEmail}"><br>
				생년월일${loginMember.memberBirth}<br>
				<button>수정하기</button>
				<input type="button" value="회원탈퇴" onclick="location.href='${contextPath}/member/signOut'">
            </form>
        </div>

        <!-- 예약확인 내용 -->
        <div class="content">
            <p>예약 확인</p>
			<a href="${contextPath}/member/memberReser">예약확인</a>
        </div>
    </div>

</body>
</html>