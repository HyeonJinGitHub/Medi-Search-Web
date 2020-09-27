<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-addFail</title>
<link rel="stylesheet" href="resources/addFail.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div>
		<img src="resources/faileyoung.png"><header>약 추가 실패!</header>
			<p>&emsp;<br>
			<%=request.getAttribute("addMedicine") %> 이(가) 이미 존재합니다.
			<c:url value="http://localhost:8080/hyeonjin_free/MemberMedicineServlet" var="myMedicine">
		<c:param name="key">userMedicine</c:param>
		</c:url>
		<c:url value="/searchMedicine.jsp" var="search"/>
	<c:url value="/mypage.jsp" var="mypage"/><br>
	<a href="${myMedicine}">나의 약 정보로 가기</a>&emsp;
	<a href="${mypage}">마이 페이지로 가기</a>&emsp;
	<a href="${search}">약 검색하기</a> 
	<br>&emsp;
	</p>
	<br>
		<table>
		<tr><td class="medicinename">약이름</td><td class="ingredient">성분</td><td class="bok">복용법</td><td class="effect">효과</td><td class="caution">주의사항</td><td class="company">제조사</td></tr>
	<c:forEach var="i" items="${medicines}" begin="0" varStatus="status" end="${total}">
	<tr>
	<td class="medicinename"><a class="mediname" onclick="confirmAdd('${i.medicineName}')" target="_self">${i.medicineName }</a></td>
	<td class="ingredient">${i.ingredient }</td>
	<td class="bok">${i.period }</td>
	<td class="effect">${i.effect }</td>
	<td class="caution">${i.caution }</td>
	<td class="company">${i.company }</td>
	</tr>

	</c:forEach> 	
	</table>
	</div>
</body>
<script>
function confirmAdd(param) {
	if(confirm(param+'을 추가 하시겠습니까?')) {
		location.href = 'http://localhost:8080/hyeonjin_free/MemberMedicineServlet?key=add&medicineName='+param;
	} else {
		//alert('취소하였습니다.');
	}
}
</script>
</html>