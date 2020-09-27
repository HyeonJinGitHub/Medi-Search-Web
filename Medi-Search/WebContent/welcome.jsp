<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-welcome</title>
<link rel="stylesheet" href="resources/welcome.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div align="center">
		<img src="resources/shinnyEyoung.png"><header>애용 Medi-Search</header>
		<fieldset>
			<p>안녕하세요.<br>
			애용이와 함께하는 약 검색 서비스를 이용할 수 있는 사이트입니다.<br>
			처음 오신 분이라면 회원가입을 해주시고 로그인을 진행해주세요.<br>
			<c:url value="/login.jsp" var="login"/>
			<c:url value="/register.jsp" var="register"/>
			<a href="${login}" >로그인</a> <br>
			<a href="${register }">애용Medi-Search 가입</a>
			</p>
		</fieldset>
		</div>

</body>
</html>