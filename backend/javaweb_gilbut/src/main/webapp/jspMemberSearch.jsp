<%@page import="kr.or.soon.dto.Member"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.soon.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="jspMemberList.jsp">
	이름 : <input type="text" name="name"><br>
	<input type="submit" value="조회하기"> 
</form>
</table>
</body>
</html>