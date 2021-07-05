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
<br>방명록 전체수 : ${count }
<br>
<br>
<c:forEach items="${list }" var="guestbook">
${guestbook.id }<br>
${guestbook.name }<br>
${guestbook.content }<br>
${guestbook.regdate }<br>

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

</body>
</html>