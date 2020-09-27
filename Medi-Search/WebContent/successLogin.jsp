<%@page import="hyeonjin.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-loginSuccess</title>
<link rel="stylesheet" href="resources/successLogin.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
<div>
<img src="resources/congratueyoung.png"><header>로그인 성공!</header></div>
<div>
	<p><%=request.getAttribute("message") %><br>
	
		<%
			
			MemberVO member=(MemberVO)request.getAttribute("member");
		%>
		서비스를 시작하려면 아래버튼을 눌러주세요!!
	<br>
	<c:url value="/mypage.jsp" var="mypage"/>
	<a href="${mypage }">서비스 시작</a>
</div>
</body>
</html>