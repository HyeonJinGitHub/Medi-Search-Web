<%@page import="hyeonjin.domain.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-updateResult</title>
<link rel="stylesheet" href="resources/updateResult.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
<div align="center">
<img src="resources/congratueyoung.png"><header>애용 Medi-Search</header>
	<p><%=request.getAttribute("message") %><br>
	
		<%
			MemberVO member=(MemberVO)request.getAttribute("member");
		%>
		<table>
		<tr>
			<td class="memberid">계정</td><td class="membername">이름</td><td class="memberage">나이</td><td class="membermobile">핸드폰</td><td class="membergender">성별</td>
			</tr>
		
		<tr>
			<td class="memberid"><%=member.getMemberID() %></td><td class="membername"><%=member.getMemberName() %></td>
			<td class="memberage"><%=member.getMemberAge() %></td><td class="membermobile"><%=member.getMemberMobile() %></td><td class="membergender"><%=member.getMemberGender() %></td>
			</tr>
	</table>
	<br>
	마이페이지로 가시려면 아래 버튼을 눌러주세요!!!!<br>
	<c:url value="/mypage.jsp" var="mypage"/>
	<a href="${mypage }">마이페이지</a>
	
	</div>
</body>
</html>