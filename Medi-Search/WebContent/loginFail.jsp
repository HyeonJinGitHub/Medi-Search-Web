<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-loginFail</title>
<link rel="stylesheet" href="resources/loginFail.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div align="center">
		<img src="resources/faileyoung.png"><header>애용 Medi-Search</header>
		로그인에 실패하였습니다. 아래 버튼을 눌러 다시 로그인 해주세요.<br>
		<c:url value="/login.jsp" var="login"/>
		<a class="nocolora" href="${login}" >로그인</a> <br>
	</div>
</body>
</html>