<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>관리자 로그인</h1>
	<br>
	 <br> ${errorMessage }
	<br>
	
	<form action="login" method="post">
	아이디 : <input type="text" name="id" > <br>
	비밀번호 : <input type="password" name="password"><br>
	<input type="submit" value="로그인"><br>
	<a href="registerform" >회원가입</a>
	</form>
</body>
</html>