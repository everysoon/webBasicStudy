<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<td width="20%" align="center" bgcolor="pink">글 제목</td>
<td><input type="text" value="${article.title }" name="title" id="i_title" disabled/></td>
</tr>
<tr>
<td width="20%" align="center" bgcolor="pink">글 내용</td>
<td><textarea rows="20" cols="60" name="content" id="i_content" disabled>${article.content }</textarea></td>
</tr>
<c:if test="${not empty article.imgFileName && article.imgFileName!='null' }">
<tr>
<td width="20%" align="center" bgcolor="pink">이미지</td>
<td>
<input type="hidden" name="originalFileName" value="${article.imgFileName }">
<img src="${contextPath }/download.do?imgFileName=${article.imgFileName}&articleNO=${article.articleNO}" id="preview"><br>
</td>
</tr>
</c:if>
</table>
</body>
</html>