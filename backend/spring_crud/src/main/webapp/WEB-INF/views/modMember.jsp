<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${contextPath }/member/modMember.do">
<h1>회원 수정 창</h1>
<table>
<tr>
<td width="200">아이디</td>
<td width="400"><input type="text" name="id" disabled></td>
</tr>
<tr>
<td width="200">비밀번호</td>
<td width="400"><input type="password" name="password"></td>
</tr>
<tr>
<td width="200">이메일</td>
<td width="400"><input type="text" name="email"></td>
</tr>
<tr>
<td width="200">이름</td>
<td width="400"><input type="text" name="name"></td>
</tr>
<tr>
<td colspan="2">
<input type="submit" value="수정하기">
<input type="reset" value="다시입력">
</td>
</tr>
</table>
</form>
</body>
</html>