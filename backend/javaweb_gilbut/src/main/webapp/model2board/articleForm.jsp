<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jqeury.com/jqeury-latest.min.js"></script>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
</script>
<style type="text/css">
h1 {
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>새 글 쓰기</h1>
	<form method="post" action="${contextPath }/board/addArticle.do"
		enctype="multipart/form-data">
		<table border="0" align="center">
			<tr>
				<td align="right">글 제목 :</td>
				<td colspan="2"><input type="text" size="67" maxlength="500"
					name="title" /></td>
			</tr>
			<tr>
				<td align="right" valign="top">글 내용 :</td>
				<td colspan="2"><input type="textarea" row="10" cols="65"
					maxlength="4000" name="content" /></td>
			</tr>
			<tr>
				<td align="right">이미지파일 첨부 :</td>
				<td colspan="2"><input type="file" onchange="readURL(this);"
					name="imgFileName" /></td>
				<td><img id="preview" src="#" width="200" height="200" /></td>
			</tr>
			<tr>
				<td align="right"></td>
				<td colspan="2"><input type="submit" value="글쓰기" /> <input
					type="button" value="목록보기" onclick="backToList(this.form)" /></td>
			</tr>
		</table>
	</form>
</body>
</html>