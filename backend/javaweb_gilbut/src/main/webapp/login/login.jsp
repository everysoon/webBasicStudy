<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1{
		text-align: center;
	}
</style>
</head>
<body>
<h1>로그인 창</h1>
<form action="login" method="post" name="formLogin" enctype="utf-8">
	아이디 : <input type="text" name="id"><br>
	비밀번호 : <input type="text" name="password"><br>
	<input type ="submit" value="로그인">
	<input type="reset" value="다시입력">
	<input type="hidden" name="addr" value="서울시 구로동">
	<input type="hidden" name="email" value="soon@naver.com">
	<input type="hidden" name="tel" value="010-9916-1269">
	
	
</form>
</body>
</html>