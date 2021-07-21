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

<%
request.setCharacterEncoding("utf-8");
String reqeustName = request.getParameter("name");
Member m = new Member();
m.setM_name(reqeustName);

MemberDAO dao = new MemberDAO();
List<Member> list = dao.searchList(m);
%>
<table border=1 width=800 align=center>
<tr align=center bgcolor="#FFFF66">
<td>아이디</td>
<td>비밀번호</td>
<td>이름</td>
<td>이메일</td>
<td>가입일자</td>
</tr>
<%
out.print("listsize ?"+list.size());
for(int i=0; i<list.size(); i++){
Member vo = (Member)list.get(i);
String id = vo.getM_id();
String password =vo.getM_pwd();
String name = vo.getM_name();
String email = vo.getM_email();
String regDate = vo.getM_regDate();
%>
<tr align=center>
<td><%=id %></td>
<td><%=password %></td>
<td><%=name %></td>
<td><%=email %></td>
<td><%=regDate %></td>
</tr>
<% }%>
</table>
</body>
</html>