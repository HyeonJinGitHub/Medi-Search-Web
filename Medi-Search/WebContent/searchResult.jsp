<%@page import="hyeonjin.domain.MedicineVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-searchResult</title>
<link rel="stylesheet" href="resources/searchResult.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div align="center">
		<img src="resources/bbekkomeyoung.png"><header>약 검색 결과</header>
			<c:url value="http://localhost:8080/hyeonjin_free/MemberMedicineServlet" var="myMedicine">
	<c:param name="key">userMedicine</c:param></c:url>
	<c:url value="/searchMedicine.jsp" var="search"/>
	<c:url value="/mypage.jsp" var="mypage"/>
	<a class="nocolora" href="${myMedicine}">나의 약 정보로 가기</a>&emsp;
	<a class="nocolora" href="${mypage}">마이 페이지로 가기</a>&emsp;
	<a class="nocolora" href="${search}">약 검색하기</a>
	<br>&emsp;
		<table>
		<tr><td class="medicinename">약이름</td><td class="ingredient">성분</td><td class="bok">복용법</td><td class="effect">효과</td><td class="caution">주의사항</td><td class="company">제조사</td></tr>
		<%
			List<MedicineVO> medicinelist=(List<MedicineVO>)request.getAttribute("medicineList");
			for(MedicineVO vo : medicinelist) {
		%>
		<tr>
		<td class="medicinename"><a class="mediname" onclick="confirmAdd('<%=vo.getMedicineName()%>')" target="_self"><%=vo.getMedicineName() %></a></td>
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
function confirmAdd(param) {
	if(confirm(param+'을 추가 하시겠습니까?')) {
		location.href = 'http://localhost:8080/hyeonjin_free/MemberMedicineServlet?key=add&medicineName='+param;
	} else {
	}
}
</script>
</html>