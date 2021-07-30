<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>
아이디
</th>
<th>
비밀번호
</th>
<th>
이름
</th>
<th>
이메일
</th>
<th>
가입일
</th>
</tr>
<c:forEach var="m" items="${membersList }">
<tr>
<td>${m.m_id }</td>
<td>${m.m_pwd }</td>
<td>${m.m_name }</td>
<td>${m.m_email }</td>
<td>${m.m_regdate }</td>
<td><a href="${contextPath }/member/removeMember.do?id=${m.m_id}">삭제하기</a></td>
</tr>
</c:forEach>
</table>
<a href="${contextPath }/member/memberForm.do"><h1>회원가입</h1></a>
</body>
</html>