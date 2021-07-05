<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
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
	int result = PersonDAO.getInstance().getDelete(idx);
	if(result>0){
		response.sendRedirect("list.jsp");
	}

%>
</body>
</html>