<%@page import="hyeonjin.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-update</title>
<link rel="stylesheet" href="resources/update.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
<div>
		<img src="resources/halmon.png"><header>Member Update</header>
		<hr>
		
		<form action="http://localhost:8080/hyeonjin_free/MemberServlet?key=update" method="post">
		<%
			MemberVO member = (MemberVO)session.getAttribute("memberVO");
		%>
	
		<fieldset>
			<legend>Personnel Information Update</legend>
			<ul>
				<li>ID : <input class="inp" type="text" name="id" value=<%=member.getMemberID() %> readonly></li>
				<li>PASSWORD : <input class="resinp" type="password" name="passwd" value=<%=member.getMemberPassword() %> autofocus></li>
				<li>USERNAME : <input class="resinp" type="text" name="username" value=<%=member.getMemberName() %>></li>
				<li>USERAGE : <input class="updateage" type="text" name="userage" value=<%=member.getMemberAge() %>></li>
				<li>MOBILE : <input class="moinp" type="text" name="mobile" value=<%=member.getMemberMobile() %>></li>
				<li>GENDER : <input class="moinp" type="text" name="gender" value=<%=member.getMemberGender() %> readonly></li>
			</ul>
		</fieldset>
		<br>
		<fieldset>
		<input type="submit" name="submit" value="최종 수정">
		<input type="reset" name="reset" value="다시 작성">
		</fieldset>
			
		</form>

		<br>
		<a class="btn" onclick="confirmcancel()" >뒤로가기</a> <br>

		</div>
</body>
<script>
function confirmcancel() {
	if(confirm('뒤로 가시겠습니까?')) {
		location.href = 'http://localhost:8080/hyeonjin_free/MemberServlet?key=back';
	} else {
	}
}
</script>
</html>