<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
// redirect는 요청을 2번보냄
// 1. redirect01.jsp 요청 (-> 응답 location값으로 redirect02.jsp)
// 2. 웹 브라우저는 WAS의 리다이렉트 요청을 받고 redirect02.jsp 요청 (-> redirect02결과 출력)
// -> url이 redirect02.jsp로 바뀜!
	response.sendRedirect("redirect02.jsp");

%>
</body>
</html>