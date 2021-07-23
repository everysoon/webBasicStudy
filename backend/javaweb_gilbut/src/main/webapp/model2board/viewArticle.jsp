<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function fn_enable(obj){
	document.getElementById("i_title").disabled = false;
	document.getElementById("i_content").disabled = false;
	document.getElementById("i_imgFileName").disabled = false;
	document.getElementById("btn_modify").style.display = "block";
	document.getElementById("btn_tr").style.display = "none";
}
function fn_modify_article(obj){
	obj.action ="${contextPath}/board/modArticle.do";
	obj.submit();
}
function readURL(input) {
	if (input.files && input.files[0]) {
		console.log("input.files :"+input.files);
		var reader = new FileReader();
		reader.onload = function(e) {
			$("#preview").attr("src", e.target.result);
			console.log("e.target.result : "+e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}
}
function backToList(obj) {
	obj.action = "${contextPath}/board/listArticles.do";
	obj.submit();
}
function fn_remove_article(url,articleNO){
	var form = document.createElement("form"); // 자바스크립트를 통해 동적으로 form 생성
	form.setAttribute("method","post");
	form.setAttribute("action",url);
	var articleNOInput = document.createElement("input");// 자바스크립트를 통해 동적으로 input 생성
	articleNOInput.setAttribute("type","hidden");
	articleNOInput.setAttribute("name","articleNO");
	articleNOInput.setAttribute("value",articleNO);
	form.appendChild(articleNOInput); // 동적으로 생성한 input form에 장착
	document.body.appendChild(form); // 동적으로 생성한 form body에 장착
	form.submit();
}
function fn_reply_form(url,parentNO){
	var form = document.createElement("form"); // 자바스크립트를 통해 동적으로 form 생성
	form.setAttribute("method","post");
	form.setAttribute("action",url);
	var parentNOInput = document.createElement("input");// 자바스크립트를 통해 동적으로 input 생성
	parentNOInput.setAttribute("type","hidden");
	parentNOInput.setAttribute("name","parentNO");
	parentNOInput.setAttribute("value",parentNO);
	form.appendChild(parentNOInput); // 동적으로 생성한 input form에 장착
	document.body.appendChild(form); // 동적으로 생성한 form body에 장착
	form.submit();
}
</script>
<body>
<form name="viewForm" method="post" action="${contextPath }" enctype="multipart/form-data">
	<table border="0" align="center">
		<tr>
			<td width="150" align="center" bgcolor="pink">글번호</td>
			<td><input type="text" value="${article.articleNO }" disabled />
				<input type="hidden" value="${article.articleNO }" name="articleNO" />
			</td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="pink">작성자 아이디</td>
			<td><input type="text" value="${article.m_id }" name="id"
				disabled /></td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="pink">제목</td>
			<td><input type="text" value="${article.title }" name="title"
				id="i_title" disabled /></td>
		</tr>
		<tr>
			<td width="150" align="center" bgcolor="pink">내용</td>
			<td><textarea name="content" rows="20" cols="60" id="i_content"
					disabled>${article.content }</textarea></td>
		</tr>


		<c:if
			test="${not empty article.imgFileName && article.imgFileName!='null' }">
			<tr>
				<td width="20%" align="center" bgcolor="pink">이미지</td>
				<td><input type="hidden" name="originalFileName"
					value="${article.imgFileName }"> <img
					src="${contextPath }/download.do?imgFileName=${article.imgFileName}&articleNO=${article.articleNO}"
					id="preview"><br></td>
			</tr>
			<tr>
				<td><input type="file" name="imgFileName" id="i_imgFileName"
					disabled onchange="readURL(this)"></td>
			</tr>
		</c:if>
		<tr>
			<td width="20%" align="center" bgcolor="pink">등록일자</td>
			<td><input type="text"
				value="<fmt:formatDate value='${article.writedate }'/>" disabled /></td>
		</tr>
		<tr id="btn_modify">
			<td colspan="2" align="center"><input type="button"
				value="수정반영하기" onclick="fn_modify_article(viewForm)" /> <input type="button"
				value="취소" onclick="backToList(viewForm)" /></td>
		</tr>
		<tr id="btn_tr">
			<td colspan="2" align="center">
			<input type="button" value="수정하기"onclick="fn_enable(this.form)" />
				 <input type="button" value="삭제하기"
				onclick="fn_remove_article('${contextPath}/board/removeArticle.do',${article.articleNO })" />
				<input type="button" value="목록으로" onclick="backToList(this.form)" /> 
				<input type="button" value="답글쓰기" onclick="fn_reply_form('${contextPath}/board/replyForm.do',${article.articleNO })" />

			</td>
		</tr>
	</table>
	</form>
</body>
</html>