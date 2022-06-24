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
      fnSearch();
   })
   
   function fnSearch(){
      
      var faqQuery = $('#faqQuery');
      
      $('#faqSearchBtn').on('click', function(){
         location.href="${contextPath}/faq/faqSearch?faqQuery=" + faqQuery.val();
         
      })
      
   }
</script>
<style>
   #faqQuery {
      text-align: center;
       top: 3px;
        left:6px;
      font-size : 20px;
      border : none;
      border-bottom: 1px solid #000;
      padding : 13px 70px;
      
   }
   
   #faqSearchBtn{
      
      cursor: pointer;
      border: none;
       outline: none;
       background: none;
       size : 50px;
   }
</style>
</head>
<body>
   <jsp:include page="../layout/header.jsp"></jsp:include>
   
   <h1>FAQ.자주묻는 질문</h1>
   
   <br>
   <form id="faqInput">
      <input type="text" id="faqQuery" name="faqQuery">
      <button type="button"  id="faqSearchBtn" name="faqSearchBtn" value="검색"><i class="fa-solid fa-magnifying-glass fa-3x"></i></button>
   </form>
   
   <br><br>
   
   <%@ include file="faqList.jsp" %>
   
   <jsp:include page="../layout/footer.jsp"></jsp:include>
</body>
</html>