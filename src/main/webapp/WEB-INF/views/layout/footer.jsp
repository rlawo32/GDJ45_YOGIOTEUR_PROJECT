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
	body{
			margin: 0;
			font-family: 'Kdam Thmor Pro', sans-serif;
		}
		
	a{
		text-decoration: none;
		color: white;
	}	
		
	ul {
		
		 list-style:none;
		 text-align: left;
	}
	
	li{
		
		float: left;
		margin-left: 10px;
		margin-top: 3px;
		
	
	}
	
	nav {
		  float: right;
		}
	
	
	.footer{
		background-color: silver;
		height: 170px;
	
	}
	
	.end_title{
		font-size: 20px;
		width: 1200px;
		margin: 0 auto;
		color: white;
		
	}
	
	.info{
		
		display: block;
	
	}
	
</style>
</head>
<body>
	
	</section>
	
	<div class="footer">
		<div class="end_title">
			YOGIOTEUR
			<hr>
				<div class="info">
					(주)여기오떼르
					제주특별자치도 서귀포시 비자림로 2074 63616
							<nav>
								<ul>
									<li><a href="https://www.facebook.com/"><i class="fa-brands fa-facebook-square"></i></a></li>
									<li><a href="https://twitter.com/"><i class="fa-brands fa-twitter-square"></i></a></li>
									<li><a href="https://www.instagram.com/"><i class="fa-brands fa-instagram"></i></a></li>
								</ul>
							
							</nav>
				</div>
		</div>
	</div>
</body>
</html>