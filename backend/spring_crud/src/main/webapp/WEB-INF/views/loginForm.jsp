<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="loginForm.do">
		<table width="400">
			<tr>
				<td>아이디 <input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호 <input type="password" name="password"></td>
			</tr>
			<tr>
			<input type="submit" value="로그인">
			</tr>
		</table>
	</form>
</body>
</html>