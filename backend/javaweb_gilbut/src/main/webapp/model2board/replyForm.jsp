<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center
}
</style>
<script type="text/javascript">
	function readURL(input) {
		if (input.files && input.files[0]) {
			console.log("input.files :" + input.files);
			var reader = new FileReader();
			reader.onload = function(e) {
				$("#preview").attr("src", e.target.result);
				console.log("e.target.result : " + e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}
	function backToList(obj) {
		obj.action = "${contextPath}/board/listArticles.do";
		obj.submit();
	}
</script>
</head>
<body>
	<h1>답글 쓰기</h1>
	<form action="${contextPath }/board/addReply.do" method="post"
		name="replyForm" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td align="right">글쓴이 : &nbsp;</td>
				<td><input type="text" size="5" value="soon" disabled /></td>
			</tr>
			<tr>
				<td align="right">글제목 : &nbsp;</td>
				<td><input type="text" size="67" maxlength="100" name="title" />
				</td>
			</tr>
			<tr>
				<td align="right">글내용 : &nbsp;</td>
				<td><textarea type="text" rows="10" cols="65" maxlength="4000"
						name="content" ></textarea></td>
			</tr>
			<tr>
				<td align="right">이미지첨부 : &nbsp;</td>
				<td><input type="file" name="imgFileName"
					onchange="readURL(this)" /></td>
				<td><img src="#" id="preview" width="200" height="200" /></td>
			</tr>
			<tr >
			<td align="right"></td>
			<td>
			<input type="submit" value="답글반영하기"/>
			<input type="button" value="취소" onclick="backToList(this.form)"/>
			</td>
			</tr>
		</table>
	</form>
</body>
</html>