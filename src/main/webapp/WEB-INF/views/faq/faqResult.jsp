<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<script>
	if('${type}' == 'insert') {
		if('${insRes}' > '0') {
			alert('등록 성공');
			location.href='${contextPath}/faq/faqList';
		} else {
			alert('등록 실패');
			history.back();
		}	
	}  else if('${type}' == 'delete') {
		if('${delRes}' > '0') {
			alert('삭제 성공');
			location.href='${contextPath}/faq/faqList';
		} else {
			alert('삭제 실패');
			history.back();
		}	
	}
</script>