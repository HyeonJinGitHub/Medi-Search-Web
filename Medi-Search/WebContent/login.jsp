<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-login</title>
<link rel="stylesheet" href="resources/login.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div>
	<img src="resources/insaeyoung.png"><header>애용 Medi-Search</header>
	<form method="post" action="http://localhost:8080/hyeonjin_free/MemberServlet?key=login">
	<input type="hidden" name="key" value="login">
	<p>&nbsp;<br>아이디 :&emsp; <input class="inp" type="text" name="memberloginID" size="25" autofocus required placeholder="&nbsp;아이디를 입력해주세요">
	<br><br>
		비밀번호 :&nbsp; <input class="inp" type="password" name="memberPassword" size="25" required placeholder="&nbsp;비밀번호를 입력해주세요" >
		<br>&nbsp;</p>
		<br>
		<input type="submit" value="로그인">&emsp;	
	</form>
	<form method="post" action="http://localhost:8080/hyeonjin_free/MemberServlet?key=register">
		<input class="inputregister" type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>