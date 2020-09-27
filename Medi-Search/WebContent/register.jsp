<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Programming Homework-register</title>
	<link rel="stylesheet" href="resources/register.css" type="text/css"></link>
	<link href="https://fonts.googleapis.com/css?family=Noto+Serif+KR&display=swap" rel="stylesheet">
</head>
<body> <div>
<img src="resources/kkulruk.png">
<header>Create Your Account</header>
</div>
	<div>
		<form action="http://localhost:8080/hyeonjin_free/MemberServlet?key=join" method="post">
		<fieldset>
			<legend>Personnel Information</legend>
			<ul>
				<li>ID : <input class="inp" type="text" name="id" autofocus required placeholder="&nbsp;공백없이 입력하세요"></li>
				<li>PASSWORD : <input class="resinp" type="password" name="passwd" required placeholder="&nbsp;공백없이 입력하세요"></li>
				<li>USERNAME : <input class="resinp" type="text" name="username" required placeholder="&nbsp;공백없이 입력하세요"></li>
				<li>AGE : <input class="ageinp" type="text" name="userage" required placeholder="&nbsp;공백없이 입력하세요"></li>
				<li>MOBILE : <input class="moinp" type="text" name="mobile" required placeholder="&nbsp;공백없이 입력하세요"></li>
				<li>Gender 
				<select name="gender" >
					<option value="남자">남자</option>
					<option value="여자">여자</option>
				</select>
			</li> 
			</ul>
		</fieldset>
		<br>
		<fieldset>
			<input type="submit" name="submit" value="회원가입">
			<input type="reset" name="reset" value="다시 작성">
		</fieldset>
		</form>
	</div>
</body>
</html>