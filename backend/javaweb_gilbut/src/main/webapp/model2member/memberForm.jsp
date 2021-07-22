<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
text-align: center
}
</style>
</head>
<body>
<h1 >회원가입창</h1>
<form action="${contextPath }/member/addMember.do" method="post">
<table align="center">
	<tr>
	<td width="200">
	<p align="right">아이디</p>
	</td>
	<td width="400">
	<input type="text" name="id">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">비밀번호</p>
	</td>
	<td width="400">
	<input type="text" name="pwd">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">이메일</p>
	</td>
	<td width="400">
	<input type="text" name="email">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">이름</p>
	</td>
	<td width="400">
	<input type="text" name="name">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p >&nbsp;</p>
	</td>
	<td width="400">
	<input type="submit" value="가입하기">
	<input type="reset" value="다시입력">
	</td>
	</tr>
	
</table>
</form>
</body>
</html>