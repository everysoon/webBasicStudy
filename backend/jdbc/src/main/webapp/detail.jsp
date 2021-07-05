<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
<%@page import="kr.or.connect.jdbc.dto.Person"%>
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
	request.setCharacterEncoding("utf-8");
	String idx = request.getParameter("idx");
	Person p = PersonDAO.getInstance().getDetail(idx);
	request.setAttribute("p",p);
%>
<jsp:forward page="onelist.jsp"/>
</body>
</html>