<%@page import="java.util.List"%>
<%@page import="hyeonjin.domain.MedicineVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-myMedicine</title>
<link rel="stylesheet" href="resources/myMedicine.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div align="center">
		<img src="resources/shockeyoung.png"><header>${sessionScope.name}님의 약정보</header>
		<p>&emsp;<br>
		약을 삭제하려면 약 이름을 눌러주세요<br>
			<c:url value="/allMedicine.jsp" var="allMedicine"/>
	<c:url value="/mypage.jsp" var="mypage"/>
	<a href="${allMedicine}">전체 약 정보로 가기</a>&emsp;
	<a href="${mypage}">마이 페이지로 가기</a>
	<br>&emsp;
	<div>
	<br></div>
		<table>
		<tr><td class="medicinename">약이름</td><td class="ingredient">성분</td><td class="bok">복용법</td><td class="effect">효과</td><td class="caution">주의사항</td><td class="company">제조사</td></tr>
		<%
			List<MedicineVO> medicinelist=(List<MedicineVO>)request.getAttribute("userMedicine");
			for(MedicineVO vo : medicinelist) {
		%>
		<tr>
		<td class="medicinename"><a class="mediname" onclick="confirmDelte('<%=vo.getMedicineName()%>')" target="_self"><%=vo.getMedicineName() %></a></td>
		<td class="ingredient"><%=vo.getIngredient() %></td>
		<td class="bok"><%=vo.getPeriod() %></td>
		<td class="effect"><%=vo.getEffect() %></td>
		<td class="caution"><%=vo.getCaution() %></td>
		<td class="company"><%=vo.getCompany() %></td>
		</tr>
		<% }%>

	</table>
	
	</div>
</body>
<script>
function confirmDelte(param) {
	if(confirm(param+'을 삭제 하시겠습니까?')) {
		location.href = 'http://localhost:8080/hyeonjin_free/MemberMedicineServlet?key=delete&medicineName='+param;
	} else {

	}
} 
</script>
</html>