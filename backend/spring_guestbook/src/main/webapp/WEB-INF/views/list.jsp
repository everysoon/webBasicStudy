<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
<h1>방명록</h1>
<br>방명록 전체수 : ${count } , 방문자수 : ${cookieCount }
<br>
<br>
<c:forEach items="${list }" var="guestbook">
${guestbook.id }<br>
${guestbook.name }<br>
${guestbook.content }<br>
${guestbook.regdate }<br>
<c:if test="${sessionScope.isAdmin == 'true' }">
<a href="delete?id=${guestbook.id }">삭제</a>
</c:if>
</c:forEach>
<br>
<c:forEach items="${pageStartList }" var="pageIndex" varStatus="status">
<a href="list?start=${pageIndex}">${status.index +1 }</a>&nbsp; &nbsp;
</c:forEach>
<br>
<br>
<form action="write" method="post">
name : <input type="text" name="name"><br>
<textarea rows="6" cols="60" name="content"></textarea>
<br>
<input type="submit" value="작성">
</form>
<c:if test="${registerFail } eq 'true'">
<h1>login 실패</h1>
</c:if>
</body>
</html>