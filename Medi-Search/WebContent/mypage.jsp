<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-mypage</title>
<link rel="stylesheet" href="resources/mypage.css" type="text/css"></link>
<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body>
	<div>
		<img src="resources/bbekkomeyoung.png"><header>${sessionScope.name }님 환영합니다</header>
		<p>
		&nbsp;<br>
		아래의 버튼 중 원하시는 서비스를 눌러주세요<br>
		
		<c:url value="/allMedicine.jsp" var="allMedicine"/>
		<c:url value="http://localhost:8080/hyeonjin_free/MemberMedicineServlet" var="myMedicine">
		<c:param name="key">userMedicine</c:param>
		</c:url>
		<c:url value="/update.jsp" var="update"/>
			<a href="${allMedicine}" >전체 약 조회</a> <br>
			<a href="${myMedicine}">내 약 정보 조회</a><br>
			<a href="${update}">개인정보 수정</a>
			<a class="btn" onclick="confirmlogout()" target="_self">로그아웃</a><br>
			&nbsp;
			</p>
	</div>
</body>
<script>
function confirmlogout() {
	if(confirm('로그아웃 하시겠습니까?')) {
		location.href = 'http://localhost:8080/hyeonjin_free/MemberServlet?key=logout';
	} else {
		//alert('취소하였습니다.');
	}
}
</script>
</html>