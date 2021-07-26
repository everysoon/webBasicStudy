<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입창</h1>
<form action="${contextPath }/user/memberInfo.go">
<table >
	<tr>
	<td width="200">아이디</td>
	<td width="400"><input type="text" name="id"></td>
	</tr>
	<tr>
	<td width="200">비밀번호</td>
	<td width="400"><input type="password" name="password"></td>
	</tr>
	<tr>
	<td width="200">email</td>
	<td width="400"><input type="text" name="email"></td>
	</tr>
	<tr>
	<td width="200">name</td>
	<td width="400"><input type="text" name="name"></td>
	</tr>
	<tr>
	<td colspan="2" align="center">
	<input type="submit" value="회원가입">
	<input type="reset" value="다시입력">
	</td>
	</tr>
</table>
</form>
</body>
</html>