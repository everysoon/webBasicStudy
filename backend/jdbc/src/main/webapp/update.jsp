<%@page import="kr.or.connect.jdbc.dto.Person"%>
<%@page import="kr.or.connect.jdbc.dao.PersonDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    request.setCharacterEncoding("utf-8");
    String idx = request.getParameter("idx");
    Person p = PersonDAO.getInstance().getDetail(idx);
    pageContext.setAttribute("p",p);
    %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div {
	text-align: center;
	margin: 100px auto;
}
table,th,td{
padding:10px 5px;
border:1px solid pink;
border-collapse: collapse;
width:500px;
margin: auto;
}
input {
	padding:10px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<h2>개인정보 수정</h2>
<form method="post">
<table>
<tbody>
<tr>
<th style="width:40%">IDX</th><td> <input name="idx" type="text" value="${p.idx }"readonly="readonly"> </td>
</tr>
<tr>
<th>ID</th>
<td> <input type="text" name="id" value="${p.id }" readonly="readonly"></td>
</tr>
<tr>
<th>PW</th>
<td> <input type="password" name="pw"></td>
</tr>
<tr>
<th>NAME</th>
<td> <input type="text" name="name" value="${p.name }"></td>
</tr>
<tr>
<th>AGE</th>
<td> <input type="text" name="age" value="${p.age }"></td>
</tr>
<tr>
<th>ADDR</th>
<td> <input type="text" name="addr" value="${p.addr }"></td>
</tr>
<tr>
<th>REG</th>
<td> <input type="text" name="reg" value="${p.reg.substring(0,10) }" readonly="readonly"></td>
</tr>
</tbody>
<tfoot>
<tr>
<td colspan="2">
<input type="button" value="전체보기" onclick="list_go(this.form)">
<input type="button" value="수정하기" onclick="update_ok(this.form)">
</td>
</tr>
</tfoot>
</table>
</form>
</div>

<script type="text/javascript">
function list_go(f){
	f.action = "list.jsp";
	f.submit();
}
function update_ok(f){
	console.log("${param.pw}");
	console.log(f.pw.value);
	if("${param.pw}"==f.pw.value){
		f.action="update_ok.jsp";
		f.submit();
	}else{
		alert("비밀번호 틀림");
		f.pw.value="";
		f.pw.focus();
		f.submit();
	}
}
</script>

</body>
</html>