<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>
    <% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1{
text-align: center
}
.cls1{
font-size: 40px;
text-align: center;
}
</style>
</head>
<body>
<h1 >회원 정보 수정창</h1>
<form action="${contextPath }/member/modMember.do?id=${memInfo.m_id}" method="post">
<table align="center">
	<tr>
	<td width="200">
	<p align="right">아이디</p>
	</td>
	<td width="400">
	<input type="text" name="id" value="${memInfo.m_id}" disabled>
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">비밀번호</p>
	</td>
	<td width="400">
	<input type="text" name="pwd" value="${memInfo.m_pwd}">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">이메일</p>
	</td>
	<td width="400">
	<input type="text" name="email" value ="${memInfo.m_email}">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">이름</p>
	</td>
	<td width="400">
	<input type="text" name="name" value="${memInfo.m_name}">
	</td>
	</tr>
	<tr>
	<td width="200">
	<p align="right">가입일</p>
	</td>
	<td width="400">
	<input type="text" name="regdate" value="${memInfo.m_regDate}" disabled>
	</td>
	</tr>
	<tr>
	<td width="200">
	<p >&nbsp;</p>
	</td>
	<td  colspan="2" width="400">
	<input type="submit" value="수정하기">
	<input type="reset" value="다시입력">
	</td>
	</tr>
	
</table>
</form>
</body>
</html>