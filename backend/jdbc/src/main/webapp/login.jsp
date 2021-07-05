<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
<%@page import="kr.or.connect.jdbc.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    request.setCharacterEncoding("utf-8");
    Person p = new Person();
    p.setId(request.getParameter("id"));
    p.setPw(request.getParameter("pw"));
    
    // DB에 해당id와 pw가 맞는지검사
    Person resultP = PersonDAO.getInstance().getLogin(p);
    
    //jstl과 el은 jsp내장객체에 저장되어있어야 함.
    session.setAttribute("resultP", resultP);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<c:choose>
<c:when test="${empty resultP }">
<script type="text/javascript">
var k = confirm("로그인 실패 \n 회원가입 할까요?");
if(k){
	location.href="join.jsp";
}else{
	location.href="index.jsp";
}
</script>
</c:when>
<c:otherwise>
<script type="text/javascript">
alert("로그인 성공!")
location.href="onelist.jsp";
</script>
</c:otherwise>
</c:choose>
</head>
<body>

</body>
</html>