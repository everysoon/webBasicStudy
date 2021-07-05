<%@page import="kr.or.connect.jdbc.dto.Person"%>
<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
    Person p = new Person();
    p.setIdx(request.getParameter("idx")); // ${param.idx}
    p.setId(request.getParameter("id"));
    p.setPw(request.getParameter("pw"));
    p.setName(request.getParameter("name"));
    p.setAge(request.getParameter("age"));
    p.setAddr(request.getParameter("addr"));
    p.setReg(request.getParameter("reg"));
    int result = PersonDAO.getInstance().getUpdate(p);
    response.sendRedirect("detail.jsp?idx="+p.getIdx());
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>