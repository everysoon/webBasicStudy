<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
<%@page import="kr.or.connect.jdbc.dto.Person"%>
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
	<%
	request.setCharacterEncoding("utf-8");
	// 파라미터값이 Person에 속하면 Person객체를 생성해서 넣자
	Person p = new Person();
	p.setId(request.getParameter("id"));
	p.setPw(request.getParameter("pw"));
	p.setName(request.getParameter("name"));
	p.setAge(request.getParameter("age"));
	p.setAddr(request.getParameter("age"));
	//DB 처리는 항상 DAO
	int result = PersonDAO.getInstance().getInsert(p);
	pageContext.setAttribute("result", result);
	%>

	<c:choose>
		<c:when test="${result>0}">
			<script type="text/javascript">
				alert("회원가입 성공!");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원가입 실패!");
				location.href = "join.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>