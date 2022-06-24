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
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script>
   
   $(function(){
      fnListSelect();
      fnOpenCloseAnswer();
   })
   function fnRemove(no){      
         if(confirm('삭제할까요?')){
            location.href='${contextPath}/faq/remove?faqNo=' + $(no).data('faq_no');
         }
   }
   
   function fnListSelect(){
      $('#faqListSel').on('click', function(){
         location.href="${contextPath}/faq/faqList";
      })
   }
   
   
   function fnOpenCloseAnswer(a){
      const answerId = 'ans-'+$(a).data('faq_detail_no');
      const btnIcon = 'que-'+$(a).data('faq_detail_no');
       if(document.getElementById(answerId).style.display === 'block') {
         document.getElementById(answerId).style.display = 'none';
         document.getElementById(btnIcon).innerHTML = '<i class="fa-solid fa-angle-down"></i>';
         
         
       } else {
         document.getElementById(answerId).style.display = 'block';
         document.getElementById(btnIcon).innerHTML = '<i class="fa-solid fa-angle-up"></i>';
         
       }
   }
    
</script>
<style>
   ul{
      list-style-type: none;   
   }
   .faqDetailBtn{
      cursor: pointer;
       border: none;
       outline: none;
       background: none;
   }
   #faqUl {
      
      font-size: 25px;
   }
   .listOne{
      border-bottom: 1px solid #e0e0e0;
      padding : 40px 40px 20px 40px;
   }
   .answer{
      padding: 30px 30px 30px 30px;
      background: #f9f9f9;
   }
   a {
      box-sizing: border-box;
      display: inline-block;  /* 같은 줄에 둘 수 있고, width, height 등 크기 지정 속성을 지정할 수 있다. */
      padding: 10px;
      margin: 5px;
      border: 1px solid white;
      text-decoration: none;  /* 링크 밑줄 없애기 */
      color: gray;
   }
   .noList {
      text-align: center;
   }
   .question{
      margin-bottom: 20px;
   }
   
</style>
</head>
<body>
   
   <a href="${contextPath}/faq/faqSavePage">새글작성</a>
   
   <input type="button" value="목록보기" id="faqListSel">
   <div id="faqUl">
      <ul>
            <c:forEach items="${faqs}" var="faq">
               <li class="listOne">
                  <div class = "question" >
                     ${faq.faqTitle}
                     <input type="button" value="삭제" data-faq_no = "${faq.faqNo}" onclick="fnRemove(this)">
                     <button type="button" class="faqDetailBtn" id="que-${faq.faqNo}" data-faq_detail_no = "${faq.faqNo}" onclick="fnOpenCloseAnswer(this)" value = "상세내용 보기"><i class="fa-solid fa-angle-down"></i></button>               
                  </div>
                  <div class ="answer" id="ans-${faq.faqNo}" style="display:none;">${faq.faqContent}</div>
               <li>               
            </c:forEach>
      </ul>
   </div>
      
            
         <div class="noList">${paging}</div>
            
</body>
</html>